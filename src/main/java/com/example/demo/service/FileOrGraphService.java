package com.example.demo.service;

import com.example.demo.dto.FileOrGraphManage;
import com.example.demo.mapper.FileOrGraphMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import com.example.demo.constant.FileTypeEnum;

import java.sql.Time;
import java.sql.Date;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author mucheng
 * @dateTime: 2022-04-28
 * @description: 用例文件service
 * */
@Service
public class FileOrGraphService {

    @Resource
    private  FileOrGraphMapper fileOrGraphMapper;

    //根据交易名查询所有测试文件路径信息
    public List<FileOrGraphManage> getfilePathByTradeName(String tradeName) {
        List<FileOrGraphManage> fileOrGraphManageList = fileOrGraphMapper.getfilePathByTradeName(tradeName);
        return fileOrGraphManageList;
    }

    //根据系统名查询所有的测试文件路径信息
    public List<FileOrGraphManage> getfilePathBySystemName(String systemName) {
        List<FileOrGraphManage> fileOrGraphManageList = fileOrGraphMapper.getfilePathBySystemName(systemName);
        return fileOrGraphManageList;
    }

    //根据系统名和交易名查询所有测试文件路径信息
    public  List<FileOrGraphManage> getfilePathBySysAndTradeName(String systemName,String tradeName) {
        List<FileOrGraphManage> fileOrGraphManageList = fileOrGraphMapper.getfilePathBySysAndTradeName(systemName, tradeName);
        return fileOrGraphManageList;
    }
    //根据系统名和交易名查询指定文件类型的文件路径信息
    public List<FileOrGraphManage> getfilePathByAll(String systemVersion,String tradeName,Integer fileTypeEnum) {
        Integer fileTypeCode = fileTypeEnum;
        List<FileOrGraphManage> fileOrGraphManageList = fileOrGraphMapper.getfilePathByTypeAll(systemVersion, tradeName, fileTypeCode);
        return fileOrGraphManageList;
    }

    //根据系统名和交易名查询指定文件类型的文件路径信息
    public List<FileOrGraphManage> getfilePathByType(Integer fileTypeEnum) {
        Integer fileTypeCode = fileTypeEnum;
        List<FileOrGraphManage> fileOrGraphManageList = fileOrGraphMapper.getfilePathByType(fileTypeCode);
        return fileOrGraphManageList;
    }

    //查询所有测试文件路径
    public List<FileOrGraphManage> getFileOrGraphs() {
        List<FileOrGraphManage> fileOrGraphManageList = fileOrGraphMapper.getFileOrGraphs();
        return fileOrGraphManageList;
    }

    //根据系统名和指定文件类型查询文件路径信息
    public List<FileOrGraphManage> getfilePathBySystemNameAndType(String systemVersion,Integer fileTypeEnum) {
        List<FileOrGraphManage> fileOrGraphManageList = fileOrGraphMapper.getfilePathBySystemNameAndType(systemVersion,fileTypeEnum);
        return fileOrGraphManageList;
    }
    //查询所有测试文件路径
    public List<FileOrGraphManage> getfilePathByTradeNameAndType(String tradeName,Integer fileTypeEnum) {
        List<FileOrGraphManage> fileOrGraphManageList = fileOrGraphMapper.getfilePathByTradeNameAndType(tradeName,fileTypeEnum);
        return fileOrGraphManageList;
    }

    //添加测试文件保存路径
    String addFilePath(FileOrGraphManage fileOrGraphManage) {
        String message = "";
        fileOrGraphMapper.addFilePath(fileOrGraphManage);
        message = "保存文件路径成功！";
        return message;
    }

    FileOrGraphManage genFilePathManage(String systemName, String tradeName,String tradeCode, String testScene, Integer fileTypeCode, String savePath, String userName, LocalDateTime saveTime) {
        FileOrGraphManage fileOrGraphManage = new FileOrGraphManage();
        fileOrGraphManage.setSystemVersion(systemName);
        fileOrGraphManage.setTradeName(tradeName);
        fileOrGraphManage.setTradeCode(tradeCode);
        fileOrGraphManage.setTestScene(testScene);
        fileOrGraphManage.setFileTypeCode(fileTypeCode);
        fileOrGraphManage.setSavePath(savePath);
        fileOrGraphManage.setUserName(userName);
        fileOrGraphManage.setSaveTime(saveTime);
        return fileOrGraphManage;
    }

}
