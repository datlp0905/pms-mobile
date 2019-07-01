package com.example.demomd.model;

import com.example.demomd.data.ProjectResponse;
import com.example.demomd.remote.APIUtils;
import com.example.demomd.service.PmsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowListProjectModelImpl implements ShowListProjectModel{

    private PmsService pmsService;

    @Override
    public void getAllCurrentProject(final OnFinishListener finishListener, String employeeId) {
        pmsService = APIUtils.getPMSService();
        Call<List<ProjectResponse>> call = pmsService.getAllProjectByEmployeeId(employeeId);
        call.enqueue(new Callback<List<ProjectResponse>>() {
            @Override
            public void onResponse(Call<List<ProjectResponse>> call, Response<List<ProjectResponse>> response) {
                finishListener.onFinish(response.body());
            }

            @Override
            public void onFailure(Call<List<ProjectResponse>> call, Throwable t) {
                finishListener.onFailure(t);
            }
        });
    }
}
