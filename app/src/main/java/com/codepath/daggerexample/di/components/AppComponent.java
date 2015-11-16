package com.codepath.daggerexample.di.components;


import javax.inject.Singleton;

import com.codepath.daggerexample.MainActivity;
import com.codepath.daggerexample.di.modules.NetModule;
import dagger.Component;

@Singleton
@Component(modules={NetModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}