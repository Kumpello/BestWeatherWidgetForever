package com.example.bestweatherwidget;

import static android.content.Context.SENSOR_SERVICE;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class LocationServiceImpl implements LocationService{

    private FusedLocationProviderClient fusedLocationClient;
    private Location userLocation;
    private LocationRequest userLocationRequest;
    private SensorManager sensorManager;
    private LocationCallback locationCallback;
    private boolean locationCallbackReady;
    private Activity activity;

    public LocationServiceImpl(Activity activity) {
        this.activity = activity;
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity);
        userLocationRequest = LocationRequest.create();
        int FASTEST_INTERVAL = 10000;
        userLocationRequest.setFastestInterval(FASTEST_INTERVAL);
        int INTERVAL = 30000;
        userLocationRequest.setInterval(INTERVAL);
        userLocationRequest.setPriority(LocationRequest.PRIORITY_LOW_POWER);
        sensorManager = (SensorManager) activity.getSystemService(SENSOR_SERVICE);
        locationCallbackReady = false;


        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                userLocation = locationResult.getLastLocation();
                locationCallbackReady = true;
            }
        };
    }

    public boolean locationCallbackReady(){
        return locationCallbackReady;
    }

    @SuppressLint("MissingPermission")
    public void updateLastLocation(){
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(activity, location -> {
                    if (location != null) {
                        userLocation = location;
                    }
                });
    }


    public Location getLocation() {
        return userLocation;
    }

    @SuppressLint("MissingPermission")
    public void startLocationUpdates() {
        fusedLocationClient.requestLocationUpdates(userLocationRequest,
                locationCallback,
                Looper.getMainLooper());
    }

    public void stopLocationUpdates() {
        fusedLocationClient.removeLocationUpdates(locationCallback);
    }

}
