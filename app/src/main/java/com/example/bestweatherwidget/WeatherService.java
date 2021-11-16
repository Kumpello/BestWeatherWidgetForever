package com.example.bestweatherwidget;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface WeatherService {
    @Headers("BestWeatherWidgetForever github.com/Kumpello")
    @GET("/complete?lat={lat}}&lon={lon}&altitude={alt}")
    Call<List<JSONObject>> getComplete(@Path("lat") Double lat, @Path("lon") Double lon, @Path("alt") Double alt);

}
