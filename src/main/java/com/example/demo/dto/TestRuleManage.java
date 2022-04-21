package com.example.demo.dto;
import lombok.Data;

import java.sql.Time;

/**
 * @author mucheng
 * @detaTime: 2022-04-19
 * @description: 测试规则数据实体
 * */

@Data
public class TestRuleManage {
    // 主键
    private Integer id;
    // 系统版本
    private String systemVersion;
    // 交易名称
    private String tradeName;
    // 交易码
    private String tradeCode;
    // 测试特征集
    private String testCharacter;
    // 规则描述
    private String ruleDescribe;
    // 测试规则类型
    private String ruleType;
    // 输入项或输出项
    private String ioIteam;
    // 输出有效性
    private String outputEffective;
    // 等价类名称
    private String equivalenceClass;
    // 测试覆盖编号
    private String testNumber;
    // 测试覆盖项(TCI)
    private String testCovItem;
    // 测试规则表达式
    private String ruleRepresentation;
    // 功能用例、自动化用例编号
    private Integer caseNumber;
    // 设计者
    private String designName;
    //提交时间
    private Time submitTime;
}
