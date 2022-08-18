package com.atguigu.crud.service;

import com.atguigu.crud.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户登录
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-08-11 16:46:17
 */
public interface UserService {

    int deleteById(Long id);

    int insert(User user);

    User selectById(Long id);

    List<User> selectAll();

    /**
     * 按id修改账户
     * @param user
     * @return
     */
    int updateById(User user);

    String queryByNamePwd(String aname,String apassword);

    Long getId(User user);
}

