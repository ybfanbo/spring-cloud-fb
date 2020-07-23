package com.fanbo.app.controller;

import com.fanbo.app.feign.UserServiceApiFeign;
import com.fanbo.user.apis.beans.UserInfo;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceApiFeign userServiceApiFeign;

    @RequestMapping("/getUserInfo")
    public String getUserInfo(){
        UserInfo userInfo = userServiceApiFeign.getUserInfo();
        return "来自 fb-app-controller userAge=" + userInfo.getAge() + " userName=" + userInfo.getName();
    }

    @RequestMapping("/getThreadName")
    public String getThreadName(){
        return "调userService返回的结果: ";
        /**
         * 默认情况下，tomcat只有一个线程池处理所有请求
         * 配置最大线程数：
         * server:
         *   port: 8001
         *   tomcat:
         *     threads:
         *       max: 10
         * */
    }


}
