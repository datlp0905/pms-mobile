package com.example.demomd.service;

import com.example.demomd.data.ProjectResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProjectService {

    @GET("projects/without-paging")
    Call<List<ProjectResponse>> getAllProject();
}
