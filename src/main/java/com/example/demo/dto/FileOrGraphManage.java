package com.example.demo.dto;
import lombok.Data;

import java.sql.Time;

/**
 * @author mucheng
 * @detaTime: 2022-04-28
 * @description: 保存测试用例文件及graphml文件路径的数据实体
 * */
@Data
public class FileOrGraphManage {

    // 主键
    private Integer id;
    // 系统名
    private String systemVersion;
    // 交易名称
    private String tradeName;
    // 交易码
    private String tradeCode;
    // 文件类型枚举
    private Integer fileTypeCode;
    // 测试场景名称
    private String testScene;
    // 文件保存的路径名称
    private String savePath;
    // 责任人
    private String userName;
    //文件生成时间
    private Time saveTime;

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

    public String getTestScene() {
        return testScene;
    }

    public void setTestScene(String testScene) {
        this.testScene = testScene;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Time getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Time saveTime) {
        this.saveTime = saveTime;
    }

    public Integer getFileTypeCode() {
        return fileTypeCode;
    }

    public void setFileTypeCode(Integer fileTypeCode) {
        this.fileTypeCode = fileTypeCode;
    }
}
