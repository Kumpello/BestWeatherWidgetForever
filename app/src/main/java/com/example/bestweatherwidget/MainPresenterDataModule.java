package com.example.bestweatherwidget;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;

@Module
@InstallIn(MainPresenterImpl.class)
abstract public class MainPresenterDataModule {

    @Binds
    public abstract WeatherServiceClient bindWeatherServiceClient(WeatherServiceClientImpl impl);

    @Provides
    @Singleton
    public static LocationService provideLocationService(android.app.Application context) {
        return new LocationServiceImpl((Activity) context.getApplicationContext());
    }

}
