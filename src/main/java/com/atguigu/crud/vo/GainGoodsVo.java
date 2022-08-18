package com.atguigu.crud.vo;

import lombok.Data;

import java.util.Date;

@Data
public class GainGoodsVo {

    private Long gainId;

    private Long staffId;

    private String staffName;

    private String goodsName;

    private Date gainTime;

}
