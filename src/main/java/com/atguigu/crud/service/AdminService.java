package com.atguigu.crud.service;

/**
 * 管理员登录
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-08-11 16:46:17
 */
public interface AdminService{
    public String queryByNamePwd(String aname,String apassword);
}

