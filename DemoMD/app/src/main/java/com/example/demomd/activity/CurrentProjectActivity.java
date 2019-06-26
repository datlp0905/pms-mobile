package com.example.demomd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.demomd.R;
import com.example.demomd.activity.custom.CustomListProjectView;
import com.example.demomd.data.ProjectResponse;
import com.example.demomd.presenter.ShowListProjectPresenter;
import com.example.demomd.presenter.ShowListProjectPresenterImpl;
import com.example.demomd.view.ShowListProjectView;

import java.util.List;

public class CurrentProjectActivity extends AppCompatActivity implements ShowListProjectView {

    ListView listView;
    private ShowListProjectPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_project);
        listView = (ListView) findViewById(R.id.listProjects);
        presenter = new ShowListProjectPresenterImpl(this);
        presenter.getListProjectByEmployeeId("ADMIN");
    }

    @Override
    public void setListProjectToView(final List<ProjectResponse> responses) {
        CustomListProjectView customListProjectView = new CustomListProjectView(this, responses);
        listView.setAdapter(customListProjectView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CurrentProjectActivity.this, ProjectDetailActivity.class);
                ProjectResponse projectResponse = responses.get(position);
                intent.putExtra("projectDetail", projectResponse);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_LONG).show();
    }
}
