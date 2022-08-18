package com.atguigu.crud.dao;

import com.atguigu.crud.bean.EntryRegist;
import com.atguigu.crud.bean.UserRegist;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface EntryRegistMapper {

    /**
     * 添加入职信息：入职职员信息录入数据库
     * @param record
     * @return
     */
    @Insert("insert into entry_regist values(null, #{staffName}, #{sex},#{age}, #{phone}, #{address},#{entryTime})")
    int insert(EntryRegist record);

    /**
     * 添加入职职员账户关系记录
     * @param userRegist
     * @return
     */
    @Insert("insert into user_regist (user_id, regist_id) values (#{userId}, #{registId})")
    int insertUserRegist(UserRegist userRegist);

    /**
     * 按职员ID查询入职登记信息
     * @param staffId
     * @return
     */
    @Select("select * from entry_regist where staff_id = #{staffId}")
    EntryRegist selectByPrimaryKey(Long staffId);

    /**
     * 按职员姓名查询入职登记信息
     * @param staffName
     * @return
     */
    @Select("select * from entry_regist where staff_name = #{staffName}")
    List<EntryRegist> selectByName(String staffName);

    /**
     * 查询所有入职登记信息
     * @return
     */
    @Select("select * from entry_regist")
    List<EntryRegist> selectAll();

    /**
     * 按职员ID更新入职登记信息
     * @param record
     * @return
     */
    @Update("update entry_regist set staff_name = #{staffName},sex = #{sex},age = #{age},phone = #{phone},address = #{address} where staff_id = #{staffId}")
    int updateByPrimaryKey(EntryRegist record);

    /**
     *  管理员获取当前入职职员ID
     * @param entryRegist
     * @return
     */
    @Select("select staff_id from entry_regist where staff_name=#{staffName} and sex=#{sex} and age=#{age} and phone=#{phone} and address=#{address} and entry_time=#{entryTime}")
    Long getId(EntryRegist entryRegist);

    /**
     *  用户获取自己的职员ID
     * @param userId
     * @return
     */
    @Select("SELECT staff_id FROM entry_regist WHERE staff_id in (SELECT regist_id FROM `user_regist` where user_id = #{userId})")
    Long getById(Long userId);
}