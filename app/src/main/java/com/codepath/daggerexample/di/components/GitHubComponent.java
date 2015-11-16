package com.codepath.daggerexample.di.components;

import com.codepath.daggerexample.MainActivity;
import com.codepath.daggerexample.di.modules.GitHubModule;
import com.codepath.daggerexample.di.scopes.UserScope;

import dagger.Component;

@UserScope
@Component(dependencies = NetComponent.class, modules = GitHubModule.class)
public interface GitHubComponent {
    void inject(MainActivity activity);
}
