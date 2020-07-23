package com.fanbo.app.feign;

import com.fanbo.user.apis.UserServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Description: $description
 * @Author: FanBo
 * @Date: 2020/7/22
 */
@FeignClient(name = "user-service")
public interface UserServiceApiFeign extends UserServiceApi {
}
