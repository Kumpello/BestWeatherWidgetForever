package com.example.bestweatherwidget.Utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class Instant {
    @SerializedName("details")
    @Expose
    private HashMap<String, Float> details;

    public HashMap<String, Float> getDetails() {
        return details;
    }
}
