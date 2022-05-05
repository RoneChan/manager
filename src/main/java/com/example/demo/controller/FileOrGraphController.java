package com.example.demo.controller;

import com.example.demo.dto.FileOrGraphManage;
import com.example.demo.service.FileOrGraphService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
public class FileOrGraphController {

    @Resource
    private FileOrGraphService fileOrGraphService;

    //查询用例文件、PICT规则文件、Graphm图文件
    @RequestMapping("/getDownloadFile")
    public List<FileOrGraphManage> getDownloadFile(@RequestParam("systemVersion")String systemVersion, @RequestParam("tradeName")String tradeName, @RequestParam("fileType")Integer fileType){
        List<FileOrGraphManage> resultList = new ArrayList<>();

        /*
        //测试数据
        LocalDateTime time = LocalDateTime.now();
        FileOrGraphManage file1 = new FileOrGraphManage("PAIC","交易1","http://127.0.0.1:8086/TC_GW/20220427112650749.graphml",time,"文件1");
        FileOrGraphManage file2 = new FileOrGraphManage("PAIC","交易2","http://127.0.0.1:8086/TC_PICT/20220426105505205.xls",time,"文件2");
        resultList.add(file1);
        resultList.add(file2);
*/

        //正常使用逻辑
        if (!systemVersion.equals("")){
            if(!tradeName.equals("")){
                if(fileType ==-1){
                    resultList = fileOrGraphService.getfilePathBySysAndTradeName(systemVersion,tradeName);
                    //System.out.println("getfilePathBySysAndTradeName");
                }else{
                    resultList = fileOrGraphService.getfilePathByAll(systemVersion,tradeName,fileType);
                    //System.out.println("getfilePathByAll");
                }
            }else{
                if(fileType == -1) {
                    resultList = fileOrGraphService.getfilePathBySystemName(systemVersion);
                    //System.out.println("getfilePathBySystemName");
                }else{
                    resultList = fileOrGraphService.getfilePathBySystemNameAndType(systemVersion,fileType);
                   // System.out.println("getfilePathBySystemNameAndType");
                }
            }
        }else{
            if(tradeName.equals("")) {
                if(fileType == -1) {
                    resultList = fileOrGraphService.getFileOrGraphs();
                  //  System.out.println("getFileOrGraphs");
                }else{
                    resultList = fileOrGraphService.getfilePathByType(fileType);
                  //  System.out.println("getfilePathByType");
                }
            }else{
                if(fileType == -1) {
                    resultList = fileOrGraphService.getfilePathByTradeName(tradeName);
                    //System.out.println("getfilePathByTradeName");
                }else{
                    resultList = fileOrGraphService.getfilePathByTradeNameAndType(tradeName,fileType);
                   // System.out.println("getfilePathByTradeNameAndType");
                }
            }
        }

        return resultList;
    }


}
