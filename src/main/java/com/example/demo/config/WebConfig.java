package com.example.demo.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${upload.PICT-path}")
    private String PICTUploadPath;
    @Value("${upload.graphwalker-path}")
    private String GraphwalkerUploadPath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        /**
         * "/getimg/**" 为前端URL访问路径
         * "file:" + uploadPath 是本地磁盘映射
         */


/*        registry.addResourceHandler("/RuleAssets/PICT").addResourceLocations("file:" + PICTUploadPath);
        registry.addResourceHandler("/RuleAssets/Graphwalker").addResourceLocations("file:" + GraphwalkerUploadPath);
        */
    }
}
