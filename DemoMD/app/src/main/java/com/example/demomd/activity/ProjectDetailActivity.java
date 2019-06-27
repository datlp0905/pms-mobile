package com.example.demomd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demomd.R;
import com.example.demomd.activity.custom.CustomProjectMemberView;
import com.example.demomd.data.MemberInProjectResponse;
import com.example.demomd.data.ProjectMemberResponse;
import com.example.demomd.data.ProjectResponse;
import com.example.demomd.presenter.ProjectDetailPresenter;
import com.example.demomd.presenter.ProjectDetailPresenterImpl;
import com.example.demomd.view.ProjectDetailView;

import java.text.SimpleDateFormat;
import java.util.List;

public class ProjectDetailActivity extends AppCompatActivity implements ProjectDetailView {
    private String selectSpinner;
    private Button btnDeclareEffort;
    private ProjectResponse projectDetail;
    private EditText edtStartDate, edtEndDate, edtStatus;
    private TextView txtProjectName;
    private ListView listView;
    private ProjectDetailPresenter presenter;

    public int projectMemberId;
    Integer[] img = {R.drawable.ic_person_black_25dp, R.drawable.ic_person_black_25dp, R.drawable.ic_person_black_25dp, R.drawable.ic_person_black_25dp, R.drawable.ic_person_black_25dp};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        Intent intent = getIntent();
        projectDetail = (ProjectResponse) intent.getSerializableExtra("projectDetail");

        presenter = new ProjectDetailPresenterImpl(this);
        presenter.getListEmployeeInProject(projectDetail.getId());
        presenter.getProjectDetail(projectDetail.getId(), "ADMIN");

        edtStartDate    = findViewById(R.id.edtStartDate);
        edtEndDate      = findViewById(R.id.edtEndDate);
        edtStatus       = findViewById(R.id.edtStatus);
        listView        = findViewById(R.id.listProjectMember);
        txtProjectName  = findViewById(R.id.txtNameProject);
        btnDeclareEffort = findViewById(R.id.btnDeclareEffort);

        btnDeclareEffort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogInputEffort();
            }
        });
    }

    public void openDialogInputEffort() {
        InputEffortDialog inputEffortDialog = new InputEffortDialog();
        Bundle bundle = new Bundle();
        bundle.putInt("projectMemberId", projectMemberId);
        inputEffortDialog.setArguments(bundle);
        inputEffortDialog.show(getSupportFragmentManager(), "input effort");
    }

    public void clickToMoveToDashBoard(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void setListEmployeeInProjectToView(List<MemberInProjectResponse> listEmployeeInProject) {
        CustomProjectMemberView customProjectMemberView = new CustomProjectMemberView(this, listEmployeeInProject, img);
        listView.setAdapter(customProjectMemberView);
    }

    @Override
    public void setProjectDetailToView(ProjectMemberResponse projectMemberResponse) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        projectMemberId = projectMemberResponse.getId();
        txtProjectName.setText(projectMemberResponse.getProject().getName());
        edtStartDate.setText(sdf.format(projectMemberResponse.getProject().getStartDate()));
        edtEndDate.setText(sdf.format(projectMemberResponse.getProject().getEndDate()));
        edtStatus.setText(projectMemberResponse.getProject().getStatus().getName());
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(this, "Error: " + throwable.getMessage(), Toast.LENGTH_LONG).show();
    }
}
