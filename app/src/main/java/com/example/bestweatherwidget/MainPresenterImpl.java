package com.example.bestweatherwidget;

import android.app.Activity;
import android.location.Location;

public class MainPresenterImpl implements MainPresenter {

    Activity activity;
    LocationService locationService;
    WeatherServiceClient weatherService;
    Location currentLocation;

    public MainPresenterImpl(Activity activity, LocationService locationService, WeatherServiceClient weatherService) {
        this.activity = activity;
        this.locationService = locationService;
        this.weatherService = weatherService;

        locationService.startLocationUpdates();
    }

}
