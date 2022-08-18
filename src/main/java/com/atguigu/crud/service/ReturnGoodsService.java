package com.atguigu.crud.service;

import com.atguigu.crud.bean.ReturnGoods;
import com.atguigu.crud.vo.ReturnGoodsVo;

import java.util.List;

/**
 * 物资交付信息
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-08-11 16:46:17
 */
public interface ReturnGoodsService{

    List<ReturnGoodsVo> selectAll();

    int insert(ReturnGoods returnGoods);

    int updateByGainId(ReturnGoods returnGoods);

    List<ReturnGoodsVo> selectByFlag(Boolean returnFlag);
}

