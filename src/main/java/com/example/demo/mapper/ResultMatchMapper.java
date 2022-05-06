package com.example.demo.mapper;

import com.example.demo.dto.ResultMatchDictionary;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author mucheng
 * @dateTime;2022-04-24
 * @description: 预期结果映射字典mapper
 * */
@Mapper
public interface ResultMatchMapper {

    //根据系统名查询维护的所有结果映射详情信息
    List<ResultMatchDictionary> getResultDetailBySysName(@Param("SystemName")String systemName);

    //根据系统名和待匹配结果关键字查询结果映射详情信息
    List<ResultMatchDictionary> getResultDetailBySysNameAndKey(@Param("SystemName")String systemName, @Param("matchingResultKey")String matchingResultKey);

    //根据待匹配结果关键字查询结果映射详情信息
    List<ResultMatchDictionary> getResultDetailByMatchKey(@Param("matchingResultKey")String matchingResultKey);

    //查询结果映射详情信息字典
    List<ResultMatchDictionary> getResultDetails();

    //新增结果映射详情字典信息
    void addResultDetailDictionary(@Param("resultMatchDictionary")ResultMatchDictionary resultMatchDictionary);

    //修改结果映射详情字典信息
    String modifyResultDetailDictionary(@Param("resultMatchDictionary")ResultMatchDictionary resultMatchDictionary);

    //判断匹配结果关键字是否存在
    String findMatchKey(@Param("matchingResultKey")String matchingResultKey);


}
