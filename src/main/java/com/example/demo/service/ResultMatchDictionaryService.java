package com.example.demo.service;


import com.example.demo.dto.ResultMatchDictionary;
import com.example.demo.dto.TestRuleManage;
import com.example.demo.mapper.ResultMatchMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mucheng
 * @dateTime: 2022-04-24
 * @description: 预期结果映射字典维护service
 * */
@Service
public class ResultMatchDictionaryService {

    @Resource ResultMatchMapper resultMatchMapper;

    //根据系统名查询维护的所有结果映射详情信息
    public List<ResultMatchDictionary> getResultDetailBySysName(String systemName) {
        List<ResultMatchDictionary> resultDetail = resultMatchMapper.getResultDetailBySysName(systemName);
        return resultDetail;
    }

    //根据系统名和待匹配结果关键字查询结果映射详情信息
    public List<ResultMatchDictionary> getResultDetailBySysNameAndKey(String systemNane, String matchingResultKey) {
        List<ResultMatchDictionary> resultDetail = resultMatchMapper.getResultDetailBySysNameAndKey(systemNane, matchingResultKey);
        return resultDetail;
    }

    //根据待匹配结果关键字查询结果映射详情信息
    public List<ResultMatchDictionary> getResultDetailByMatchKey(String matchingResultKey) {
        List<ResultMatchDictionary> resultDetail = resultMatchMapper.getResultDetailByMatchKey(matchingResultKey);
        return resultDetail;
    }

    //查询结果映射详情信息字典
    public List<ResultMatchDictionary> getResultDetails() {
        List<ResultMatchDictionary> resultDetail = resultMatchMapper.getResultDetails();
        return resultDetail;
    }

    //新增结果映射详情字典信息
    public String addResultDetailDictionary(ResultMatchDictionary resultMatchDictionary) {
        String message = "";
        //判断key是否已经存在
        if(resultMatchMapper.findMatchKey(resultMatchDictionary.getMatchingResultKey()) == null) {
            resultMatchMapper.addResultDetailDictionary(resultMatchDictionary);
            message = "添加结果映射信息成功！";
        } else {
            message = "匹配关键字映射的结果已存在！！";
        }
        return message;
    }

}
