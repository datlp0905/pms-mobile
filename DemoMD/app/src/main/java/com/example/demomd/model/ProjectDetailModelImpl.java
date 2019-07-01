package com.example.demomd.model;

import com.example.demomd.data.MemberInProjectResponse;
import com.example.demomd.data.ProjectMemberResponse;
import com.example.demomd.remote.APIUtils;
import com.example.demomd.service.PmsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectDetailModelImpl implements ProjectDetailModel {
    private PmsService pmsService;

    @Override
    public void getProjectDetail(final OnFinishListener finishListener, int projectId, String employeeID) {
        pmsService = APIUtils.getPMSService();
        Call<ProjectMemberResponse> call = pmsService.findByProjectIdAndEmployeeId(projectId, employeeID);
        call.enqueue(new Callback<ProjectMemberResponse>() {
            @Override
            public void onResponse(Call<ProjectMemberResponse> call, Response<ProjectMemberResponse> response) {
                finishListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<ProjectMemberResponse> call, Throwable t) {
                finishListener.onFailure(t);
            }
        });
    }

    @Override
    public void getListEmployeeInProject(final OnFinishListener finishListener, int projectId) {
        pmsService = APIUtils.getPMSService();
        Call<List<MemberInProjectResponse>> call = pmsService.getAllMemberInProject(projectId);
        call.enqueue(new Callback<List<MemberInProjectResponse>>() {
            @Override
            public void onResponse(Call<List<MemberInProjectResponse>> call, Response<List<MemberInProjectResponse>> response) {
                finishListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<List<MemberInProjectResponse>> call, Throwable t) {
                finishListener.onFailure(t);
            }
        });
    }
}
