package com.atguigu.crud.service;


import com.atguigu.crud.bean.PayGoods;
import com.atguigu.crud.vo.PayGoodsVo;

import java.util.List;

/**
 * 赔偿信息
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-08-11 16:46:17
 */
public interface PayGoodsService  {

    int insert(PayGoods payGoods);

    List<PayGoodsVo> selectAll();

    PayGoods selectByGainId(Long gainId);

    List<PayGoodsVo> selectByGoodsName(String goodsName);
}

