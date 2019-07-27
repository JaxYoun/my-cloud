package com.yang.mall.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Yang
 * @date: 2019/7/27 15:27
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/discover")
public class DiscoverControler {

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/getServiceInstanceList")
    public List<ServiceInstance> getServiceInstanceList() {
        return this.discoveryClient.getInstances("order-service");
    }

}
