package com.atguigu.crud.service.impl;

import com.atguigu.crud.dao.AdminMapper;
import com.atguigu.crud.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public String queryByNamePwd(String aname,String apassword){
        return adminMapper.queryByNamePwd(aname,apassword);
    }
}
