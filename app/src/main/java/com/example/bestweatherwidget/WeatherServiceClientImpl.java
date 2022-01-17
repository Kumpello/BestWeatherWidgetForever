package com.example.bestweatherwidget;

import com.example.bestweatherwidget.Utils.OnResult;
import com.example.bestweatherwidget.Utils.WeatherData;
import com.example.bestweatherwidget.Utils.WeatherResponse;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherServiceClientImpl implements WeatherServiceClient {
    WeatherService service;

    @Inject
    public WeatherServiceClientImpl() {
        OkHttpClient httpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.met.no/weatherapi/locationforecast/2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
        service = retrofit.create(WeatherService.class);
    }

    public void getWeatherData(Double lat, Double lon, Double alt, OnResult<WeatherData> handler) {
        try {
            Response<WeatherResponse> response = service.getComplete(lat, lon, alt).execute();
            WeatherData weatherData = response.body().getResults();
            handler.onSuccess(weatherData);
        } catch (IOException e) {
            handler.onError(e);
        }
    }


}
