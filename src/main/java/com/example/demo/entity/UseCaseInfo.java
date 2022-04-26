package com.example.demo.entity;

import java.util.List;
import java.util.Map;

public class UseCaseInfo {
    String description; //用例描述
    String steps; //测试步骤
    String result; //预期结果

    public String getDescription() {
        return description;
    }

    public String getSteps() {
        return steps;
    }

    public String getResult() {
        return result;
    }

    //usecase:v-e-v
    public Boolean parseCase(List<String> useCase, String tradeName,Map<String, String> ruleMap) {
        //用例描述
        this.description = tradeName;
        String v1 = useCase.get(0).split(":")[1];
        v1 = v1.substring(3,v1.length()-1);
        this.description += "-" + v1;
        String e = useCase.get(1).split(":")[1];
        e = e.substring(3,e.length()-1);
        this.description += "-" + e;
        //测试步骤
        String v2 = useCase.get(2).split(":")[1];
        v2 = v2.substring(3,v2.length()-1);
        this.steps = "Step1:" + v1 + ";\n" +
                "Step2:" + e + "," + v2 + ";";
        //预期结果
        String key = v2.split("_")[0];
        this.result = ruleMap.get(key);
        if(this.result == null) {
            this.result = key;
        }
        return true;
    }
    public String toString() {
        String infoString = "";
        infoString = "{====description: " + this.description + ";====steps: " + this.steps + ";====result: " + this.result + "}\n";
        return infoString;
    }
}
