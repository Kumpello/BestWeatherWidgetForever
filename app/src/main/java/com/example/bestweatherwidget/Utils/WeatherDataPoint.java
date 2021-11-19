package com.example.bestweatherwidget.Utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherDataPoint {
    @SerializedName("time")
    @Expose
    private String time;

    @SerializedName("data")
    @Expose
    private Data data;

    public String getTime() {
        return time;
    }

    public Data getData() {
        return data;
    }
}


