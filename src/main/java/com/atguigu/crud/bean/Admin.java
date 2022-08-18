package com.atguigu.crud.bean;

import lombok.Data;

/**
 * 管理员账户实体类
 */
@Data
public class Admin {
    private Integer id;

    private String name;

    private String password;

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}