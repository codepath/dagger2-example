package com.codepath.daggerexample;

import com.codepath.daggerexample.di.components.DaggerGitHubComponent;
import com.codepath.daggerexample.di.components.DaggerNetComponent;
import com.codepath.daggerexample.di.components.GitHubComponent;
import com.codepath.daggerexample.di.components.NetComponent;
import com.codepath.daggerexample.di.modules.AppModule;
import com.codepath.daggerexample.di.modules.GitHubModule;
import com.codepath.daggerexample.di.modules.NetModule;

import android.app.Application;

public class MyApp extends Application {

    private NetComponent mNetComponent;
    private GitHubComponent mGitHubComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // specify the full namespace of the component
        // Dagger_xxxx (where xxxx = component name)
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com"))
                .build();

        mGitHubComponent = DaggerGitHubComponent.builder()
                .netComponent(mNetComponent)
                .gitHubModule(new GitHubModule())
                .build();

    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public GitHubComponent getGitHubComponent() {
        return mGitHubComponent;
    }
}