package com.example.demomd.data;

import java.io.Serializable;

public class EmployeeShortInfoResponse implements Serializable {
    String id;

    String fullname;

    public EmployeeShortInfoResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
