package com.fanbo.user.apis.dao;

import com.fanbo.user.apis.beans.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: $description
 * @Author: FanBo
 * @Date: 2020/7/22
 */
@RestController
public interface UserDaoApi {

    @RequestMapping("/getUserInfo")
    public UserInfo getUserInfo();


}
