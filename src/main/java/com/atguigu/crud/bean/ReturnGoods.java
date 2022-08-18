package com.atguigu.crud.bean;

import lombok.Data;

import java.util.Date;

/**
 * 交付实体类
 */
@Data
public class ReturnGoods {
    private Long id;

    private Long staffId;

    private Long gainId;

    private Date returnTime;

    private Boolean returnFlag;

    public ReturnGoods() {
    }

    public ReturnGoods(Long staffId , Long gainId) {
        this.staffId = staffId;
        this.gainId = gainId;
        this.returnFlag = false;
    }

    public ReturnGoods(Long gainId , Date returnTime , Boolean returnFlag) {
        this.gainId = gainId;
        this.returnTime = returnTime;
        this.returnFlag = returnFlag;
    }
}