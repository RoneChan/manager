package com.example.demo.constant;

import lombok.Getter;

/**
 * @author mucheng
 * @dateTime: 2022-04-28
 * @description: 保存的文件类型枚举
 * */
@Getter
public enum FileTypeEnum {
    //定义枚举值
    TC_PICT(0,"PICT用例文件"),
    TC_GW(1,"GraphWalker用例文件"),
    FILE_PICT(2,"PICT规则文件"),
    GRAPH_GW(3,"Graphml图文件");

    Integer code;
    String message;
    FileTypeEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
