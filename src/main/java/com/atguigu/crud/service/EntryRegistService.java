package com.atguigu.crud.service;

import com.atguigu.crud.bean.EntryRegist;
import com.atguigu.crud.bean.UserRegist;

import java.util.List;

/**
 * 入职登记信息
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-08-11 16:46:17
 */

public interface EntryRegistService{

    List<EntryRegist> selectAll();

    EntryRegist selectById(Long staffId);

    List<EntryRegist> selectByName(String staffName);

    int insert(EntryRegist record);

    int insertUserRegist(UserRegist userRegist);

    int update(EntryRegist record);

    Long getId(EntryRegist entryRegist);

    Long getById(Long userId);
}

