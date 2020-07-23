package com.fanbo.user.apis.beans;

import java.io.Serializable;

/**
 * @Description: $description
 * @Author: FanBo
 * @Date: 2020/7/22
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -2547112809568031004L;

    private Integer age;
    private String name;

    public UserInfo(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public UserInfo() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
