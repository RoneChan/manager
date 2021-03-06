package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.demo.dto.FileOrGraphManage;

import java.util.List;

/**
 * @author mucheng
 * @dateTime;2022-04-28
 * @description: 测试用例文件及graphml文件mapper
 * */
@Mapper
public interface FileOrGraphMapper {

    //根据交易名查询所有测试文件路径信息
    List<FileOrGraphManage> getfilePathByTradeName(@Param("systemVersion")String systemVersion);

    //根据系统名查询所有的测试文件路径信息
    List<FileOrGraphManage> getfilePathBySystemName(@Param("systemVersion")String systemVersion);

    //根据系统名和交易名查询所有测试文件路径信息
    List<FileOrGraphManage> getfilePathBySysAndTradeName(@Param("systemVersion")String systemVersion,@Param("tradeName")String tradeName);

    //根据系统名和交易名查询指定文件类型的文件路径信息
    List<FileOrGraphManage> getfilePathByTypeAll(@Param("systemVersion")String systemVersion,@Param("tradeName")String tradeName,@Param("fileTypeCode") Integer fileTypeCode);

    //根据系统名和交易名查询指定文件类型的文件路径信息
    List<FileOrGraphManage> getfilePathByType(@Param("fileTypeCode") Integer fileTypeCode);

    //查询所有测试文件路径
    List<FileOrGraphManage> getFileOrGraphs();


    //根据系统名和指定文件类型查询文件路径信息
    List<FileOrGraphManage> getfilePathBySystemNameAndType(@Param("systemVersion")String systemVersion,@Param("fileTypeCode") Integer fileTypeEnum);

    //查询所有测试文件路径
    List<FileOrGraphManage> getfilePathByTradeNameAndType(@Param("tradeName") String tradeName,@Param("fileTypeCode")Integer fileTypeEnum);

    //添加测试文件保存路径
    void addFilePath(@Param("fileOrGraphManage")FileOrGraphManage fileOrGraphManage);




}
