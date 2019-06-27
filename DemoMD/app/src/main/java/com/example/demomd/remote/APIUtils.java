package com.example.demomd.remote;


import com.example.demomd.repository.PMSRepository;

public class APIUtils {

    private APIUtils(){}

    public static final String BASE_URL = "http://192.168.1.134:8080/api/";//"http://172.20.10.3:8080/api/";//"http://192.168.0.4:8080/api/";

    public static PMSRepository getPMSService() {
        return RetrofitClient.getClient(BASE_URL).create(PMSRepository.class);
    }
}
