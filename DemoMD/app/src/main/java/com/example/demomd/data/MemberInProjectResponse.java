package com.example.demomd.data;

import java.io.Serializable;
import java.util.List;

public class MemberInProjectResponse implements Serializable {
    private int projectMemberId;

    private EmployeeShortInfoResponse employee;

    private List<PositionResponse> positionInProjectList;

    public MemberInProjectResponse() {
    }

    public int getProjectMemberId() {
        return projectMemberId;
    }

    public void setProjectMemberId(int projectMemberId) {
        this.projectMemberId = projectMemberId;
    }

    public EmployeeShortInfoResponse getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeShortInfoResponse employee) {
        this.employee = employee;
    }

    public List<PositionResponse> getPositionInProjectList() {
        return positionInProjectList;
    }

    public void setPositionInProjectList(List<PositionResponse> positionInProjectList) {
        this.positionInProjectList = positionInProjectList;
    }
}
