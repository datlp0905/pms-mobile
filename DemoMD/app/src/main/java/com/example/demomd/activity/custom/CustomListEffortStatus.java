package com.example.demomd.activity.custom;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.demomd.R;

public class CustomListEffortStatus extends ArrayAdapter<String> {

    private String[] date;
    private Float[] calendarEffort;
    private Float[] acturalEffort;
    private Float[] buiableEffort;
    private Activity context;

    public CustomListEffortStatus(Activity context, String[] date, Float[] calendarEffort, Float[] acturalEffort, Float[] buiableEffort) {
        super(context, R.layout.custom_project_member, date);

        this.context = context;
        this.date = date;
        this.calendarEffort = calendarEffort;
        this.acturalEffort = acturalEffort;
        this.buiableEffort = buiableEffort;
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

        viewHolder.txtDateInputHolder.setText("Day: " + date[position]);
        viewHolder.txtCalendarEffortHolder.setText("Calendar Effort: " + Float.valueOf(calendarEffort[position]).toString());
        viewHolder.txtActuralEffortHolder.setText("Actural Effort: " + Float.valueOf(acturalEffort[position]).toString());
        viewHolder.txtBuiableEffortHolder.setText("Buiable Effort: " + Float.valueOf(buiableEffort[position]).toString());

        return convertView;

    }

    class ViewHolder {
        TextView txtDateInputHolder;
        TextView txtCalendarEffortHolder;
        TextView txtActuralEffortHolder;
        TextView txtBuiableEffortHolder;

        ViewHolder(View v) {
            txtDateInputHolder = v.findViewById(R.id.txtDateInput);
            txtCalendarEffortHolder = v.findViewById(R.id.txtCalendarEffort);
            txtActuralEffortHolder = v.findViewById(R.id.txtActuralEffort);
            txtBuiableEffortHolder = v.findViewById(R.id.txtBuiableEffort);

        }
    }
}
