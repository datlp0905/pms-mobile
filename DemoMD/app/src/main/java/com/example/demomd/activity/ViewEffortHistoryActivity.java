package com.example.demomd.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.demomd.R;
import com.example.demomd.activity.custom.CustomListEffortStatus;

public class ViewEffortHistoryActivity extends AppCompatActivity {

    String[] date = {"12-01-1998", "27-06-2019", "28-06-2019", "29-06-2019", "30-06-2019"};
    Float[] calendarEffort = {Float.valueOf(50), Float.valueOf(50), Float.valueOf(50), Float.valueOf(50), Float.valueOf(50)};
    Float[] acturalEffort = {Float.valueOf(53), Float.valueOf(69), Float.valueOf(21), Float.valueOf(35), Float.valueOf(77)};
    Float[] buiableEffort = {Float.valueOf(38), Float.valueOf(66), Float.valueOf(35), Float.valueOf(5), Float.valueOf(12)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_effort_history);

        //Custom list effort status
        ListView listView = (ListView) findViewById(R.id.listEffortStatus);
        CustomListEffortStatus customListEffortStatus = new CustomListEffortStatus(this, date, calendarEffort, acturalEffort, buiableEffort);
        listView.setAdapter(customListEffortStatus);

    }
}
