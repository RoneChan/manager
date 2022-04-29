package com.example.demo.controller;
import com.example.demo.Vo.ResultVo;
import com.example.demo.constant.ResutEnum;
import com.example.demo.service.RuleGenerateTestCaseService;
import com.example.demo.service.TestRuleService;
import org.springframework.web.bind.annotation.*;
import com.example.demo.util.TxtTransform;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mucheng
 * @dateTime: 2022-04-16
 * @description: 测试规则生成测试用例的Controller
 * */

@RestController
@RequestMapping("/ruleGenerateTestCase/*")
public class RuleGenerateTestCaseController {

    @Resource
    private TestRuleService testRuleService;

    @Resource
    private RuleGenerateTestCaseService ruleGenerateTestCaseService;

    @RequestMapping("/generateTestCase")
    public String generateTestCase(){
        System.out.println("Hello World");
        return "Success!!!!!!";
    }

    //显示所有规则信息
    @GetMapping("/getTestRules")
    public ResultVo getTestRules(@RequestParam("systemVersion")String systemVersion, @RequestParam("tradeName")String tradeName) {
        System.out.println("Hello World");
        System.out.println("Controller rev systemVersion:"+systemVersion);
        System.out.println("Controller rev tradeName:"+tradeName);
        return new ResultVo(ResutEnum.OK,testRuleService.getTestRules(systemVersion, tradeName));
//        ResultVo result;
//        result = new ResultVo(ResutEnum.OK,testRuleService.getTestRules());
//        return result;
    }

    //通过PICT生成测试用例文件
    @GetMapping("/generateTestCaseByPICT")
    public String generateTestCaseByPICT(@RequestParam("systemVersion")String systemName, @RequestParam("tradeName")String tradeName ){
        System.out.println("Begin To generateTestCase By PICT！");
        return ruleGenerateTestCaseService.generateTestCaseByPICT(systemName, tradeName);
       //return "Success!!!!!!";
    }
}
