package com.example.demo.controller;

import com.example.demo.dto.TestRuleManage;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;



    //获取到项目的概要
    @RequestMapping("/getProjectProfile")
    public ProjectProfile getProjectProfile(String id,String test_system){
        ProjectProfile projectProfile=projectService.getProjectProfile(id,test_system);
        return projectProfile;
    }

    //根据搜索词搜索项目
    @RequestMapping("/searchProjectList")
    List<ProjectProfile> searchProjectList(int search_type,String keyword){
        List<ProjectProfile>  list= projectService.searchProjectList(search_type,keyword);
        return list;
    }

    //获取项目概要列表
    @RequestMapping("/getProjectList")
    List<ProjectProfile> getProjectList(int year , String startNum,String endNum){
        List<ProjectProfile> list=projectService.getProjectList(year, startNum, endNum);
        return list;
    }

    //获取项目进程
    @RequestMapping("/getProjectProgress")
    ProjectProgress getProjectProgress(String id){
        ProjectProgress projectProgress=projectService.getProjectProgress(id);
        return projectProgress;
    }

    @RequestMapping("/getTesterName")
    public List<String> getTesterName(String id,String test_system){
        List<String> nameList=projectService.getTesterName(id,test_system);
        return nameList;
    }


    //获取项目测试人员工作量
    @RequestMapping("/getTesterWorkload")
    List<TesterWorkload> getTesterWorkload(String id, int year){
        List<TesterWorkload> testerWorkloadList=projectService.getTesterWorkload(id,year);
        return testerWorkloadList;
    }

    @RequestMapping("/test")
    void test(){

    }

    @Value("${upload.PICT-path}")
    private String PICTUploadPath;

    @Value("${address.webip}")
    private String IP;
    @RequestMapping("/uploadPICTDoc")
    public void PICTUpload(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
        System.out.println("执行文件保存！");
        //设置服务器上图片保存地址
        //String path = "E:/RuleAssets/PICT";
        File filePath = new File(PICTUploadPath);
        System.out.println("文件的保存路径：" + PICTUploadPath);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFileName = file.getOriginalFilename();
        originalFileName = originalFileName.replaceAll(",|&|=", "");
        System.out.println("原始文件名称：" + originalFileName);
        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型：" + type);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));
        //设置文件新名称: 当前时间+文件名称（不包含格式）
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String date = sdf.format(d);
        //String fileName ="a"+date + name + "." + type;
        String fileName = date + "." + type;
        System.out.println("新文件名称：" + fileName);
        //在指定路径下创建一个文件
        File targetFile = new File(PICTUploadPath, fileName);
        //将文件保存到服务器指定位置
        try {
            file.transferTo(targetFile);
            System.out.println("上传成功");

            //将文件在服务器的存储路径返回
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(IP+"RuleAssets/"+fileName);

        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
            System.out.println(e);
        }
    }

    @Value("${upload.graphwalker-path}")
    private String GraphwalkerUploadPath;
    @RequestMapping("/uploadGraphwalkerDoc")
    public void GraphwalkerUpload(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
        System.out.println("执行文件保存！");
        //设置服务器上图片保存地址
        //String path = "E:/RuleAssets/Graphwalker";
        File filePath = new File(GraphwalkerUploadPath);
        System.out.println("文件的保存路径：" + GraphwalkerUploadPath);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFileName = file.getOriginalFilename();
        originalFileName = originalFileName.replaceAll(",|&|=", "");
        System.out.println("原始文件名称：" + originalFileName);
        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型：" + type);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));
        //设置文件新名称: 当前时间+文件名称（不包含格式）
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String date = sdf.format(d);
        //String fileName ="a"+date + name + "." + type;
        String fileName = date + "." + type;
        System.out.println("新文件名称：" + fileName);
        //在指定路径下创建一个文件
        File targetFile = new File(GraphwalkerUploadPath, fileName);
        //将文件保存到服务器指定位置
        try {
            file.transferTo(targetFile);
            System.out.println("上传成功");

            //将文件在服务器的存储路径返回
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(IP + "RuleAssets/" + fileName);

        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
            System.out.println(e);
        }

    }

    @RequestMapping("/CaseCreate")
    public void CaseCreate(@RequestBody List<TestRuleManage>data){
        Multimap<String,String> ruleMap  = ArrayListMultimap.create();
        //输入输出
        ArrayList<ArrayList<String>> ruleList = new ArrayList<>();
        ArrayList<String> ruleDescribeList = new ArrayList<>();
        Multimap<String,Integer> resultMap  = ArrayListMultimap.create();
        int sceneStartPos;
        int sceneEndPos;
        int describePos;
        for(int i=0;i<data.size();i++){
            TestRuleManage temp = data.get(i);
            sceneStartPos = 0;
            sceneEndPos=0;
            describePos=0;
            // 规则描述
            String strDescribe = temp.getRuleDescribe();
            describePos=strDescribe.indexOf("[");
            String subStrDescribe = strDescribe.substring(0,describePos);

            // 输入项或输出项
            String ioIteam = temp.getIoIteam();
            // 测试覆盖项(TCI)
            String TestCovItem = temp.getTestCovItem();
            ArrayList<String> tempList = new ArrayList<>();
            while(true){
                sceneEndPos = ioIteam.indexOf("|;|",sceneStartPos);
                if(sceneEndPos == -1){
                    String subStrIoIteam = ioIteam.substring(sceneStartPos);
                    ruleMap.put(subStrDescribe,subStrIoIteam);
                    tempList.add(subStrIoIteam);
                    System.out.println(subStrIoIteam);
                    break;
                }
                String subStrIoIteam = ioIteam.substring(sceneStartPos,sceneEndPos);
                sceneStartPos = sceneEndPos + 3;
                ruleMap.put(subStrDescribe,subStrIoIteam);
                tempList.add(subStrIoIteam);

                System.out.println(subStrIoIteam);
            }
            ruleDescribeList.add(subStrDescribe);
            ruleList.add(tempList);
            String result = temp.getTestCovItem();
            resultMap.put(result,(Integer) i);
        }
        System.out.println("sdfsdf");

        String content="";
        Iterator iterator = resultMap.keySet().iterator();

        while(iterator.hasNext()){
            String result = (String)iterator.next();
            List<Integer> index =(List<Integer>) resultMap.get(result);
            String str = "";
            for(int k=0 ;k<index.size();k++){
                int tempIndex = index.get(k);
                String describestr = ruleDescribeList.get(tempIndex);
                ArrayList<String> inputList = ruleList.get(tempIndex);
                str = str + "IF [" + describestr + "] IN {";
                for (int p = 0;p<inputList.size();p++){
                    if(k<index.size()-1) {
                        str = str + "\"" + inputList.get(p) + "\",";
                    }else {
                        str = str + "\"" + inputList.get(p);
                    }
                }
                if(k<index.size()-1) {
                    str = str + "\"} AND " + '\n';
                }else{
                    str = str + "\"} " + '\n';
                }
            }
            content = content + str + "THEN [$预期结果] = \"" + result +"\";" +'\n' +'\n';

                    System.out.println(content);
        }

    }
}
