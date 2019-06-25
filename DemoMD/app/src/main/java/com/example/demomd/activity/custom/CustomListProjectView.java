package com.example.demomd.activity.custom;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.demomd.R;
import com.example.demomd.data.ProjectResponse;

import java.util.List;

public class CustomListProjectView extends ArrayAdapter<ProjectResponse> {

    private List<ProjectResponse> items;
    private Activity context;

    public CustomListProjectView(Activity context, List<ProjectResponse> items) {
        super(context, R.layout.custom_project_name, items);
        this.context = context;
        this.items = items;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            convertView = layoutInflater.inflate(R.layout.custom_project_name, null, true);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.projectName.setText(items.get(position).getName());
        return convertView;
    }

    class ViewHolder {
        TextView projectName;

        ViewHolder(View v) {
            projectName = v.findViewById(R.id.txtNameProject);
        }
    }
}
