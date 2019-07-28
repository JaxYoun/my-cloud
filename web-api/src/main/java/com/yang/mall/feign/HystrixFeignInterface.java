package com.yang.mall.feign;

import com.yang.mall.domain.Point;
import com.yang.mall.feign.fallback.HystrixFeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: Yang
 * @date: 2019/7/27 19:55
 * @description:
 */
//@FeignClient(name = "point-service", fallback = HystrixFeignFallbackImpl.class)
@FeignClient(name = "point-service", fallbackFactory = HystrixFeignFallbackFactory.class)
public interface HystrixFeignInterface {

    /**
     * 获取积分，此处声明的请求url描述的是【生产方】的url
     *
     * @return
     */
    @GetMapping(value = "/point/getPoint")
    Point getOrderFallBack();
}
