package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//定义mapper区
@MapperScan("com.example.demo.mapper")
public class ManagerApplication {


    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }

}
