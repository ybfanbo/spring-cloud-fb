package com.fanbo.user.feign;

import com.fanbo.user.apis.dao.UserDaoApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Description: $description
 * @Author: FanBo
 * @Date: 2020/7/22
 */
@FeignClient(name = "user-dao")
public interface UserServiceFeign extends UserDaoApi {

}
