package com.atguigu.crud.dao;

import org.apache.ibatis.annotations.Delete;

public interface UserRegistMapper {

    /**
     *  按入职登记职员ID删除入职用户账户关系表记录
     * @param registId
     * @return
     */
    @Delete("delete from user_regist where regist_id = #{registId}")
    int deleteById(Long registId);

}