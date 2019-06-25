package com.example.demomd.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectResponse {
    @SerializedName("id")
    @Expose
    protected int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("statusID")
    @Expose
    private int statusID;

    public ProjectResponse() {
    }

    public ProjectResponse(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}
