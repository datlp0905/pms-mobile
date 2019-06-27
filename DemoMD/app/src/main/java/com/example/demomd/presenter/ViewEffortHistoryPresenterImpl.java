package com.example.demomd.presenter;

import com.example.demomd.data.EffortResponse;
import com.example.demomd.model.ViewEffortHistoryModel;
import com.example.demomd.model.ViewEffortHistoryModelImpl;
import com.example.demomd.view.ViewEffortHistoryView;

import java.util.List;

public class ViewEffortHistoryPresenterImpl implements ViewEffortHistoryPresenter, ViewEffortHistoryModel.OnFinishListener {

    private ViewEffortHistoryModel model;
    private ViewEffortHistoryView view;

    public ViewEffortHistoryPresenterImpl(ViewEffortHistoryView view) {
        this.view = view;
        this.model = new ViewEffortHistoryModelImpl();
    }

    @Override
    public void onFinished(List<EffortResponse> listEffort) {
        view.setListEffortToView(listEffort);
    }

    @Override
    public void onFailure(Throwable throwable) {
        view.onResponseFailure(throwable);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void getEffortOfCurrentWeekFromServer(int projectMemberId) {
        model.getAllEffortOfCurrentWeek(this, projectMemberId);
    }
}
