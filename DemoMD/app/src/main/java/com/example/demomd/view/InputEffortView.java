package com.example.demomd.view;

import com.example.demomd.data.EffortRequest;
import com.example.demomd.data.PositionResponse;

import java.util.List;

public interface InputEffortView {
    void setListPositionToView(List<PositionResponse> listPosition);
    void inputEffort(EffortRequest effortRequest);
    void onResponseFailure(Throwable throwable);
}
