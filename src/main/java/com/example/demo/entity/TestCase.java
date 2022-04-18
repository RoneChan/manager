package com.example.demo.entity;

public class TestCase {
    String id;
    int execution_phase_case_num,executed_case_num,passed_case_num,phase;

    public TestCase(String id, int execution_phase_case_num, int executed_case_num, int passed_case_num, int phase) {
        this.id = id;
        this.execution_phase_case_num = execution_phase_case_num;
        this.executed_case_num = executed_case_num;
        this.passed_case_num = passed_case_num;
        this.phase = phase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getExecution_phase_case_num() {
        return execution_phase_case_num;
    }

    public void setExecution_phase_case_num(int execution_phase_case_num) {
        this.execution_phase_case_num = execution_phase_case_num;
    }

    public int getExecuted_case_num() {
        return executed_case_num;
    }

    public void setExecuted_case_num(int executed_case_num) {
        this.executed_case_num = executed_case_num;
    }

    public int getPassed_case_num() {
        return passed_case_num;
    }

    public void setPassed_case_num(int passe_case_num) {
        this.passed_case_num = passe_case_num;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }
}
