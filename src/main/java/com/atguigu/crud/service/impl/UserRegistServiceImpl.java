package com.atguigu.crud.service.impl;

import com.atguigu.crud.dao.UserRegistMapper;
import com.atguigu.crud.service.UserRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistServiceImpl implements UserRegistService {

    @Autowired
    UserRegistMapper userRegistMapper;

    public int deleteById(Long registId){
        return userRegistMapper.deleteById(registId);
    }
}
