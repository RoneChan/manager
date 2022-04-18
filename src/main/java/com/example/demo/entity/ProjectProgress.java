package com.example.demo.entity;

import java.sql.Date;

public class ProjectProgress {
    private String id;
    private String workload;
    private Date test_access_time, test_exit_time, production_time;
    private int progress;
    private String problem;
    private Date undertake_time, preparing_time, testing_time, done_time;
    private String test_case_num, negative_test_case_num;
    private String bug_num, resolved_bug_num;

    public ProjectProgress(String id, String workload, Date test_access_time, Date test_exit_time, Date production_time) {
        this.id = id;
        this.workload = workload;
        this.test_access_time = test_access_time;
        this.test_exit_time = test_exit_time;
        this.production_time = production_time;
    }

    public ProjectProgress(String id, String workload, Date test_access_time, Date test_exit_time, Date production_time, int progress, String problem, Date undertake_time, Date preparing_time, Date testing_time, Date done_time, String test_case_num, String negative_test_case_num, String bug_num, String resolved_bug_num) {
        this.id = id;
        this.workload = workload;
        this.test_access_time = test_access_time;
        this.test_exit_time = test_exit_time;
        this.production_time = production_time;
        this.progress = progress;
        this.problem = problem;
        this.undertake_time = undertake_time;
        this.preparing_time = preparing_time;
        this.testing_time = testing_time;
        this.done_time = done_time;
        this.test_case_num = test_case_num;
        this.negative_test_case_num = negative_test_case_num;
        this.bug_num = bug_num;
        this.resolved_bug_num = resolved_bug_num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkload() {
        return workload;
    }

    public void setWorkload(String workload) {
        this.workload = workload;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getTest_case_num() {
        return test_case_num;
    }

    public void setTest_case_num(String test_case_num) {
        this.test_case_num = test_case_num;
    }

    public String getNegative_test_case_num() {
        return negative_test_case_num;
    }

    public void setNegative_test_case_num(String negtive_test_case_num) {
        this.negative_test_case_num = negtive_test_case_num;
    }

    public Date getTest_access_time() {
        return test_access_time;
    }

    public void setTest_access_time(Date test_access_time) {
        this.test_access_time = test_access_time;
    }

    public Date getTest_exit_time() {
        return test_exit_time;
    }

    public void setTest_exit_time(Date test_exit_time) {
        this.test_exit_time = test_exit_time;
    }

    public Date getProduction_time() {
        return production_time;
    }

    public void setProduction_time(Date production_time) {
        this.production_time = production_time;
    }

    public Date getUndertake_time() {
        return undertake_time;
    }

    public void setUndertake_time(Date undertake_time) {
        this.undertake_time = undertake_time;
    }

    public Date getPreparing_time() {
        return preparing_time;
    }

    public void setPreparing_time(Date preparing_time) {
        this.preparing_time = preparing_time;
    }

    public Date getTesting_time() {
        return testing_time;
    }

    public void setTesting_time(Date testing_time) {
        this.testing_time = testing_time;
    }

    public Date getDone_time() {
        return done_time;
    }

    public void setDone_time(Date done_time) {
        this.done_time = done_time;
    }

    public String getBug_num() {
        return bug_num;
    }

    public void setBug_num(String bug_num) {
        this.bug_num = bug_num;
    }

    public String getResolved_bug_num() {
        return resolved_bug_num;
    }

    public void setResolved_bug_num(String resolved_bug_num) {
        this.resolved_bug_num = resolved_bug_num;
    }
}
