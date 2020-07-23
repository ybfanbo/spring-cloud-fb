package com.fanbo.user.impl;

import com.fanbo.user.apis.UserServiceApi;
import com.fanbo.user.apis.beans.UserInfo;
import com.fanbo.user.feign.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: $description
 * @Author: FanBo
 * @Date: 2020/7/22
 */
@RestController
public class UserServiceApiImpl implements UserServiceApi {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @Override
    @RequestMapping("/getUserInfo2")
    public UserInfo getUserInfo() {
        return userServiceFeign.getUserInfo();
    }

}
