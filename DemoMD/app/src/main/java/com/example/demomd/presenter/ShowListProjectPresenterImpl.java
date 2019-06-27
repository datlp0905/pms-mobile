package com.example.demomd.presenter;

import com.example.demomd.data.ProjectResponse;
import com.example.demomd.model.ShowListProjectModel;
import com.example.demomd.model.ShowListProjectModelImpl;
import com.example.demomd.view.ShowListProjectView;

import java.util.List;

public class ShowListProjectPresenterImpl implements ShowListProjectPresenter, ShowListProjectModel.OnFinishListener {

    private ShowListProjectModel model;
    private ShowListProjectView view;

    public ShowListProjectPresenterImpl(ShowListProjectView view) {
        this.model = new ShowListProjectModelImpl();
        this.view = view;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void getListProjectByEmployeeId(String employeeId) {
        model.getAllCurrentProject(this, employeeId);
    }

    @Override
    public void onFinish(List<ProjectResponse> responses) {
        view.setListProjectToView(responses);
    }

    @Override
    public void onFailure(Throwable throwable) {
        view.onResponseFailure(throwable);
    }
}
