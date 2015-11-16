package com.codepath.daggerexample.network;

import com.codepath.daggerexample.models.Repository;
import com.codepath.daggerexample.network.interfaces.GitHubApiInterface;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class GitHubApi {

    Retrofit mRetrofit;

    GitHubApiInterface mApiInterface;

    public interface ResponseHandler {
        public void onResponse(Object data);
        public void onFailure();
    }

    public GitHubApi(Retrofit retrofit) {
        mRetrofit = retrofit;
        mApiInterface = retrofit.create(GitHubApiInterface.class);
    }

    public void getRepos(String orgName, final ResponseHandler responseHandler) {
        Call<ArrayList<Repository>> call = mApiInterface.getRepository(orgName);

        call.enqueue(new Callback<ArrayList<Repository>>() {
            @Override
            public void onResponse(Response<ArrayList<Repository>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    responseHandler.onResponse(response.body());
                } else {
                    responseHandler.onFailure();
                }

            }

            @Override
            public void onFailure(Throwable t) {
                responseHandler.onFailure();
            }
        });
    }
}
