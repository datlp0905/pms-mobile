package com.example.demomd.view;

import com.example.demomd.data.ProjectResponse;

import java.util.List;

public interface ShowListProjectView {

    void setListProjectToView(List<ProjectResponse> responses);
    void onResponseFailure(Throwable throwable);
}
