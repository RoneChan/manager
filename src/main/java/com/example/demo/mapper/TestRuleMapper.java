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
@Mapper
public interface TestRuleMapper {

    //根据交易名查询所有有效的测试规则
    List<TestRuleManage> getTestRuleByTradeName(@Param("tradeName")String tradeName);

    //根据系统名查询所有有效的测试规则
    List<TestRuleManage> getTestRuleBySystemName(@Param("systemVersion")String systemVersion);

    //根据系统名和交易名查询所有有效的测试规则
    List<TestRuleManage> getTestRuleBySysAndTradeName(@Param("systemVersion")String systemVersion,@Param("tradeName")String tradeName);
    //List<TestRuleManage> getTestRuleBySysAndTradeName(String systemVersion, String tradeName);
    //添加测试规则
    void addTestRule(@Param("testRule")TestRuleManage testRule);

    //查询所有测试规则
    List<TestRuleManage> getTestRulesAll();

    //根据测试覆盖编号（即测试规则唯一标识编号）判断该条规则是否存在
    String findTestNumber(@Param("testNumber")String testNumber);

}
