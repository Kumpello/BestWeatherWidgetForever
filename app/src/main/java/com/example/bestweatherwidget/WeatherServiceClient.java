package com.example.bestweatherwidget;

import com.example.bestweatherwidget.Utils.OnResult;
import com.example.bestweatherwidget.Utils.WeatherData;

public interface WeatherServiceClient {
    void getWeatherData(Double lat, Double lon, Double alt, OnResult<WeatherData> handler);
}
