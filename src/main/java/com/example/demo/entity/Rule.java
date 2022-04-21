package com.example.demo.entity;

public class Rule {
    private String name,tradecode,describe,type,scene,validity,tci;

    public Rule(String name, String tradecode, String describe, String type, String scene, String validity, String tci) {
        this.name = name;
        this.tradecode = tradecode;
        this.describe = describe;
        this.type = type;
        this.scene = scene;
        this.validity = validity;
        this.tci = tci;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTradecode() {
        return tradecode;
    }

    public void setTradecode(String tradecode) {
        this.tradecode = tradecode;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getTci() {
        return tci;
    }

    public void setTci(String tci) {
        this.tci = tci;
    }
}
