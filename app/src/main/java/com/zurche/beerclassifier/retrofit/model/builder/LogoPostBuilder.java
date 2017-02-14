package com.zurche.beerclassifier.retrofit.model.builder;

import com.zurche.beerclassifier.retrofit.model.logo_post.Feature;
import com.zurche.beerclassifier.retrofit.model.logo_post.Image;
import com.zurche.beerclassifier.retrofit.model.logo_post.LogoBodyModel;
import com.zurche.beerclassifier.retrofit.model.logo_post.Request;

import java.util.ArrayList;

/**
 * Created by alejandro.zurcher on 2/6/2017.
 */

public class LogoPostBuilder {

    public static LogoBodyModel buildLogoDetectionBody(String image) {
        LogoBodyModel logoBodyModel = new LogoBodyModel();

        ArrayList<Feature> features = new ArrayList<>();
        features.add(new Feature("LOGO_DETECTION", 1));

        Request requests = new Request();
        requests.setFeatures(features);
        requests.setImage(new Image(image));
        ArrayList<Request> requestsList = new ArrayList<Request>();
        requestsList.add(requests);

        logoBodyModel.setRequests(requestsList);

        return logoBodyModel;
    }

}
