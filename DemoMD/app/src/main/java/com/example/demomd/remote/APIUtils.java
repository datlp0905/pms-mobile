package com.example.demomd.remote;


import com.example.demomd.service.PmsService;

public class APIUtils {

    private APIUtils(){}

    public static final String BASE_URL = "http://172.20.10.3:8080/api/";;//"http://172.20.10.3:8080/api/";//"http://192.168.0.4:8080/api/";

    public static PmsService getPMSService() {
        return RetrofitClient.getClient(BASE_URL).create(PmsService.class);
    }
}
