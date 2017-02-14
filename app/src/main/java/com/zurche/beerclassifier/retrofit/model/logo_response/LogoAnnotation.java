
package com.zurche.beerclassifier.retrofit.model.logo_response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogoAnnotation {

    @SerializedName("mid")
    @Expose
    private String mid;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("score")
    @Expose
    private double score;
    @SerializedName("boundingPoly")
    @Expose
    private BoundingPoly boundingPoly;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public BoundingPoly getBoundingPoly() {
        return boundingPoly;
    }

    public void setBoundingPoly(BoundingPoly boundingPoly) {
        this.boundingPoly = boundingPoly;
    }

}
