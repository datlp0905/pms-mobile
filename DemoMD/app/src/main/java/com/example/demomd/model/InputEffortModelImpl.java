package com.example.demomd.model;

import com.example.demomd.data.EffortRequest;
import com.example.demomd.data.PositionResponse;
import com.example.demomd.remote.APIUtils;
import com.example.demomd.repository.PMSRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InputEffortModelImpl implements InputEffortModel {
    private PMSRepository pmsRepository;

    @Override
    public void getListPosition(final OnFinishListener finishListener, int projectMemberId) {
        pmsRepository = APIUtils.getPMSService();
        Call<List<PositionResponse>> call = pmsRepository.getAllPositionOfEmployee(projectMemberId);
        call.enqueue(new Callback<List<PositionResponse>>() {
            @Override
            public void onResponse(Call<List<PositionResponse>> call, Response<List<PositionResponse>> response) {
                finishListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<List<PositionResponse>> call, Throwable t) {
                finishListener.onFailure(t);
            }
        });
    }

    @Override
    public void inputEffort(final OnFinishListener finishListener, final EffortRequest effortRequest) {
        pmsRepository = APIUtils.getPMSService();
        Call<EffortRequest> call = pmsRepository.inputEffort(effortRequest);
        call.enqueue(new Callback<EffortRequest>() {
            @Override
            public void onResponse(Call<EffortRequest> call, Response<EffortRequest> response) {
                finishListener.onFinished(effortRequest);
            }

            @Override
            public void onFailure(Call<EffortRequest> call, Throwable t) {
                finishListener.onFailure(t);
            }
        });
    }
}
