package com.atguigu.crud.dao;

import com.atguigu.crud.bean.PayGoods;
import com.atguigu.crud.vo.PayGoodsVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PayGoodsMapper {

    /**
     *  增加赔偿信息：用户进行赔偿物资
     * @param payGoods
     * @return
     */
    @Insert("insert into pay_goods values(#{id}, #{staffId}, #{goodsId},#{payPrice})")
    int insert(PayGoods payGoods);

    /**
     * 双表条件查询：用户按领取记录ID查询赔偿信息
     * @param gainId
     * @return
     */
    @Select("SELECT gg.staff_id,gg.goods_id,g.goods_price as payPrice FROM gain_goods gg,goods g WHERE gg.goods_id = g.goods_id AND gg.gain_id=#{gainId}")
    PayGoods selectByGainId(Long gainId);


    /**
     *  三表联结查询：管理员查看所有已赔偿信息
     * @return
     */
    @Select("SELECT e.staff_id,e.staff_name,g.goods_name,p.pay_price FROM pay_goods p,entry_regist e,goods g WHERE p.staff_id=e.staff_id and p.goods_id=g.goods_id")
    List<PayGoodsVo> selectAll();

    /**
     * 三表条件查询：管理员根据物资名称查看所有已赔偿信息
     * @param goodsName
     * @return
     */
    @Select("SELECT e.staff_id,e.staff_name,g.goods_name,p.pay_price FROM pay_goods p,entry_regist e,goods g WHERE p.staff_id=e.staff_id AND p.goods_id=g.goods_id AND g.goods_name=#{goodsName}")
    List<PayGoodsVo> selectByGoodsName(String goodsName);

}