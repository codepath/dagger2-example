package com.codepath.daggerexample.network.interfaces;

import com.codepath.daggerexample.models.Repository;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface GitHubApiInterface {
    @GET("/org/{orgName}/repos")
    Call<ArrayList<Repository>> getRepository(@Path("orgName") String orgName);

}