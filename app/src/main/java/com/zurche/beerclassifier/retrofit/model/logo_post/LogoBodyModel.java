package com.zurche.beerclassifier.retrofit.model.logo_post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alejandro.zurcher on 2/6/2017.
 */

public class LogoBodyModel {

    @SerializedName("requests")
    @Expose
    private List<Request> requests = null;

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

}
