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
    @Value("${upload.PICT-output-path}")
    private String PICTOutput;
    @Value("${upload.graphwalker-output-path}")
    private String GraphwalkerOutput;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        /**
         * "/xxx/**" 为前端URL访问路径
         * "file:" + uploadPath 是本地磁盘映射
         */

        registry.addResourceHandler("/TC_PICT/**").addResourceLocations("file:" + PICTUploadPath);
        registry.addResourceHandler("/TC_GW/**").addResourceLocations("file:" + GraphwalkerUploadPath);
        registry.addResourceHandler("/FILE_PICT/**").addResourceLocations("file:" + PICTOutput);
        registry.addResourceHandler("/GRAPH_GW/**").addResourceLocations("file:" + GraphwalkerOutput);

     //   registry.addResourceHandler("/TC_PICT/**").addResourceLocations("file:///E://RuleAssets//PICT/" );
    }
}
