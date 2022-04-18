package com.example.demo.entity;

public class TesterWorkload {
    String name;
    String month;
    float workload;

    public TesterWorkload(String name, String month, float workload) {
        this.name = name;
        this.month = month;
        this.workload = workload;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public float getWorkload() {
        return workload;
    }

    public void setWorkload(float workload) {
        this.workload = workload;
    }
}
