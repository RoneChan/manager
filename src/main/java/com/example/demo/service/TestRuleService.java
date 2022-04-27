package com.example.demo.service;

import com.example.demo.dto.TestRuleManage;
import com.example.demo.mapper.TestRuleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mucheng
 * @dateTime: 2022-04-18
 * @description: 测试规则service
 * */
@Service
public class TestRuleService {

    @Resource
    private TestRuleMapper testRuleMapper;

    //根据交易名查询所有有效的测试规则
    public List<TestRuleManage> getTestRuleByTradeName(String tradeName){
        List<TestRuleManage> testRuleManageList = testRuleMapper.getTestRuleByTradeName(tradeName);
        return testRuleManageList;
    }

    //根据系统名查询所有有效的测试规则
    public List<TestRuleManage> getTestRuleBySystemName(String systemName){
        List<TestRuleManage> testRuleManageList = testRuleMapper.getTestRuleByTradeName(systemName);
        return testRuleManageList;
    }

    //添加测试规则
    public String addTestRule(TestRuleManage testRule) {
        String message = "";
        //判断该条规则是否已经存在
        if (testRuleMapper.findTestNumber(testRule.getTestNumber()) == null) {
            testRuleMapper.addTsetRule(testRule);
            message = "添加测试规则成功！";
        } else {
            message = "该条测试规则已存在！";
        }
        return message;
    }


    //查询所有测试规则
    public List<TestRuleManage> getTestRulesAll() {
        List<TestRuleManage> testRuleManageList = testRuleMapper.getTestRulesAll();
        return testRuleManageList;
    }

    //根据系统名和交易码查询测试规则
    public List<TestRuleManage> getTestRules(String systemVersion, String tradeName) {
        List<TestRuleManage> testRuleManageList;
        String message = "";
        if (systemVersion ==null && tradeName == null) {
            testRuleManageList = testRuleMapper.getTestRulesAll();
        } else if (systemVersion == null) {
            testRuleManageList = testRuleMapper.getTestRuleByTradeName(tradeName);
        } else if (tradeName == null) {
            testRuleManageList = testRuleMapper.getTestRuleBySystemName(systemVersion);
        } else {
            testRuleManageList = testRuleMapper.getTestRuleBySysAndTradeName(systemVersion, tradeName);
            message = "查询成功";
        }
        return testRuleManageList;

    }

    //写入导入的测试规则文件中所有的规则
    public String saveTestRulesByExcel(List<TestRuleManage> testRuleManageList){
        String message = "";
        //判断testRuleManageList是否为空
        if (!testRuleManageList.isEmpty()) {
            int temp;
            int listNum = testRuleManageList.size();
            TestRuleManage testRule;
            for (temp = 0; temp < listNum; temp++) {
                testRule = testRuleManageList.get(temp);
                addTestRule(testRule);
            }
            message = "成功写入导入的测试规则文件中所有的规则！";
        } else {
            message = "导入的测试规则为空！！";
        }

        return message;
    }


}
