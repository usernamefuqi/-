package com.atguigu.crud.service;

import com.atguigu.crud.bean.GainGoods;
import com.atguigu.crud.vo.GainGoodsVo;
import java.util.List;

/**
 * 物资领取信息
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-08-11 16:46:17
 */
public interface GainGoodsService{

    int deleteById(Long gainId);

    List<GainGoodsVo> selectAll();

    List<GainGoodsVo> selectAllByName(String goodsName);

    GainGoods selectById(Long staffId,Long goodsId);

    List<GainGoodsVo> selectGainById(Long staffId);

    int insert(GainGoods record);

    int allInsert(GainGoods gainGoods);
}

