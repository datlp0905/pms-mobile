package com.example.demomd.activity.custom;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demomd.R;
import com.example.demomd.data.MemberInProjectResponse;
import com.example.demomd.data.PositionResponse;

import java.util.List;

public class CustomProjectMemberView extends ArrayAdapter<MemberInProjectResponse> {

    private List<MemberInProjectResponse> listEmployeeInProject;
    private Integer[] img;
    private Activity context;

    public CustomProjectMemberView(Activity context, List<MemberInProjectResponse> listEmployeeInProject, Integer[] img) {
        super(context, R.layout.custom_project_member, listEmployeeInProject);

        this.context = context;
        this.listEmployeeInProject = listEmployeeInProject;
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
        viewHolder.projectMemberNameHolder.setText(listEmployeeInProject.get(position).getEmployee().getFullname());
        viewHolder.roleInProjectHolder.setText(convertListPositionToString(listEmployeeInProject.get(position).getPositionInProjectList()));
        viewHolder.imgHolder.setImageResource(img[position]);

        return convertView;
    }

    private String convertListPositionToString(final List<PositionResponse> listPosition) {
        String listPositionName = "";
        if(listPosition != null && !listPosition.isEmpty()) {
            for(PositionResponse response : listPosition) {
                listPositionName += response.getName() + ", ";
            }
            listPositionName = listPositionName.substring(0, listPositionName.lastIndexOf(","));
        }

        return listPositionName;
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
