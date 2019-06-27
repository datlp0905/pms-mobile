package com.example.demomd.presenter;

import com.example.demomd.data.EffortRequest;

public interface InputEffortPresenter {
    void onDestroy();
    void getListPositionOfEmployee(int projectMemberId);
    void sendEffortToServer(EffortRequest effortRequest);
}
