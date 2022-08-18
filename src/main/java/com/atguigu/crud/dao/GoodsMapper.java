package com.atguigu.crud.dao;

import com.atguigu.crud.bean.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodsMapper {

    /**
     * 按物资ID删除物资
     * @param goodsId
     * @return
     */
    @Delete("delete from goods where goods_id = #{goodsId}")
    int deleteById(Long goodsId);

    /**
     * 录入物资信息至数据库
     * @param record
     * @return
     */
    @Insert("insert into goods (goods_name, goods_price) values (#{goodsName}, #{goodsPrice})")
    int insert(Goods record);

    /**
     *  按物资ID查询物资
     * @param goodsId
     * @return
     */
    @Select("select * from goods where goods_id = #{goodsId}")
    Goods selectById(Long goodsId);

    /**
     *  按物资名称查询物资
     * @param goodsName
     * @return
     */
    @Select("select * from goods where goods_name = #{goodsName}")
    List<Goods> selectByGoodsName(@Param("goodsName") String goodsName);

    /**
     *  查询所有物资记录信息
     * @return
     */
    @Select("select * from goods")
    List<Goods> selectAll();

    /**
     *  按物资ID更新物资信息
     * @param goods
     * @return
     */
    @Update("update goods set goods_name = #{goodsName},goods_price = #{goodsPrice} where goods_id = #{goodsId}")
    int updateGoods(Goods goods);

}