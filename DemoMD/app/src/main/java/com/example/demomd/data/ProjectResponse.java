package com.example.demomd.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class ProjectResponse implements Serializable {
    @SerializedName("id")
    @Expose
    protected int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("startDate")
    @Expose
    private Date startDate;

    @SerializedName("endDate")
    @Expose
    private Date endDate;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("status")
    @Expose
    private ProjectStatusResponse status;

    public ProjectResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectStatusResponse getStatus() {
        return status;
    }

    public void setStatus(ProjectStatusResponse status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}
