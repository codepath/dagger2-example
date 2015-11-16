package com.codepath.daggerexample;

import com.codepath.daggerexample.di.components.DaggerNetComponent;
import com.codepath.daggerexample.di.components.NetComponent;
import com.codepath.daggerexample.di.modules.AppModule;
import com.codepath.daggerexample.di.modules.NetModule;

import android.app.Application;

public class MyApp extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // specify the full namespace of the component
        // Dagger_xxxx (where xxxx = component name)
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com"))
                .build();

    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}