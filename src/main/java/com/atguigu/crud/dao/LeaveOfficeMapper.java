package com.atguigu.crud.dao;

import com.atguigu.crud.bean.LeaveOffice;
import com.atguigu.crud.vo.LeaveOfficeVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LeaveOfficeMapper {

    /**
     *  增加离职：职员进行离职
     * @param record
     * @return
     */
    @Insert("insert into leave_office(staff_id, leave_time) values(#{staffId}, #{leaveTime})")
    int insert(LeaveOffice record);

    /**
     * 双表联结查询：管理员查看所有离职人员
     * @return
     */
    @Select("SELECT e.staff_id,e.staff_name,e.phone,l.leave_time FROM leave_office l,entry_regist e WHERE l.staff_id=e.staff_id")
    List<LeaveOfficeVo> selectAll();

    /**
     * 双表条件查询：管理员按职员姓名查看离职人员
     * @param staffName
     * @return
     */
    @Select("SELECT e.staff_id,e.staff_name,e.phone,l.leave_time FROM leave_office l,entry_regist e WHERE l.staff_id=e.staff_id AND e.staff_name=#{staffName}")
    List<LeaveOfficeVo> selectByStaffName(String staffName);

}