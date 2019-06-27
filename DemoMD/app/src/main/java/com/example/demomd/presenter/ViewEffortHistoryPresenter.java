package com.example.demomd.presenter;

public interface ViewEffortHistoryPresenter {
    void onDestroy();
    void getEffortOfCurrentWeekFromServer(int projectMemberId);
}
