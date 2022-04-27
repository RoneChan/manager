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
    private String submitTime;

    public TestRuleManage(Integer id, String systemVersion, String tradeName, String tradeCode, String testCharacter, String ruleDescribe, String ruleType, String ioIteam, String outputEffective, String equivalenceClass, String testNumber, String testCovItem, String ruleRepresentation, Integer caseNumber, String designName, String submitTime) {
        this.id = id;
        this.systemVersion = systemVersion;
        this.tradeName = tradeName;
        this.tradeCode = tradeCode;
        this.testCharacter = testCharacter;
        this.ruleDescribe = ruleDescribe;
        this.ruleType = ruleType;
        this.ioIteam = ioIteam;
        this.outputEffective = outputEffective;
        this.equivalenceClass = equivalenceClass;
        this.testNumber = testNumber;
        this.testCovItem = testCovItem;
        this.ruleRepresentation = ruleRepresentation;
        this.caseNumber = caseNumber;
        this.designName = designName;
        this.submitTime = submitTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public String getTestCharacter() {
        return testCharacter;
    }

    public void setTestCharacter(String testCharacter) {
        this.testCharacter = testCharacter;
    }

    public String getRuleDescribe() {
        return ruleDescribe;
    }

    public void setRuleDescribe(String ruleDescribe) {
        this.ruleDescribe = ruleDescribe;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getIoIteam() {
        return ioIteam;
    }

    public void setIoIteam(String ioIteam) {
        this.ioIteam = ioIteam;
    }

    public String getOutputEffective() {
        return outputEffective;
    }

    public void setOutputEffective(String outputEffective) {
        this.outputEffective = outputEffective;
    }

    public String getEquivalenceClass() {
        return equivalenceClass;
    }

    public void setEquivalenceClass(String equivalenceClass) {
        this.equivalenceClass = equivalenceClass;
    }

    public String getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(String testNumber) {
        this.testNumber = testNumber;
    }

    public String getTestCovItem() {
        return testCovItem;
    }

    public void setTestCovItem(String testCovItem) {
        this.testCovItem = testCovItem;
    }

    public String getRuleRepresentation() {
        return ruleRepresentation;
    }

    public void setRuleRepresentation(String ruleRepresentation) {
        this.ruleRepresentation = ruleRepresentation;
    }

    public Integer getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(Integer caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getDesignName() {
        return designName;
    }

    public void setDesignName(String designName) {
        this.designName = designName;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }
}
