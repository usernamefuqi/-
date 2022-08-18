package com.atguigu.crud.bean;

import lombok.Data;

import java.util.Date;

/**
 * 入职登记实体类
 */
@Data
public class EntryRegist {
    private Long staffId;

    private String staffName;

    private Boolean sex;

    private Integer age;

    private String phone;

    private String address;

    private Date entryTime;

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

}