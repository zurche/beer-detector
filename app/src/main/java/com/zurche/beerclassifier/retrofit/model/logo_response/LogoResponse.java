
package com.zurche.beerclassifier.retrofit.model.logo_response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogoResponse {

    @SerializedName("responses")
    @Expose
    private List<Response> responses = null;

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

}
