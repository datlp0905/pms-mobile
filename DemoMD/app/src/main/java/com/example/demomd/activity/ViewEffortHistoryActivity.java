package com.example.demomd.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.demomd.R;
import com.example.demomd.activity.custom.CustomListEffortStatus;
import com.example.demomd.data.EffortResponse;
import com.example.demomd.presenter.ViewEffortHistoryPresenter;
import com.example.demomd.presenter.ViewEffortHistoryPresenterImpl;
import com.example.demomd.view.ViewEffortHistoryView;

import java.util.List;

public class ViewEffortHistoryActivity extends AppCompatActivity implements ViewEffortHistoryView {

    private ViewEffortHistoryPresenter presenter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_effort_history);

        listView = findViewById(R.id.listEffortStatus);

        presenter = new ViewEffortHistoryPresenterImpl(this);
        presenter.getEffortOfCurrentWeekFromServer(1);
    }

    @Override
    public void setListEffortToView(List<EffortResponse> listEffort) {
        //Custom list effort status
        CustomListEffortStatus customListEffortStatus = new CustomListEffortStatus(this, listEffort);
        listView.setAdapter(customListEffortStatus);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(this, "Error: " + throwable.getMessage(), Toast.LENGTH_LONG).show();
    }
}
