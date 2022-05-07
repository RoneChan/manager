package com.example.demo.dto;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;

/**
 * @author mucheng
 * @detaTime: 2022-04-24
 * @description: 预期结果映射字典的数据实体
 * */

@Data
public class ResultMatchDictionary {
    // 主键
    private Integer id;
    // 系统名称
    private String systemName;
    // 待匹配结果关键字
    private String matchingResultKey;
    // 预期结果详细描述
    private String resultDetailDes;
    // 规则字典维护人员
    private String userName;
    //提交时间
    private LocalDateTime submitTime;
    //修改时间
    private LocalDateTime modifyTime;
    //预留字段
    private String Fstandby1;
    //预留字段
    private String Fstandby2;
    //预留字段
    private String Fstandby3;

    public ResultMatchDictionary() {
    }

    public ResultMatchDictionary(Integer id, String systemName, String matchingResultKey, String resultDetailDes, String userName, LocalDateTime submitTime, LocalDateTime modifyTime, String fstandby1, String fstandby2, String fstandby3) {
        this.id = id;
        this.systemName = systemName;
        this.matchingResultKey = matchingResultKey;
        this.resultDetailDes = resultDetailDes;
        this.userName = userName;
        this.submitTime = submitTime;
        this.modifyTime = modifyTime;
        Fstandby1 = fstandby1;
        Fstandby2 = fstandby2;
        Fstandby3 = fstandby3;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSystemName() {
        return systemName;
    }
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
    public String getMatchingResultKey() {
        return matchingResultKey;
    }
    public void setMatchingResultKey(String matchingResultKey) {
        this.matchingResultKey = matchingResultKey;
    }
    public String getResultDetailDes() {
        return resultDetailDes;
    }
    public void setResultDetailDes(String resultDetailDes) {
        this.resultDetailDes = resultDetailDes;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public LocalDateTime getSubmitTime() {
        return submitTime;
    }
    public void setSubmitTime(LocalDateTime submitTime) {
        this.submitTime = submitTime;
    }
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }
    public String getFstandby1() {
        return Fstandby1;
    }
    public void setFstandby1(String fstandby1) {
        Fstandby1 = fstandby1;
    }
    public String getFstandby2() {
        return Fstandby2;
    }
    public void setFstandby2(String fstandby2) {
        Fstandby2 = fstandby2;
    }
    public String getFstandby3() {
        return Fstandby3;
    }
    public void setFstandby3(String fstandby3) {
        Fstandby3 = fstandby3;
    }




}
