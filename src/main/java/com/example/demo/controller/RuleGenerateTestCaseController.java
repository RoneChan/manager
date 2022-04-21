package com.example.demo.controller;
import com.example.demo.Vo.ResultVo;
import com.example.demo.constant.ResutEnum;
import com.example.demo.service.TestRuleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/ruleGenerateTestCase/*")
public class RuleGenerateTestCaseController {

    @Resource
    private TestRuleService testRuleService;

    @RequestMapping("/generateTestCase")
    public String generateTestCase(){
        System.out.println("Hello World");
        return "Success!!!!!!";
    }

    //显示所有学生成绩信息
    @GetMapping("/getTestRules")
    public ResultVo getTestRules() {
        System.out.println("Hello World");
        return new ResultVo(ResutEnum.OK,testRuleService.getTestRules());
//        ResultVo result;
//        result = new ResultVo(ResutEnum.OK,testRuleService.getTestRules());
//        return result;
    }
}
