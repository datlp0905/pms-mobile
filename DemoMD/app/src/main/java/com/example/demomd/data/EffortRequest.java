package com.example.demomd.data;

import java.io.Serializable;

public class EffortRequest implements Serializable {
    private int projectMemberId;

    private float calendarEffort;

    private float actualEffort;

    private float buildableEffort;

    private String reportDate;

    private int positionId;

    private String comment;

    public EffortRequest() {
    }

    public EffortRequest(int projectMemberId, float calendarEffort, float actualEffort, float buildableEffort, String reportDate, int positionId, String comment) {
        this.projectMemberId = projectMemberId;
        this.calendarEffort = calendarEffort;
        this.actualEffort = actualEffort;
        this.buildableEffort = buildableEffort;
        this.reportDate = reportDate;
        this.positionId = positionId;
        this.comment = comment;
    }

    public int getProjectMemberId() {
        return projectMemberId;
    }

    public void setProjectMemberId(int projectMemberId) {
        this.projectMemberId = projectMemberId;
    }

    public float getCalendarEffort() {
        return calendarEffort;
    }

    public void setCalendarEffort(float calendarEffort) {
        this.calendarEffort = calendarEffort;
    }

    public float getActualEffort() {
        return actualEffort;
    }

    public void setActualEffort(float actualEffort) {
        this.actualEffort = actualEffort;
    }

    public float getBuildableEffort() {
        return buildableEffort;
    }

    public void setBuildableEffort(float buildableEffort) {
        this.buildableEffort = buildableEffort;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
