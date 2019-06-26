package com.example.demomd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.demomd.R;
import com.example.demomd.activity.custom.CustomProjectMemberView;
import com.example.demomd.data.ProjectResponse;

import java.text.SimpleDateFormat;

public class ProjectDetailActivity extends AppCompatActivity {
    private String selectSpinner;
    private Button btnDeclareEffort;
    private ProjectResponse projectDetail;
    private EditText edtStartDate, edtEndDate, edtStatus;

    String[] projectMemberName = {"John Cenna", "Shauna Vayne", "Khadar Jhin ", "Anna", "Henry"};
    String[] roleInProject = {"Project Manager", "Developer", "Developer", "Developer", "Developer"};
    Integer[] img = {R.drawable.ic_person_black_50dp, R.drawable.ic_person_black_50dp, R.drawable.ic_person_black_50dp, R.drawable.ic_person_black_50dp, R.drawable.ic_person_black_50dp};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        Intent intent = getIntent();
        projectDetail = (ProjectResponse) intent.getSerializableExtra("projectDetail");

        edtStartDate    = findViewById(R.id.edtStartDate);
        edtEndDate      = findViewById(R.id.edtEndDate);
        edtStatus       = findViewById(R.id.edtStatus);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        edtStartDate.setText(sdf.format(projectDetail.getStartDate()));
        edtEndDate.setText(sdf.format(projectDetail.getEndDate()));
        edtStatus.setText(projectDetail.getStatus().getName());

        //Custom list project member
        TextView txtNameProject = findViewById(R.id.txtNameProject);
        txtNameProject.setText(projectDetail.getName());
        ListView listView = (ListView) findViewById(R.id.listProjectMember);
        CustomProjectMemberView customProjectMemberView = new CustomProjectMemberView(this, projectMemberName, roleInProject, img);
        listView.setAdapter(customProjectMemberView);

        //open Diablog InputEffort
        btnDeclareEffort = (Button) findViewById(R.id.btnDeclareEffort);
        btnDeclareEffort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogInputEffort();
            }
        });


    }

    public void openDialogInputEffort() {
        InputEffortDialog inputEffortDialog = new InputEffortDialog();
        inputEffortDialog.show(getSupportFragmentManager(), "input effort");

    }

    public void clickToMoveToDashBoard(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
