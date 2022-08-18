package com.atguigu.crud.bean;

import lombok.Data;

/**
 * 赔偿实体类
 */
@Data
public class PayGoods {
    private Long id;

    private Long staffId;

    private Long goodsId;

    private Double payPrice;
}