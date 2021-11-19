package com.example.bestweatherwidget.Utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("instant")
    @Expose
    private Instant instant;

    public Instant getInstant() {
        return instant;
    }
}
