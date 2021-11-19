package com.example.bestweatherwidget.Utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherResponse {
    @SerializedName("results")
    @Expose
    private WeatherData results;

    public WeatherData getResults() {
        return results;
    }

    @Override
    public String toString() {
        return results.toString();
    }
}
