package com.example.demomd.activity.custom;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.demomd.R;
import com.example.demomd.data.EffortResponse;

import java.text.SimpleDateFormat;
import java.util.List;

public class CustomListEffortStatus extends ArrayAdapter<EffortResponse> {

    private List<EffortResponse> listEffort;
    private Activity context;

    public CustomListEffortStatus(Activity context, List<EffortResponse> listEffort) {
        super(context, R.layout.custom_project_member, listEffort);
        this.context = context;
        this.listEffort = listEffort;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            convertView = layoutInflater.inflate(R.layout.custom_list_effort_status, null, true);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        EffortResponse effort = listEffort.get(position);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        viewHolder.txtDateInputHolder.setText("Date: " + sdf.format(effort.getReportDate()));
        viewHolder.txtCalendarEffortHolder.setText("Calendar Effort: "  + effort.getCalendarEffort());
        viewHolder.txtActuralEffortHolder.setText("Actural Effort: "    + effort.getActualEffort());
        viewHolder.txtBuiableEffortHolder.setText("Buiable Effort: "    + effort.getBuildableEffort());
        String status = "";
        switch(effort.getStatus()) {
            case -1:
                status = "Rejected";
                break;
            case 0:
                status = "Pending";
                break;
            case 1:
                status = "Approved";
                break;
        }
        viewHolder.txtStatus.setText(status);
        return convertView;

    }

    class ViewHolder {
        TextView txtDateInputHolder;
        TextView txtCalendarEffortHolder;
        TextView txtActuralEffortHolder;
        TextView txtBuiableEffortHolder;
        TextView txtStatus;

        ViewHolder(View v) {
            txtDateInputHolder      = v.findViewById(R.id.txtDateInput);
            txtCalendarEffortHolder = v.findViewById(R.id.txtCalendarEffort);
            txtActuralEffortHolder  = v.findViewById(R.id.txtActuralEffort);
            txtBuiableEffortHolder  = v.findViewById(R.id.txtBuiableEffort);
            txtStatus               = v.findViewById(R.id.txtStatus);
        }
    }
}
