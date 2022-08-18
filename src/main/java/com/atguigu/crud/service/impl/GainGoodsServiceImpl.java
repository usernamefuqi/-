package com.atguigu.crud.service.impl;

import com.atguigu.crud.bean.GainGoods;
import com.atguigu.crud.dao.GainGoodsMapper;
import com.atguigu.crud.service.GainGoodsService;
import com.atguigu.crud.vo.GainGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GainGoodsServiceImpl implements GainGoodsService {

    @Autowired
    private GainGoodsMapper gainGoodsMapper;

    @Override
    public int deleteById(Long gainId) {
        return gainGoodsMapper.deleteById(gainId);
    }

    @Override
    public List<GainGoodsVo> selectAll() {
        return gainGoodsMapper.selectAll();
    }

    @Override
    public List<GainGoodsVo> selectAllByName(String goodsName) {
        return gainGoodsMapper.selectAllByName(goodsName);
    }

    @Override
    public GainGoods selectById(Long staffId , Long goodsId) {
        return gainGoodsMapper.selectById(staffId , goodsId);
    }

    @Override
    public List<GainGoodsVo> selectGainById(Long staffId) {
        return gainGoodsMapper.selectGainById(staffId);
    }

    public int insert(GainGoods record){
        return gainGoodsMapper.insert(record);
    }

    @Override
    public int allInsert(GainGoods gainGoods) {
        return gainGoodsMapper.allInsert(gainGoods);
    }
}
