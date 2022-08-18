package com.atguigu.crud.vo;

import lombok.Data;

import java.util.Date;

@Data
public class LeaveOfficeVo {

    private Long staffId;

    private String staffName;

    private String phone;

    private Date leaveTime;

    public LeaveOfficeVo() {
    }

    public LeaveOfficeVo(Long staffId , String staffName , String phone , Date leaveTime) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.phone = phone;
        this.leaveTime = leaveTime;
    }
}