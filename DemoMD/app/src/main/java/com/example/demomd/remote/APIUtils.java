package com.example.demomd.remote;

import com.example.demomd.service.ProjectService;

public class APIUtils {

    private APIUtils(){}

    public static final String BASE_URL = "http://192.168.0.4:8080/api/";

    public static ProjectService getProjectService() {
        return RetrofitClient.getClient(BASE_URL).create(ProjectService.class);
    }
}
