package com.codepath.daggerexample;

import com.codepath.daggerexample.di.components.AppComponent;
import com.codepath.daggerexample.di.modules.NetModule;

import android.app.Application;

public class MyApp extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // specify the full namespace of the component
        // Dagger_xxxx (where xxxx = component name)
        mAppComponent = com.codepath.daggerexample.di.components.DaggerAppComponent.builder()
                .netModule(new NetModule("https://api.github.com"))
                .build();

    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}