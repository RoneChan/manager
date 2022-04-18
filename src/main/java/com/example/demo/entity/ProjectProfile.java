package com.example.demo.entity;


import java.sql.Date;

public class ProjectProfile {
    private String id,name,test_system,test_manager;
    private int project_type,host,abroad;
    private String involved;
    private String department;
    private int FP;
    private String description;
    private int performance_test,interface_test,security_test;
    private int year,Agile;

    public ProjectProfile(String id, String name, String test_system, String test_manager, int project_type, int host, int abroad, String involved, String department, int FP, String description, int performance_test, int interface_test, int security_test, int year, int agile) {
        this.id = id;
        this.name = name;
        this.test_system = test_system;
        this.test_manager = test_manager;
        this.project_type = project_type;
        this.host = host;
        this.abroad = abroad;
        this.involved = involved;
        this.department = department;
        this.FP = FP;
        this.description = description;
        this.performance_test = performance_test;
        this.interface_test = interface_test;
        this.security_test = security_test;
        this.year = year;
        Agile = agile;
    }

    public ProjectProfile(String id, String name, int project_type, int host, String test_system) {
        this.id = id;
        this.name = name;
        this.test_system = test_system;
        this.project_type = project_type;
        this.host = host;
    }

    public String getTest_manager() {
        return test_manager;
    }

    public void setTest_manager(String test_manager) {
        this.test_manager = test_manager;
    }

    public int getAgile() {
        return Agile;
    }

    public void setAgile(int agile) {
        Agile = agile;
    }

    public int getPerformance_test() {
        return performance_test;
    }

    public void setPerformance_test(int performance_test) {
        this.performance_test = performance_test;
    }

    public int getInterface_test() {
        return interface_test;
    }

    public void setInterface_test(int interface_test) {
        this.interface_test = interface_test;
    }

    public int getSecurity_test() {
        return security_test;
    }

    public void setSecurity_test(int security_test) {
        this.security_test = security_test;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTest_system() {
        return test_system;
    }

    public void setTest_system(String test_system) {
        this.test_system = test_system;
    }

    public String getInvolved() {
        return involved;
    }

    public void setInvolved(String involved) {
        this.involved = involved;
    }

    public int getProject_type() {
        return project_type;
    }

    public void setProject_type(int project_type) {
        this.project_type = project_type;
    }

    public int getHost() {
        return host;
    }

    public void setHost(int host) {
        this.host = host;
    }

    public int getAbroad() {
        return abroad;
    }

    public void setAbroad(int abroad) {
        this.abroad = abroad;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getFP() {
        return FP;
    }

    public void setFP(int FP) {
        this.FP = FP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
