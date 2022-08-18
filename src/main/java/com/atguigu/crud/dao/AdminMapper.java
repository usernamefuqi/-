package com.atguigu.crud.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {

    /**
     * 查询管理员账户
     * @param aname
     * @param apassword
     * @return
     */
    @Select("select name, password from admin where name=#{name} and password=#{password}")
    String queryByNamePwd(@Param("name") String aname,@Param("password") String apassword);

}