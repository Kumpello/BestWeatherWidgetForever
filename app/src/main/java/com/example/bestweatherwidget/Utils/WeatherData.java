package com.example.bestweatherwidget.Utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherData {

    @SerializedName("timeseries")
    @Expose
    private ArrayList<WeatherDataPoint> timePoints;

    public ArrayList<WeatherDataPoint> getTimePoints() {
        return timePoints;
    }
}

