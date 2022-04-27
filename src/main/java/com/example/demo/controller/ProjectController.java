package com.example.demo.controller;

import com.example.demo.dto.TestRuleManage;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import com.example.demo.util.TxtTransform;
import com.alibaba.excel.EasyExcel;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
    String test(){
        return "sdfsdfs";
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
    public void GraphwalkerUpload(@RequestParam("file") MultipartFile file,@RequestParam("tradename") String tradename, HttpServletResponse response) {
        System.out.println(tradename);
        System.out.println("执行文件保存！");
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
        TxtTransform transform = new TxtTransform();
        transform.wangyinTxtTransform(data);
    }


    //前端传送数据到后台
    @RequestMapping("/uploadTestRules")
    public void uploadTestRules(@RequestParam String name, @RequestBody List<TestRuleManage>data) {
        System.out.println("uploadTestRules By PICT！");
    }

    //Graphwalker生成用例接口
    @RequestMapping("/graphwalkerTestCreate")
    ResponseEntity<FileSystemResource> graphwalkerTestCreate(@RequestParam String systemName,@RequestParam String tradeName){
        //模拟容器
        //tradeName = "ITS发起的客户汇款往报交易";
        Map<String, String> ruleTable = new HashMap<String,String>();
        ruleTable.put("解析成功","1.报文解析成功，可在业务查询查看到一条记录；\n" +
                "2.进入业务查询页面查看解析结果，按照平台编号、报文参考号、业务种类、收报时间、币种、来报发报行、来报金额、来源渠道、去向渠道、来报种类、去报种类展示正确；");
        ruleTable.put("解析失败", "1.报文解析失败，可在业务查询查看到一条记录；\n" +
                "2.进入业务查询页面查看，显示疑似重报，已自动注销；");
        ruleTable.put("自动清分失败", "1.来报要素不完整，自动清分失败，生成人工清分待处理任务；\n" +
                "2.进入业务查询页面查看，显示自动清分失败；");
        ruleTable.put("自动清分成功", "1.来报要素完整，正确判定来源渠道，去向渠道；\n" +
                "2.进入业务查询页面查看，显示自动清分成功；");
        ruleTable.put("人工清分成功", "1.人工选择清分去向，提示录入成功，复核通过；\n" +
                "2.进入业务查询页面查看，显示人工清分成功；");
        ruleTable.put("人工清分注销", "1.人工选择清分注销，提示录入成功，复核通过；\n" +
                "2.进入业务查询页面查看交易，显示已注销；");
        ruleTable.put("组报成功", "1.进入业务查询页面查看，显示组报成功；");
        ruleTable.put("发报成功", "1.进入报文查询页面查看，能查到报文平台的去报响应；\n" +
                "2.进入业务查询页面查看，显示发报成功；");
        ruleTable.put("发报失败", "1.进入报文查询页面查看，查不到报文平台的去报响应；\n" +
                "2.进入业务查询页面查看，显示状态还停在组报成功；");
        ruleTable.put("自动重发失败", "1.进入报文查询页面查看，查不到报文平台的去报响应；\n" +
                "2.日志查询，该交易已重发五次，均未收到响应；");
        ruleTable.put("自动重发成功", "1.进入报文查询页面查看，能查到报文平台的去报响应；\n" +
                "2.进入业务查询页面查看，显示发报成功；");
        ruleTable.put("交易成功", "1.进入报文查询页面查看，查到与原汇款报文相关联的交易成功回执报文；\n" +
                "2.进入业务查询页面查看，更新原汇款交易的业务状态、终止标识、去向方处理状态；\n" +
                "3.将交易成功状态通知给ITS；");
        ruleTable.put("交易失败", "1.进入报文查询页面查看，查到与原汇款报文相关联的交易拒绝回执报文；\n" +
                "2.进入业务查询页面查看，更新原汇款交易的业务状态、终止标识、去向方处理状态；\n" +
                "3.将交易拒绝状态通知给ITS；");

        String hmlPath = "D:\\xunleixiazai\\2022-03\\paic_03.graphml";

        String[] cmd = {"cmd", "/C", "java -jar -Dfile.encoding=utf-8 D:\\xunleixiazai\\2022-03\\graphwalker-cli-4.3.1.jar offline -m "+ hmlPath+"quick_random(edge_coverage(100))\""};
        List<String> outputStr = new ArrayList<>(); //运行结果
        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            InputStream fis = proc.getInputStream();
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            String line=null;
            //直到读完为止
            while((line=br.readLine())!=null) {
                outputStr.add(line.substring(1,line.length()-1));
            }
            //按路径分组
            List<List<String>> use_pathes = new ArrayList<>();
            List<String> use_path = new ArrayList<>();
            for (int i = 0; i<outputStr.size(); i++) {
                String elemStr = outputStr.get(i);
                String[] elem = elemStr.split(":");
                if(elem[1].length() > 2) {//非空行保存
                    use_path.add(outputStr.get(i));
                } else {
                    if(use_path.size()!=0) {
                        use_pathes.add(use_path);
                    }
                    use_path = new ArrayList<>();
                }
            }
            //分小组
            List<List<String>> use_cases = new ArrayList<>();
            for (List<String> use_path_tmp:use_pathes) {
                for (int i = 0; i<use_path_tmp.size() - 1; i = i + 2) {
                    List<String> use_case = new ArrayList<>();
                    use_case.add(use_path_tmp.get(i));
                    use_case.add(use_path_tmp.get(i+1));
                    use_case.add(use_path_tmp.get(i+2));
                    use_cases.add(use_case);
                }
            }

            List<UseCaseInfo> useCaseInfos = new ArrayList<UseCaseInfo>();
            //生成条目, usecase:v-e-v
            for (List<String> use_case: use_cases) {
                UseCaseInfo caseInfo = new UseCaseInfo();
                if(!caseInfo.parseCase(use_case, tradeName, ruleTable)) {
                    return (ResponseEntity<FileSystemResource>) ResponseEntity.internalServerError();
                    //return "Parse use case failed.";
                }
                useCaseInfos.add(caseInfo);
            }
            //输出excel
            String tmpFileName = "D:\\TestJavaExcel\\test2.xlsx";
            //表头
            List<List<String>> tableHeader = new ArrayList<>();
            List<String> head0 = new ArrayList<>();
            head0.add("用例描述");
            List<String> head1 = new ArrayList<>();
            head1.add("用例步骤");
            List<String> head2 = new ArrayList<>();
            head2.add("预期结果");
            tableHeader.add(head0);
            tableHeader.add(head1);
            tableHeader.add(head2);
            List<List<Object>> dataList = new ArrayList<>();
            Map<String,Boolean> checkRepeat = new HashMap<>();
            for (UseCaseInfo caseInfo:useCaseInfos) {
                //重复的不写
                if (checkRepeat.get(caseInfo.getSteps()) != null) {
                    continue;
                } else {
                    checkRepeat.put(caseInfo.getSteps(), true);
                }
                //遍历写内容
                List<Object> data = new ArrayList<>();
                data.add(caseInfo.getDescription());
                data.add(caseInfo.getSteps());
                data.add(caseInfo.getResult());
                dataList.add(data);
            }
            EasyExcel.write(tmpFileName).head(tableHeader).sheet("Use Cases").doWrite(dataList);
            //返回文件
            String contentDisposition = ContentDisposition
                    .builder("attachment")
                    .filename("UseCases.xlsx")
                    .build().toString();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                    .header(HttpHeaders.CONTENT_TYPE, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                    .body(new FileSystemResource(tmpFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (ResponseEntity<FileSystemResource>) ResponseEntity.noContent();
    }

}
