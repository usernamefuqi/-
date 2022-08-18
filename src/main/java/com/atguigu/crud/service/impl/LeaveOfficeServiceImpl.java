package com.atguigu.crud.service.impl;

import com.atguigu.crud.bean.LeaveOffice;
import com.atguigu.crud.dao.LeaveOfficeMapper;
import com.atguigu.crud.service.LeaveOfficeService;
import com.atguigu.crud.vo.LeaveOfficeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LeaveOfficeServiceImpl implements LeaveOfficeService {

    @Autowired
    private LeaveOfficeMapper leaveOfficeMapper ;

    @Override
    public int insert(LeaveOffice record){
        return leaveOfficeMapper.insert(record);
    }

    @Override
    public List<LeaveOfficeVo> selectAll() {

        return leaveOfficeMapper.selectAll();
    }

    @Override
    public List<LeaveOfficeVo> selectByStaffName(String staffName) {
        return leaveOfficeMapper.selectByStaffName(staffName);
    }

}
