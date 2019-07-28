package com.yang.mall.feign.fallback;

import com.yang.mall.domain.Point;
import com.yang.mall.feign.HystrixFeignInterface;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: Yang
 * @date: 2019/7/27 20:00
 * @description:
 */
@Component
public class HystrixFeignFallbackFactory implements FallbackFactory<HystrixFeignInterface> {

    @Override
    public HystrixFeignInterface create(Throwable throwable) {
        return new HystrixFeignInterface() {
            @Override
            public Point getOrderFallBack() {
                Point point = new Point();
                point.setId("hystrixFeignFallBack");
                point.setName("hystrixFeignFallBack");
                point.setCreateTime(new Date());
                return point;
            }
        };
    }
}
