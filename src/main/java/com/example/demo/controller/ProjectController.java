package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    String test(){
        return "Sdfsfsf";
    }

    @Value("${upload.path}")
    private String uploadPath;
    @Value("${address.webip}")
    private String IP;
    @RequestMapping("/uploadDoc")
    public void imgUpload(@RequestParam("file") MultipartFile file, HttpServletResponse response) {

        System.out.println("执行文件保存！");
        //设置服务器上图片保存地址
        //String path = "E:/RuleAssets";
        File filePath = new File(uploadPath);
        System.out.println("文件的保存路径：" + uploadPath);
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
        File targetFile = new File(uploadPath, fileName);
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


}
