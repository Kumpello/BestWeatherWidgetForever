package com.example.bestweatherwidget;

import android.app.Activity;
import android.location.Location;

import javax.inject.Inject;

public class MainPresenterImpl implements MainPresenter {

    @Inject
    Activity activity;
    @Inject
    LocationService locationService;
    @Inject
    WeatherServiceClient weatherService;
    Location currentLocation;

    @Inject
    public MainPresenterImpl(Activity activity, LocationService locationService, WeatherServiceClient weatherService) {
        this.activity = activity;
        this.locationService = locationService;
        this.weatherService = weatherService;

        locationService.startLocationUpdates();
    }

}
