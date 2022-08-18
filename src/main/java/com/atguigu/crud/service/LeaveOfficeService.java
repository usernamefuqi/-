package com.atguigu.crud.service;


import com.atguigu.crud.bean.LeaveOffice;
import com.atguigu.crud.vo.LeaveOfficeVo;

import java.util.List;

/**
 * 离职信息
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-08-11 16:46:17
 */
public interface LeaveOfficeService {

    int insert(LeaveOffice record);

    List<LeaveOfficeVo> selectAll();

    List<LeaveOfficeVo> selectByStaffName(String staffName);

}

