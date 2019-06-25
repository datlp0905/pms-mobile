package com.example.demomd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.demomd.R;
import com.example.demomd.activity.custom.CustomListProjectView;

public class CurrentProjectActivity extends AppCompatActivity {

    String[] items = {"User Managerments", "Binary Search Tree", "Linked List", "Portfolio Management System", "Book Ticket"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_project);

        //Custom list project
        ListView listView = (ListView) findViewById(R.id.listProjects);
        CustomListProjectView customListProjectView = new CustomListProjectView(this, items);
        listView.setAdapter(customListProjectView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CurrentProjectActivity.this, ProjectDetailActivity.class);
                startActivity(intent);
            }
        });
    }
}
