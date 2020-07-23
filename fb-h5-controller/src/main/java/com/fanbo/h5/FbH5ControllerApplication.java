package com.fanbo.h5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FbH5ControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FbH5ControllerApplication.class, args);
    }

}
