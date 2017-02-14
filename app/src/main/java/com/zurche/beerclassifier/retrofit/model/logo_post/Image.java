package com.zurche.beerclassifier.retrofit.model.logo_post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alejandro.zurcher on 2/6/2017.
 */

public class Image {

    @SerializedName("content")
    @Expose
    private String content;

    public Image(String image) {
        this.content = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
