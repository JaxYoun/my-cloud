package com.yang.mall.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Yang
 * @date: 2019/7/27 15:33
 * @description:
 */
@Configuration
@RibbonClient(name = "order-service", configuration = LoadBalanceConfig.class)
public class AllocatedLoadBalanceConfig {
}
