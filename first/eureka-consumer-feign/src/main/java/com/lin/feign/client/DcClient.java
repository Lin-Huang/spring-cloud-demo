package com.lin.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// 指定这个接口所要调用的服务名称
@FeignClient("eureka-client")
public interface DcClient {

    // 使用Spring MVC的注解绑定服务提供方的REST接口
    @GetMapping("/dc")
    String consumer();
}
