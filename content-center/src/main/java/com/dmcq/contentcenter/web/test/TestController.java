package com.dmcq.contentcenter.web.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: qinhao25
 * @time: 2020/1/14 18:37
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/user/server")
    public List<ServiceInstance> getUserServerInstances(){
        return discoveryClient.getInstances("user-center");
    }
}
