package com.example.demomd.service;

import com.example.demomd.data.ProjectResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProjectMemberService {

    @GET("project-members")
    Call<List<ProjectResponse>> getAllProjectByEmployeeId(@Query("employeeID") String employeeId);
}
