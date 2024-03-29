package com.example.demomd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.demomd.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToMoveToMyProjects(View view) {
        Intent intent = new Intent(this, CurrentProjectActivity.class);
        startActivity(intent);
    }

    public void clickToViewEffortStatus(View view) {
        Intent intent = new Intent(this, ViewEffortHistoryActivity.class);
        startActivity(intent);
    }
}
