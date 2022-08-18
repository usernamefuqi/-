package com.atguigu.crud.service.impl;

import com.atguigu.crud.bean.ReturnGoods;
import com.atguigu.crud.dao.ReturnGoodsMapper;
import com.atguigu.crud.service.ReturnGoodsService;
import com.atguigu.crud.vo.ReturnGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReturnGoodsServiceImpl implements ReturnGoodsService {

    @Autowired
    private ReturnGoodsMapper returnGoodsMapper;

    @Override
    public List<ReturnGoodsVo> selectAll() {
        return returnGoodsMapper.selectAll();
    }

    @Override
    public int insert(ReturnGoods returnGoods) {
        return returnGoodsMapper.insert(returnGoods);
    }

    @Override
    public int updateByGainId(ReturnGoods returnGoods) {
        return returnGoodsMapper.updateByGainId(returnGoods);
    }

    @Override
    public List<ReturnGoodsVo> selectByFlag(Boolean returnFlag) {
        return returnGoodsMapper.selectByFlag(returnFlag);
    }
}
