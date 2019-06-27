package com.example.demomd.view;

import com.example.demomd.data.MemberInProjectResponse;
import com.example.demomd.data.ProjectMemberResponse;

import java.util.List;

public interface ProjectDetailView {
    void setListEmployeeInProjectToView(List<MemberInProjectResponse> listEmployeeInProject);
    void setProjectDetailToView(ProjectMemberResponse projectMemberResponse);
    void onResponseFailure(Throwable throwable);
}
