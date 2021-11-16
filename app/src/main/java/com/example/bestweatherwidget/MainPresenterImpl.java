package com.example.bestweatherwidget;

import android.app.Activity;

public class MainPresenterImpl implements MainPresenter {

    Activity activity;
    LocationService locationService;
    WeatherService weatherService;

    public MainPresenterImpl(Activity activity, LocationService locationService, WeatherService weatherService) {
        this.activity = activity;
        this.locationService = locationService;
        this.weatherService = weatherService;
    }
}
