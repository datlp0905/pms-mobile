package com.example.demomd.model;

import com.example.demomd.data.ProjectResponse;

import java.util.List;

public interface ShowListProjectModel {

    interface OnFinishListener {
        void onFinish(List<ProjectResponse> responses);
        void onFailure(Throwable throwable);
    }

    void getAllCurrentProject(OnFinishListener finishListener, String employeeId);
}
