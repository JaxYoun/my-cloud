package com.yang.pointservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PointServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PointServiceApplication.class, args);
    }

}
