
package com.zurche.beerclassifier.retrofit.model.logo_response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vertex {

    @SerializedName("x")
    @Expose
    private int x;
    @SerializedName("y")
    @Expose
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
