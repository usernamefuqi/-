package com.atguigu.crud.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ReturnGoodsVo {

    private Long staffId;

    private String staffName;

    private String phone;

    private String goodsName;

    private Date returnTime;

    private Boolean returnFlag;

}