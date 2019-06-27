package com.example.demomd.model;

import com.example.demomd.data.MemberInProjectResponse;
import com.example.demomd.data.ProjectMemberResponse;

import java.util.List;

public interface ProjectDetailModel {
    interface OnFinishListener {
        void onFinished(ProjectMemberResponse projectMemberResponse);
        void onFinished(List<MemberInProjectResponse> listMemberInProject);
        void onFailure(Throwable throwable);
    }

    void getProjectDetail(OnFinishListener finishListener, int projectId, String employeeID);
    void getListEmployeeInProject(OnFinishListener finishListener, int projectId);
}
