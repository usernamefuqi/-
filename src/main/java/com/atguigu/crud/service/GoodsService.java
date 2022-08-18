package com.atguigu.crud.service;

import com.atguigu.crud.bean.Goods;

import java.util.List;

/**
 * 物资信息
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-08-11 16:46:17
 */
public interface GoodsService  {

    int deleteById(Long goodsId);

    int insert(Goods record);

    Goods selectById(Long goodsId);

    List<Goods> selectByGoodsName(String goodsName);

    List<Goods> selectAll();

    int updateGoods(Goods goods);

}

