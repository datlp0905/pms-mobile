package com.example.demomd.activity.custom;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demomd.R;

public class CustomProjectMemberView extends ArrayAdapter<String> {

    private String[] projectMemberName;
    private String[] roleInProject;
    private Integer[] img;
    private Activity context;

    public CustomProjectMemberView(Activity context, String[] projectMemberName, String[] roleInProject, Integer[] img) {
        super(context, R.layout.custom_project_member, projectMemberName);

        this.context = context;
        this.projectMemberName = projectMemberName;
        this.roleInProject = roleInProject;
        this.img = img;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            convertView = layoutInflater.inflate(R.layout.custom_project_member, null, true);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.projectMemberNameHolder.setText(projectMemberName[position]);
        viewHolder.roleInProjectHolder.setText(roleInProject[position]);
        viewHolder.imgHolder.setImageResource(img[position]);

        return convertView;


    }

    class ViewHolder {
        TextView projectMemberNameHolder;
        TextView roleInProjectHolder;
        ImageView imgHolder;

        ViewHolder(View v) {
            projectMemberNameHolder = v.findViewById(R.id.txtProjectMember);
            roleInProjectHolder = v.findViewById(R.id.txtProjectRole);
            imgHolder = v.findViewById(R.id.imageEmployee);
        }
    }
}
