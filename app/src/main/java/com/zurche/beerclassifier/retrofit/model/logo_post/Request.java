package com.zurche.beerclassifier.retrofit.model.logo_post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alejandro.zurcher on 2/6/2017.
 */

public class Request {

    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("features")
    @Expose
    private List<Feature> features = null;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

}
