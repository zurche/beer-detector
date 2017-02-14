package com.zurche.beerclassifier.retrofit.model.logo_post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alejandro.zurcher on 2/6/2017.
 */

public class Feature {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("maxResults")
    @Expose
    private Integer maxResults;

    public Feature(String type, int maxResults) {
        this.type = type;
        this.maxResults = maxResults;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

}
