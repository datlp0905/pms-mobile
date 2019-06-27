package com.example.demomd.presenter;

import com.example.demomd.data.EffortRequest;
import com.example.demomd.data.PositionResponse;
import com.example.demomd.model.InputEffortModel;
import com.example.demomd.model.InputEffortModelImpl;
import com.example.demomd.view.InputEffortView;

import java.util.List;

public class InputEffortPresenterImpl implements InputEffortPresenter, InputEffortModel.OnFinishListener {
    private InputEffortModel model;
    private InputEffortView view;

    public InputEffortPresenterImpl(InputEffortView view) {
        this.view = view;
        this.model = new InputEffortModelImpl();
    }

    @Override
    public void onFinished(List<PositionResponse> listPositionResponse) {
        view.setListPositionToView(listPositionResponse);
    }

    @Override
    public void onFinished(EffortRequest effortRequest) {
        view.inputEffort(effortRequest);
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
    public void getListPositionOfEmployee(int projectMemberId) {
        model.getListPosition(this, projectMemberId);
    }

    @Override
    public void sendEffortToServer(EffortRequest effortRequest) {
        model.inputEffort(this, effortRequest);
    }
}
