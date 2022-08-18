package com.atguigu.crud.service.impl;

import com.atguigu.crud.bean.User;
import com.atguigu.crud.dao.UserMapper;
import com.atguigu.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteById(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User selectById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public int updateById(User user) {

        return userMapper.updateById(user);

    }

    @Override
    public String queryByNamePwd(String aname, String apassword) {
        return userMapper.queryByNamePwd(aname, apassword);
    }

    @Override
    public Long getId(User user) {
        return userMapper.getId(user);
    }
}
