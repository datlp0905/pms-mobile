package com.example.demomd.data;

public class ProjectMemberResponse {
    private int id;

    private ProjectResponse project;

    public ProjectMemberResponse() {
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
}
