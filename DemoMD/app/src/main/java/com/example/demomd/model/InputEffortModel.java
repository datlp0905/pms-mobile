package com.example.demomd.model;

import com.example.demomd.data.EffortRequest;
import com.example.demomd.data.PositionResponse;

import java.util.List;

public interface InputEffortModel {
    interface OnFinishListener {
        void onFinished(List<PositionResponse> listPositionResponse);
        void onFinished(EffortRequest effortRequest);
        void onFailure(Throwable throwable);
    }

    void getListPosition(OnFinishListener finishListener, int projectMemberId);
    void inputEffort(OnFinishListener finishListener, EffortRequest effortRequest);
}
