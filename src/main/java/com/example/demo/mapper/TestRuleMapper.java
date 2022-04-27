package com.example.demo.mapper;

import com.example.demo.dto.TestRuleManage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author mucheng
 * @dateTime;2022-04-21
 * @description: 测试规则mapper
 * */

public interface TestRuleMapper {

    //根据交易名查询所有有效的测试规则
    List<TestRuleManage> getTestRuleByTradeName(@Param("TradeName")String tradeName);

    //根据系统名查询所有有效的测试规则
    List<TestRuleManage> getTestRuleBySystemName(@Param("systemVersion")String systemVersion);

    //根据系统名和交易名查询所有有效的测试规则
    List<TestRuleManage> getTestRuleBySysAndTradeName(@Param("systemVersion")String systemVersion, @Param("TradeName")String tradeName);

    //添加测试规则
    String addTsetRule(@Param("ssm")TestRuleManage ssm);

    //查询所有测试规则
    List<TestRuleManage> getTestRulesAll();

    //根据测试覆盖编号（即测试规则唯一标识编号）判断该条规则是否存在
    String findTestNumber(@Param("testNumber")String testNumber);

}
