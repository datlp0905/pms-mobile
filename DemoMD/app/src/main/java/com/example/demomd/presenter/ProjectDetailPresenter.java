package com.example.demomd.presenter;

public interface ProjectDetailPresenter {
    void onDestroy();
    void getListEmployeeInProject(int projectId);
    void getProjectDetail(int projectId, String employeeId);
}
