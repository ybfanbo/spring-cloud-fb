package com.fanbo.order.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderDaoImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderDaoImplApplication.class, args);
    }

}
