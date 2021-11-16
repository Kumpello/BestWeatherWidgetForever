package com.example.bestweatherwidget;

import com.example.bestweatherwidget.Utils.OnResult;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherServiceClientImpl {
    WeatherService service;

    public WeatherServiceClientImpl() {
        OkHttpClient httpClient = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.met.no/weatherapi/locationforecast/2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
        service = retrofit.create(WeatherService.class);
    }

    public void getWeatherData(Double lat, Double lon, Double alt, OnResult<List<JSONObject>> handler) {
        try {
            Response<List<JSONObject>> response = service.getComplete(lat, lon, alt).execute();
            List<JSONObject> weatherData = response.body();
            handler.onSuccess(weatherData);
        } catch (IOException e) {
            handler.onError(e);
        }
    }


}
