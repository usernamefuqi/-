package com.atguigu.crud.dao;

import com.atguigu.crud.bean.GainGoods;
import com.atguigu.crud.vo.GainGoodsVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GainGoodsMapper {

    /**
     *  按领取记录ID删除领取记录
     * @param gainId
     * @return
     */
    @Delete("delete from gain_goods where gain_id = #{gainId}")
    int deleteById(Long gainId);

    /**
     * 录入领取记录至数据库
     * @param record
     * @return
     */
    @Insert("insert into gain_goods (staff_id, goods_id,gain_time) values (#{staffId}, #{goodsId},#{gainTime})")
    int insert(GainGoods record);

    /**
     *  备份所有领取信息记录至数据库
     * @param gainGoods
     * @return
     */
    @Insert("insert into all_gains (staff_id, goods_id,gain_time) values (#{staffId}, #{goodsId},#{gainTime})")
    int allInsert(GainGoods gainGoods);

    /**
     * 三表联结查询：管理员查看所有物资领取信息
     * @return
     */
    @Select("SELECT gg.gain_id,gg.staff_id,e.staff_name,g.goods_name,gg.gain_time FROM gain_goods gg,entry_regist e,goods g WHERE gg.staff_id=e.staff_id AND gg.goods_id=g.goods_id")
    List<GainGoodsVo> selectAll();

    /**
     * 三表条件查询：管理员按物资名称查看领取信息
     * @param goodsName
     * @return
     */
    @Select("SELECT gg.gain_id,gg.staff_id,e.staff_name,g.goods_name,gg.gain_time FROM gain_goods gg,entry_regist e,goods g WHERE gg.staff_id=e.staff_id AND gg.goods_id=g.goods_id AND g.goods_name=#{goodsName}")
    List<GainGoodsVo> selectAllByName(String goodsName);

    /**
     * 查询物资是否已领取
     * @param staffId
     * @param goodsId
     * @return
     */
    @Select("SELECT * FROM gain_goods WHERE staff_id=#{staffId} AND goods_id=#{goodsId}")
    GainGoods selectById(@Param("staffId") Long staffId,@Param("goodsId") Long goodsId);

    /**
     * 查看自己已领取物资
     * @param staffId
     * @return
     */
    @Select("SELECT gg.gain_id,gg.staff_id,g.goods_name,gg.gain_time FROM gain_goods gg,goods g WHERE gg.goods_id=g.goods_id AND gg.staff_id=#{staffId}")
    List<GainGoodsVo> selectGainById(Long staffId);

}