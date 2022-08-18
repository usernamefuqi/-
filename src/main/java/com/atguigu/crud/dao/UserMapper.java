package com.atguigu.crud.dao;

import com.atguigu.crud.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    /**
     * 按账户id删除账户（离职）
     * @param id
     * @return
     */
    @Delete("delete from user where id = #{id}")
    int deleteById(Long id);

    /**
     *  添加账户至数据库
     * @param user
     * @return
     */
    @Insert("insert into user values(#{id}, #{userName}, #{password})")
    int insert(User user);

    /**
     * 按账户id查询账户
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User selectById(Long id);

    /**
     * 按id修改账户
     * @param user
     * @return
     */
    @Update("update user set user_name = #{userName},password = #{password} where id = #{id}")
    int updateById(User user);

    /**
     * 从数据库检索账户名和密码
     * @param aname
     * @param apassword
     * @return
     */
    @Select("select user_name, password from user where user_name=#{name} and password=#{password}")
    String queryByNamePwd(@Param("name") String aname, @Param("password") String apassword);

    /**
     * 管理员获取刚入职职员初始化账户ID
     * @param user
     * @return
     */
    @Select("select id from user where user_name=#{userName} and password=#{password}")
    Long getId(User user);

}