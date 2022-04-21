package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
该配置类是为了解决跨域问题
跨域问题产生：当我们的服务端和前端不在一个服务器或者在同一个服务器但是使用不同的接口时，就会出现跨域问题。跨域问题的出现是由于浏览器的同源策略。
 */
@Configuration
public class CorsConfig  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        设置允许跨域的路径
        registry.addMapping("/**")
                //.allowedOrigins("*")
//                设置允许跨域请求的域名
                .allowedOriginPatterns("*")
//                是否允许证书
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
                .allowedHeaders("*")
//                跨域允许时间
                .maxAge(3600);
    }
}
