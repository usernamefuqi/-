package com.atguigu.crud.service.impl;

import com.atguigu.crud.bean.Goods;
import com.atguigu.crud.dao.GoodsMapper;
import com.atguigu.crud.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int deleteById(Long goodsId) {
        return goodsMapper.deleteById(goodsId);
    }

    @Override
    public int insert(Goods record) {
        return goodsMapper.insert(record);
    }

    @Override
    public Goods selectById(Long goodsId) {
        return goodsMapper.selectById(goodsId);
    }

    @Override
    public List<Goods> selectByGoodsName(String goodsName) {
        return goodsMapper.selectByGoodsName(goodsName);
    }

    @Override
    public List<Goods> selectAll() {
        return goodsMapper.selectAll();
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }


}
