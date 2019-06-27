package com.example.demomd.model;

import com.example.demomd.data.EffortResponse;

import java.util.List;

public interface ViewEffortHistoryModel {
    interface OnFinishListener {
        void onFinished(List<EffortResponse> listEffort);
        void onFailure(Throwable throwable);
    }

    void getAllEffortOfCurrentWeek(OnFinishListener finishListener, int projectMemberId);
}
