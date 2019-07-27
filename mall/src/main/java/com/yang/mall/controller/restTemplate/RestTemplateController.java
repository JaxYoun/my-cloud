package com.yang.mall.controller.restTemplate;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Yang
 * @date: 2019/7/27 10:10
 * @description:
 */
@RestController
@RequestMapping("/mall")
public class RestTemplateController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getOrder")
    public Order getOrder() {
        return this.restTemplate.getForObject("http://localhost:9090/order/get/99", Order.class);
    }

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/getServiceInstanceList")
    public List<ServiceInstance> getServiceInstanceList() {
        return this.discoveryClient.getInstances("order-service");
    }

}
