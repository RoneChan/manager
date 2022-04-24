package com.example.demo.controller;

import com.example.demo.Vo.ResultVo;
import com.example.demo.constant.ResutEnum;
import com.example.demo.service.ResultMatchDictionaryService;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/getResultDetails")
    public ResultVo getResultDetails(){
        System.out.println("Hello World");
        return new ResultVo(ResutEnum.OK,resultMatchDictionaryService.getResultDetails());
    }
}
