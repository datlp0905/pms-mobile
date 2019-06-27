package com.example.demomd.repository;

import com.example.demomd.data.MemberInProjectResponse;
import com.example.demomd.data.ProjectMemberResponse;
import com.example.demomd.data.ProjectResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PMSRepository {

    @GET("project-members/projects")
    Call<List<ProjectResponse>> getAllProjectByEmployeeId(@Query("employeeID") String employeeId);

    @GET("project-members/members")
    Call<List<MemberInProjectResponse>> getAllMemberInProject(@Query("projectId") int projectId);

    @GET("project-members")
    Call<ProjectMemberResponse> findByProjectIdAndEmployeeId(@Query("projectId") int projectId, @Query("employeeId") String employeeId);
}