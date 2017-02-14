package com.zurche.beerclassifier.retrofit.service;

import com.zurche.beerclassifier.retrofit.model.logo_post.LogoBodyModel;
import com.zurche.beerclassifier.retrofit.model.logo_response.LogoResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by alejandro.zurcher on 2/6/2017.
 */

public interface VisionApiService {

    @POST("?key=ADD_YOUR_OWN_API_KEY_HERE")
    Call<LogoResponse> checkImageLogo(@Body LogoBodyModel logoBodyModel);

}
