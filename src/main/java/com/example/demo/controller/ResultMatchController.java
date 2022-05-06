package com.example.demo.controller;

import com.example.demo.Vo.ResultVo;
import com.example.demo.constant.ResutEnum;
import com.example.demo.service.ResultMatchDictionaryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mucheng
 * @dateTime: 2022-04-24
 * @description: 预期结果映射字典维护的Controller
 * */
@RestController
@RequestMapping("/ResultMatchConfig/*")
public class ResultMatchController {

    @Resource
    private ResultMatchDictionaryService resultMatchDictionaryService;

    // 查询结果映射字典信息
    @RequestMapping("/getResultDetails")
    public ResultVo getResultDetails(){
        System.out.println("Hello World");
        return new ResultVo(ResutEnum.OK,resultMatchDictionaryService.getResultDetails());
    }

    //添加结果映射字典信息
    @RequestMapping("/addMatchConfig")
    public String addMatchConfig(@RequestParam("systemName")String systemName, @RequestParam("matchingResultKey")String matchingResultKey, @RequestParam("resultDetailDes")String resultDetailDes,@RequestParam("userName")String userName){
        System.out.println("addMatchConfig");
        return resultMatchDictionaryService.addResultMatchConfig(systemName,matchingResultKey,resultDetailDes,userName);
        //return new ResultVo(ResutEnum.OK,resultMatchDictionaryService.getResultDetails());
    }

}
