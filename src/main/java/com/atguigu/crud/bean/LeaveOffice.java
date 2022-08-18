package com.atguigu.crud.bean;

import lombok.Data;

import java.util.Date;

/**
 * 离职实体类
 */
@Data
public class LeaveOffice {
    private Long id;

    private Long staffId;

    private Date leaveTime;

}