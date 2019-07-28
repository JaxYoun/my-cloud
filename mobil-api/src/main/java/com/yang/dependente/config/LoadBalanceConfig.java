package com.yang.dependente.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Yang
 * @date: 2019/7/27 15:28
 * @description: 声明负载均衡策略
 */
@Configuration
public class LoadBalanceConfig {

    @Bean
    public IRule ribbonRule() {
        //随机型负载均衡策略
//        return new RandomRule();

        //轮询型负载均衡策略
        return new RoundRobinRule();
    }

}
