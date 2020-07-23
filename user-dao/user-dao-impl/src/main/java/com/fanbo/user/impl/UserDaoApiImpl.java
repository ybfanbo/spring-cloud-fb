package com.fanbo.user.impl;

import com.fanbo.user.apis.beans.UserInfo;
import com.fanbo.user.apis.dao.UserDaoApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: $description
 * @Author: FanBo
 * @Date: 2020/7/22
 */
@RestController
public class UserDaoApiImpl implements UserDaoApi {

    @Override
    @RequestMapping("/getUserInfo")
    public UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo(111, "老王");
        return userInfo;
    }

}
