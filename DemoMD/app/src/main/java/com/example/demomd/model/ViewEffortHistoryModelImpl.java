package com.example.demomd.model;

import com.example.demomd.data.EffortResponse;
import com.example.demomd.remote.APIUtils;
import com.example.demomd.repository.PMSRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewEffortHistoryModelImpl implements ViewEffortHistoryModel {

    private PMSRepository pmsRepository;

    @Override
    public void getAllEffortOfCurrentWeek(final OnFinishListener finishListener, int projectMemberId) {
        pmsRepository = APIUtils.getPMSService();
        Call<List<EffortResponse>> call = pmsRepository.getAllEffortOfCurrentWeek(projectMemberId);
        call.enqueue(new Callback<List<EffortResponse>>() {
            @Override
            public void onResponse(Call<List<EffortResponse>> call, Response<List<EffortResponse>> response) {
                finishListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<List<EffortResponse>> call, Throwable t) {
                finishListener.onFailure(t);
            }
        });
    }
}
