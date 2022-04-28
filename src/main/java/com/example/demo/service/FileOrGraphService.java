package com.example.demo.service;

import com.example.demo.dto.FileOrGraphManage;
import com.example.demo.mapper.FileOrGraphMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import com.example.demo.constant.FileTypeEnum;

import javax.annotation.Resource;
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
    List<FileOrGraphManage> getfilePathBySystemName(String systemName) {
        List<FileOrGraphManage> fileOrGraphManageList = fileOrGraphMapper.getfilePathBySystemName(systemName);
        return fileOrGraphManageList;
    }

    //根据系统名和交易名查询所有测试文件路径信息
    List<FileOrGraphManage> getfilePathBySysAndTradeName(String systemName,String tradeName) {
        List<FileOrGraphManage> fileOrGraphManageList = fileOrGraphMapper.getfilePathBySysAndTradeName(systemName, tradeName);
        return fileOrGraphManageList;
    }
    //根据系统名和交易名查询指定文件类型的文件路径信息
    List<FileOrGraphManage> getfilePathByTypeEnum(String systemVersion,String tradeName,FileTypeEnum fileTypeEnum) {
        Integer fileTypeCode;
        fileTypeCode = fileTypeEnum.getCode();
        List<FileOrGraphManage> fileOrGraphManageList = fileOrGraphMapper.getfilePathByTypeEnum(systemVersion, tradeName, fileTypeCode);
        return fileOrGraphManageList;
    }

    //查询所有测试文件路径
    List<FileOrGraphManage> getFileOrGraphs() {
        List<FileOrGraphManage> fileOrGraphManageList = fileOrGraphMapper.getFileOrGraphs();
        return fileOrGraphManageList;
    }

    //添加测试文件保存路径
    String addFilePath(@Param("fileOrGrqaphManage")FileOrGraphManage fileOrGrqaphManage) {
        String message = "";
        return message;
    }



}
