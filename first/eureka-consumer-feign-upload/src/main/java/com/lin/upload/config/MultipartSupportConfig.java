package com.lin.upload.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Configuration;


// 上传文件配置
@Configuration
public class MultipartSupportConfig {

    public Encoder feignFormEncoder(){
        return new SpringFormEncoder();
    }
}
