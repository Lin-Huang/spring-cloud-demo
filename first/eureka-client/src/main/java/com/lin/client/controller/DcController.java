package com.lin.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc(){
        String service = "Service: " + discoveryClient.getServices();
        System.err.println(service);
        return service;
    }
}
