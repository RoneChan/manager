package com.example.demo.service;

import com.example.demo.dto.TestRuleManage;
import com.example.demo.mapper.TestRuleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mucheng
 * @dateTime: 2022-04-18
 * @description: 测试规则生成测试用例（PICT）service
 * */

@Service
public class RuleGenerateTestCaseService {
    @Resource
    private TestRuleMapper testRuleMapper;
    //根据交易名查询所有有效的测试规则
    public List<TestRuleManage> getTestRuleByTradeName(String tradeName){
        List<TestRuleManage> testRuleManageList = testRuleMapper.getTestRuleByTradeName(tradeName);
        return testRuleManageList;
    }
}
