package com.example.bestweatherwidget;

import android.location.Location;

public interface LocationService {
    boolean locationCallbackReady();
    void updateLastLocation();
    Location getLocation();
    void startLocationUpdates();
    void stopLocationUpdates();
}
