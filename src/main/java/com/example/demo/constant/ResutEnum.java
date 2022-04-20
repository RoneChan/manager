package com.example.demo.constant;

import lombok.Getter;

/**
 * @author mucheng
 * @dateTime: 2022-04-16
 * @description: 数据交互响应-提示
 * */
@Getter
public enum ResutEnum {
    OK(2000,"成功"),
    Error(5000,"失败");
    ResutEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    Integer code;
    String message;
}
