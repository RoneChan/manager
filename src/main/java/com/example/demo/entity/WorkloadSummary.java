package com.example.demo.entity;

public class WorkloadSummary {
    String name;
    int month,year;
    float workload;

    public WorkloadSummary(String name, int month, int year, float workload) {
        this.name = name;
        this.month = month;
        this.year = year;
        this.workload = workload;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getWorkload() {
        return workload;
    }

    public void setWorkload(float workload) {
        this.workload = workload;
    }
}
