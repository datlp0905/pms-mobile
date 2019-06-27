package com.example.demomd.view;

import com.example.demomd.data.EffortResponse;

import java.util.List;

public interface ViewEffortHistoryView {
    void setListEffortToView(List<EffortResponse> listEffort);
    void onResponseFailure(Throwable throwable);
}
