package com.atguigu.crud.service.impl;

import com.atguigu.crud.bean.PayGoods;
import com.atguigu.crud.dao.PayGoodsMapper;
import com.atguigu.crud.service.PayGoodsService;
import com.atguigu.crud.vo.PayGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PayGoodsServiceImpl implements PayGoodsService {

    @Autowired
    private PayGoodsMapper payMapper;

    @Override
    public int insert(PayGoods payGoods) {
        return payMapper.insert(payGoods);
    }

    @Override
    public List<PayGoodsVo> selectAll() {
        return payMapper.selectAll();
    }

    @Override
    public PayGoods selectByGainId(Long gainId) {
        return payMapper.selectByGainId(gainId);
    }

    @Override
    public List<PayGoodsVo> selectByGoodsName(String goodsName) {
        return payMapper.selectByGoodsName(goodsName);
    }
}
