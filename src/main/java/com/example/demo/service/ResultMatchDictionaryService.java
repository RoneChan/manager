package com.example.demo.service;


import com.example.demo.dto.ResultMatchDictionary;
import com.example.demo.dto.TestRuleManage;
import com.example.demo.mapper.ResultMatchMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;

/**
 * @author mucheng
 * @dateTime: 2022-04-24
 * @description: 预期结果映射字典维护service
 * */
@Service
public class ResultMatchDictionaryService {

    @Resource
    ResultMatchMapper resultMatchMapper;


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
//        if(resultMatchMapper.findMatchKey(resultMatchDictionary.getMatchingResultKey()).isEmpty()) {
//            resultMatchMapper.addResultDetailDictionary(resultMatchDictionary);
//            message = "添加结果映射信息成功！";
//        } else {
//            message = "匹配关键字映射的结果已存在！！";
//        }
        resultMatchMapper.addResultDetailDictionary(resultMatchDictionary);
        message = "添加结果映射信息成功！";
        return message;
    }

    //
    public String addResultMatchConfig(String systemName, String matchingResultKey, String resultDetailDes, String userName) {
        String message = "";
        ResultMatchDictionary resultMatchDictionary = genResultMatchDictionary(systemName,matchingResultKey,resultDetailDes,userName);
        addResultDetailDictionary(resultMatchDictionary);
        message = "添加结果映射信息成功！";
        return message;
    }

    //生成ResultDetailDictionary
    public ResultMatchDictionary genResultMatchDictionary(String systemName, String matchingResultKey, String resultDetailDes, String userName) {
        ResultMatchDictionary resultMatchDictionary = new ResultMatchDictionary();
        resultMatchDictionary.setSystemName(systemName);
        resultMatchDictionary.setMatchingResultKey(matchingResultKey);
        resultMatchDictionary.setResultDetailDes(resultDetailDes);
        resultMatchDictionary.setUserName(userName);
        //获取当前时间
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        resultMatchDictionary.setSubmitTime(now);
        resultMatchDictionary.setModifyTime(now);
        return resultMatchDictionary;
    }


}
