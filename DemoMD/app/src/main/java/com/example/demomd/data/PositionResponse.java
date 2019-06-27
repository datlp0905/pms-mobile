package com.example.demomd.data;

import java.io.Serializable;

public class PositionResponse implements Serializable {
    private int id;

    private String name;

    public PositionResponse() {
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

    @Override
    public String toString() {
        return this.getName();
    }
}
