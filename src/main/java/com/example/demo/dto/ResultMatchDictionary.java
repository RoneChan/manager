package com.example.demo.dto;
import lombok.Data;

import java.sql.Time;

/**
 * @author mucheng
 * @detaTime: 2022-04-24
 * @description: 预期结果映射字典的数据实体
 * */

@Data
public class ResultMatchDictionary {
    // 主键
    private Integer id;
    // 系统名称
    private String systemName;
    // 待匹配结果关键字
    private String matchingResultKey;
    // 预期结果详细描述
    private String resultDetailDes;
    // 规则字典维护人员
    private String userName;
    //提交时间
    private Time submitTime;
    //修改时间
    private Time modifyTime;
    //预留字段
    private String Fstandby1;
    //预留字段
    private String Fstandby2;
    //预留字段
    private String Fstandby3;
}
