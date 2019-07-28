package com.yang.dependente.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: Yang
 * @date: 2019/7/27 15:22
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/loadBalance")
public class LoadBalanceController {

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/loadBalanceChoose")
    public void loadBalanceChoose() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("order-service");
//        log.error("========service:{}, host:{}, port:{}", serviceInstance.getInstanceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }

}
