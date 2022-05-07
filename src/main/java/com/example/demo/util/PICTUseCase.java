package com.example.demo.util;

import com.alibaba.excel.EasyExcel;
import com.example.demo.entity.UseCaseInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class PICTUseCase {
    public String getPICTUseCase(String tradeName,String txtPath) {
        //String tradeName = "转数快";
        //String fileName = "20220429162447398.txt";

        String txtName = txtPath.substring(txtPath.indexOf("RuleTxt\\")+8, txtPath.indexOf(".txt"));
        String tmpFileName = "E:\\RuleAssets\\PICT\\Output\\" + txtName + ".xls";
        String cmdStr = "cmd /c cd /d E:\\RuleAssets\\PICT\\RuleTxt && pict " + txtPath;

        List<String> outputStr = new ArrayList<>(); //运行结果
        List<UseCaseInfo> useCaseInfoList = new ArrayList<>();
        try {
            Process proc = Runtime.getRuntime().exec(cmdStr);
            InputStream fis = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("GBK"));
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            String head = br.readLine();
            StringTokenizer headerToken = new StringTokenizer(head, "\t");
            int count = headerToken.countTokens();
            String[] headArr = new String[count];
            int i = 0;
            while (headerToken.hasMoreElements()) {
                headArr[i++] = headerToken.nextToken();
            }
            //直到读完为止
            while ((line = br.readLine()) != null) {
                String description = tradeName + "-";
                String steps = "步骤一：进入" + tradeName + "交易\n步骤二：设置参数";
                String result = "";
                StringTokenizer token = new StringTokenizer(line, "\t");

                for (int k = 0; k < count - 1; k++) {
                    steps = steps + headArr[k] + ":" + token.nextToken() + ",";
                }
                steps = steps + "\n步骤三：输入其他数据，提交交易。";
                result = token.nextToken();
                description = description + result;
                UseCaseInfo useCaseInfo = new UseCaseInfo(description, steps, result);
                useCaseInfoList.add(useCaseInfo);
                //outputStr.add(line.substring(1,line.length()-1));
            }
            EasyExcel.write(tmpFileName, UseCaseInfo.class).sheet("Use Cases").doWrite(useCaseInfoList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmpFileName;
    }
}

