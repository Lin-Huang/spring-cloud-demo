package com.lin.feign.controller;

import com.lin.feign.client.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {
    @Autowired
    private DcClient dcClient;

    @GetMapping("/consumer")
    public String dc() {
        // 定义的feign客户端来调用服务提供方的接口
        return dcClient.consumer();
    }
}
