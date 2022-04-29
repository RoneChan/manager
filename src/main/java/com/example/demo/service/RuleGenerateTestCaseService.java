package com.example.demo.service;

import com.example.demo.dto.TestRuleManage;
import com.example.demo.mapper.TestRuleMapper;
import com.example.demo.util.TxtTransform;
import org.springframework.stereotype.Service;
import com.example.demo.dto.FileOrGraphManage;
import com.example.demo.constant.FileTypeEnum;


import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author mucheng
 * @dateTime: 2022-04-18
 * @description: 测试规则生成测试用例（PICT）service
 * */

@Service
public class RuleGenerateTestCaseService {
    @Resource
    private TestRuleMapper testRuleMapper;

    @Resource
    private FileOrGraphService fileOrGraphService;



    //根据交易名查询所有有效的测试规则
    public List<TestRuleManage> getTestRuleByTradeName (String tradeName) {
        List<TestRuleManage> testRuleManageList = testRuleMapper.getTestRuleByTradeName(tradeName);
        return testRuleManageList;
    }

    //通过PICT生成测试用例文件
    public String generateTestCaseByPICT (String SystemName, String tradeName) {
        List<TestRuleManage> testRuleManageList = testRuleMapper.getTestRuleByTradeName(tradeName);
        //TODO:通过testRuleManageList生成PICT的输入文件txt
        //TODO:通过PICT生成用例文件，并存放到对应的目录
        TxtTransform transform = new TxtTransform();
        //path为生成的txt路径
        String path  = transform.wangyinTxtTransform(testRuleManageList);
        Integer fileTypeCode = FileTypeEnum.TC_PICT.getCode();
        String userName = "mucheng";
        LocalDateTime localDateTime = LocalDateTime.now();

        //保存生成文件的路径信息
        FileOrGraphManage fileOrGraphManage = fileOrGraphService.genFilePathManage(SystemName,tradeName,"ABC007","MT103",fileTypeCode,path,userName,localDateTime);
        fileOrGraphService.addFilePath(fileOrGraphManage);
        return path;
    }
}
