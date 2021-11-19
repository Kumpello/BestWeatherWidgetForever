package com.example.bestweatherwidget;

import com.example.bestweatherwidget.Utils.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface WeatherService {
    @Headers("BestWeatherWidgetForever github.com/Kumpello")
    @GET("/complete?lat={lat}}&lon={lon}&altitude={alt}")
    Call<WeatherResponse> getComplete(@Path("lat") Double lat, @Path("lon") Double lon, @Path("alt") Double alt);

}
