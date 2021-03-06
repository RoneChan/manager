package com.example.demo.util;

import com.example.demo.dto.TestRuleManage;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TxtTransform {
    public String wangyinTxtTransform(List<TestRuleManage> data) {
        Multimap<String, String> ruleMap = ArrayListMultimap.create();
        //输入输出
        ArrayList<ArrayList<String>> ruleList = new ArrayList<>();
        ArrayList<String> ruleDescribeList = new ArrayList<>();
        Multimap<String, Integer> resultMap = ArrayListMultimap.create();
        int sceneStartPos=0;
        int sceneEndPos=0;
        int describePos=0;
        for (int i = 0; i < data.size(); i++) {
            TestRuleManage temp = data.get(i);
            sceneStartPos = 0;
            sceneEndPos = 0;
            describePos = 0;
            // 规则描述
            String strDescribe = temp.getRuleDescribe();
            describePos = strDescribe.indexOf("[");
            String subStrDescribe = strDescribe.substring(0, describePos);

            // 输入项或输出项
            String ioIteam = temp.getIoIteam();
            // 测试覆盖项(TCI)
            String TestCovItem = temp.getTestCovItem();
            ArrayList<String> tempList = new ArrayList<>();
            while (true) {
                sceneEndPos = ioIteam.indexOf("|;|", sceneStartPos);
                if (sceneEndPos == -1) {
                    String subStrIoIteam = ioIteam.substring(sceneStartPos);
                    ruleMap.put(subStrDescribe, subStrIoIteam);
                    if(subStrIoIteam.charAt(0) == '~'){
                        tempList.add(subStrIoIteam.substring(1));
                    }else{
                        tempList.add(subStrIoIteam);
                    }
                    System.out.println(subStrIoIteam);
                    break;
                }
                String subStrIoIteam = ioIteam.substring(sceneStartPos, sceneEndPos);
                sceneStartPos = sceneEndPos + 3;
                ruleMap.put(subStrDescribe, subStrIoIteam);
                if(subStrIoIteam.charAt(0) == '~'){
                    tempList.add(subStrIoIteam.substring(1));
                }else{
                    tempList.add(subStrIoIteam);
                }

                System.out.println(subStrIoIteam);
            }
            ruleDescribeList.add(subStrDescribe);
            ruleList.add(tempList);
            String result = temp.getTestCovItem();
            resultMap.put(result, (Integer) i);
        }

        String ruleContent = "";
        Iterator ruleIterator = ruleMap.keySet().iterator();
        while (ruleIterator.hasNext()) {
            String str = "";
            String describe = (String) ruleIterator.next();
            List<String> index = (List<String>) ruleMap.get(describe);
            str = str + describe + ":";
            for (int k = 0; k < index.size(); k++) {
                String ioIteam = index.get(k);
                if (k < index.size() - 1) {
                    str = str + ioIteam + ",";
                } else {
                    str = str + ioIteam + "\n\n";
                }
            }
            ruleContent = ruleContent + str;

        }


        String reultStr = "$预期结果:";
        String resultContent = "";
        Iterator iterator = resultMap.keySet().iterator();

        while (iterator.hasNext()) {
            String result = (String) iterator.next();
            List<Integer> index = (List<Integer>) resultMap.get(result);
            String str = "IF ";
            reultStr = reultStr + result + ",";
            String connectStr="";
            if(result.equals("交易成功")){
                connectStr = "AND";
            }else{
                connectStr = "OR";
            }
            for (int k = 0; k < index.size(); k++) {
                int tempIndex = index.get(k);
                String describestr = ruleDescribeList.get(tempIndex);
                ArrayList<String> inputList = ruleList.get(tempIndex);
                str = str + "[" + describestr + "] IN {";
                for (int p = 0; p < inputList.size(); p++) {
                    if (p < inputList.size() - 1) {
                        str = str + "\"" + inputList.get(p) + "\",";
                    } else {
                        str = str + "\"" + inputList.get(p);
                    }
                }
                if (k < index.size() - 1) {
                    str = str + "\"} "+connectStr + '\n';
                } else {
                    str = str + "\"} " + '\n';
                }
            }
            resultContent = resultContent + str + "THEN [$预期结果] = \"" + result + "\";" + '\n' + '\n';
        }
        reultStr = reultStr.substring(0, reultStr.length() - 1) + "\n\n";
        String txtPath = writeTxt(ruleContent + reultStr + resultContent);
        return txtPath;
    }

    private String path = "D:/RuleAssets/PICT/RuleTxt/";
    public String writeTxt(String content) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String date = sdf.format(d);
        String fileName = date + ".txt";
        String filePath = path + fileName;
        File writefile;
        boolean append = true;  //  是否追加
        writefile = new File(filePath);
        if (writefile.exists() == false)   // 判断文件是否存在，不存在则生成
        {
            try {
                writefile.createNewFile();
                writefile = new File(filePath);
            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        } else {        // 存在先删除，再创建
            writefile.delete();
            try {
                writefile.createNewFile();
                writefile = new File(filePath);

            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
        try {
            //FileWriter fw = new FileWriter(writefile, append);
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(writefile),"GBK");
            BufferedWriter bw = new BufferedWriter(write);
            bw.write(content);
            bw.flush();
            bw.close();
            OutputExcel(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

    private String OutputExcel(String fileName){
        int pos = fileName.indexOf(".txt");
        CMDUtil cmdUtil = new CMDUtil();
        String excelName = fileName.substring(0,pos) + ".xls";
        String cmdStr = "cmd /c cd /d D:\\RuleAssets\\PICT\\RuleTxt && pict " + fileName+  " > " + excelName;
        System.out.println(cmdStr);
        cmdUtil.excuteCMDCommand(cmdStr);
        System.out.println("Begin To generateTestCase By PICT！");
        return excelName;
    }
}
