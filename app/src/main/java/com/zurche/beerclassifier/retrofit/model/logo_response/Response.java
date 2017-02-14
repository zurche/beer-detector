
package com.zurche.beerclassifier.retrofit.model.logo_response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("logoAnnotations")
    @Expose
    private List<LogoAnnotation> logoAnnotations = null;

    public List<LogoAnnotation> getLogoAnnotations() {
        return logoAnnotations;
    }

    public void setLogoAnnotations(List<LogoAnnotation> logoAnnotations) {
        this.logoAnnotations = logoAnnotations;
    }

}
