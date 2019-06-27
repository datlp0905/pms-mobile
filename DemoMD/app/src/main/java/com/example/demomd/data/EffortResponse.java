package com.example.demomd.data;

import java.io.Serializable;
import java.util.Date;

public class EffortResponse implements Serializable {
    private int id;

    private ProjectResponse project;

    private float calendarEffort;

    private float actualEffort;

    private float buildableEffort;

    private Date reportDate;

    private int status;

    public EffortResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProjectResponse getProject() {
        return project;
    }

    public void setProject(ProjectResponse project) {
        this.project = project;
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

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
