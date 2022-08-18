package com.atguigu.crud.bean;

import lombok.Data;

import java.util.Date;

/**
 * 物资领取实体类
 */
@Data
public class GainGoods {
    private Long gainId;

    private Long staffId;

    private Long goodsId;

    private Date gainTime;

    public GainGoods() {
    }

    public GainGoods(Long staffId , Long goodsId , Date gainTime) {
        this.staffId = staffId;
        this.goodsId = goodsId;
        this.gainTime = gainTime;
    }
}