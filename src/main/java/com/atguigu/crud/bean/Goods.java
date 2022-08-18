package com.atguigu.crud.bean;

import lombok.Data;

/**
 * 物资实体类
 */
@Data
public class Goods {
    private Long goodsId;

    private String goodsName;

    private Double goodsPrice;

    public Goods() {
    }

    public Goods(String goodsName , Double goodsPrice) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

}