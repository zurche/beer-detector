package com.zurche.beerclassifier;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zurche.beerclassifier.retrofit.model.builder.LogoPostBuilder;
import com.zurche.beerclassifier.retrofit.model.logo_post.LogoBodyModel;
import com.zurche.beerclassifier.retrofit.model.logo_response.LogoResponse;
import com.zurche.beerclassifier.retrofit.service.VisionApiService;

import java.io.ByteArrayOutputStream;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private VisionApiService mService;

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private TextView textView;
    private Button retakePicture;
    private ImageView takenPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://vision.googleapis.com/v1/images:annotate/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        mService = retrofit.create(VisionApiService.class);

        textView = (TextView) findViewById(R.id.result);

        retakePicture = (Button) findViewById(R.id.take_new_picture);
        retakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });

        takenPicture = (ImageView) findViewById(R.id.taken_picture);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            takenPicture.setImageBitmap(imageBitmap);

            checkImageLogo(encodeImage(imageBitmap));
        }
    }

    private void checkImageLogo(String encodedImage) {
        LogoBodyModel logoBodyModel = LogoPostBuilder.buildLogoDetectionBody(encodedImage);

        Call<LogoResponse> checkImageCall = mService.checkImageLogo(logoBodyModel);
        checkImageCall.enqueue(new Callback<LogoResponse>() {
            @Override
            public void onResponse(Call<LogoResponse> call, Response<LogoResponse> response) {
                Log.d(TAG, "Got Response");
                if (response.body().getResponses() != null &&
                        response.body().getResponses().get(0).getLogoAnnotations() != null) {
                    Log.d(TAG, "It's a: " + response.body().getResponses().get(0).getLogoAnnotations().get(0).getDescription());
                    Log.d(TAG, "With a Score of: " + response.body().getResponses().get(0).getLogoAnnotations().get(0).getScore());

                    textView.setText(response.body().getResponses().get(0).getLogoAnnotations().get(0).getDescription());
                } else {
                    Log.d(TAG, "Empty response");
                    textView.setText("No idea!");
                }
            }

            @Override
            public void onFailure(Call<LogoResponse> call, Throwable t) {
                Log.e(TAG, "Response Failed");
                t.printStackTrace();
            }
        });
    }

    private String encodeImage(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] byteArray = baos.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

}
