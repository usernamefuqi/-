package com.atguigu.crud.bean;

import lombok.Data;

/**
 * 用户账户实体类
 */
@Data
public class User {
    private Long id;

    private String userName;

    private String password;

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}