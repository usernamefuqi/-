package com.atguigu.crud.service.impl;

import com.atguigu.crud.bean.EntryRegist;
import com.atguigu.crud.bean.UserRegist;
import com.atguigu.crud.dao.EntryRegistMapper;
import com.atguigu.crud.service.EntryRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EntryRegistServiceImpl implements EntryRegistService {

    @Autowired
    private EntryRegistMapper entryMapper;

    @Override
    public List<EntryRegist> selectAll() {
        return entryMapper.selectAll();
    }

    @Override
    public EntryRegist selectById(Long staffId) {
        return entryMapper.selectByPrimaryKey(staffId);
    }

    @Override
    public List<EntryRegist> selectByName(String staffName) {
        return entryMapper.selectByName(staffName);
    }

    @Override
    public int insert(EntryRegist record) {
        return entryMapper.insert(record);
    }

    @Override
    public int insertUserRegist(UserRegist userRegist) {
        return entryMapper.insertUserRegist(userRegist);
    }

    @Override
    public int update(EntryRegist record) {
        return entryMapper.updateByPrimaryKey(record);
    }

    @Override
    public Long getId(EntryRegist entryRegist) {
        return entryMapper.getId(entryRegist);
    }

    public Long getById(Long userId){
        return entryMapper.getById(userId);
    }

}
