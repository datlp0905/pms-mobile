package com.example.demomd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.demomd.R;
import com.example.demomd.activity.custom.CustomProjectMemberView;

public class ProjectDetailActivity extends AppCompatActivity {
    //    Dialog dlInputEffort;
    private String selectSpinner;
    private Button btnDeclareEffort;

    String[] projectMemberName = {"John Cenna", "Shauna Vayne", "Khadar Jhin ", "Anna", "Henry"};
    String[] roleInProject = {"Project Manager", "Developer", "Developer", "Developer", "Developer"};
    Integer[] img = {R.drawable.ic_person_black_50dp, R.drawable.ic_person_black_50dp, R.drawable.ic_person_black_50dp, R.drawable.ic_person_black_50dp, R.drawable.ic_person_black_50dp};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

//        dlInputEffort = new Dialog(ProjectDetailActivity.this);

        //Custom list project member
        TextView txtNameProject = findViewById(R.id.txtNameProject);
        txtNameProject.setText("Project Name");
        ListView listView = (ListView) findViewById(R.id.listProjectMember);
        CustomProjectMemberView customProjectMemberView = new CustomProjectMemberView(this, projectMemberName, roleInProject, img);
        listView.setAdapter(customProjectMemberView);

        //openDiablog
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
