package com.example.demomd.presenter;

import com.example.demomd.data.MemberInProjectResponse;
import com.example.demomd.data.ProjectMemberResponse;
import com.example.demomd.model.ProjectDetailModel;
import com.example.demomd.model.ProjectDetailModelImpl;
import com.example.demomd.view.ProjectDetailView;

import java.util.List;

public class ProjectDetailPresenterImpl implements ProjectDetailPresenter, ProjectDetailModel.OnFinishListener {
    private ProjectDetailView view;
    private ProjectDetailModel model;

    public ProjectDetailPresenterImpl(ProjectDetailView view) {
        this.view = view;
        this.model = new ProjectDetailModelImpl();
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void getListEmployeeInProject(int projectId) {
        model.getListEmployeeInProject(this, projectId);
    }

    @Override
    public void getProjectDetail(int projectId, String employeeId) {
        model.getProjectDetail(this, projectId, employeeId);
    }

    @Override
    public void onFinished(ProjectMemberResponse projectMemberResponse) {
        view.setProjectDetailToView(projectMemberResponse);
    }

    @Override
    public void onFinished(List<MemberInProjectResponse> listMemberInProject) {
        view.setListEmployeeInProjectToView(listMemberInProject);
    }

    @Override
    public void onFailure(Throwable throwable) {
        view.onResponseFailure(throwable);
    }
}
