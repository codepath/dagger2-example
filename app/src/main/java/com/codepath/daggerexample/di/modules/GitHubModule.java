package com.codepath.daggerexample.di.modules;

import com.codepath.daggerexample.di.scopes.UserScope;
import com.codepath.daggerexample.network.interfaces.GitHubApiInterface;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

@Module
public class GitHubModule {

    @Provides
    @UserScope
    public GitHubApiInterface providesGitHubInterface(Retrofit retrofit) {
        return retrofit.create(GitHubApiInterface.class);
    }
}
