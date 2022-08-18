package com.atguigu.crud.dao;

import com.atguigu.crud.bean.ReturnGoods;
import com.atguigu.crud.vo.ReturnGoodsVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ReturnGoodsMapper {

    /**
     *  增加交付：用户进行交付物资
     * @param returnGoods
     * @return
     */
    @Insert("insert into return_goods values(#{id}, #{staffId}, #{gainId},#{returnTime}, #{returnFlag})")
    int insert(ReturnGoods returnGoods);

    /*@Select("select * from return_goods where id = #{id}")
    ReturnGoods selectById(Long id);*/

    /**
     * 四表条件查询：管理员查看全部交付信息
     * @return
     */
    @Select("SELECT r.staff_id,e.staff_name,e.phone,g.goods_name,r.return_time,r.return_flag " +
            "FROM return_goods r,all_gains ag,goods g,entry_regist e " +
            "WHERE r.staff_id=e.staff_id AND r.gain_id=ag.gain_id AND ag.goods_id=g.goods_id")
    List<ReturnGoodsVo> selectAll();

    /**
     * 四表条件查询：管理员查看全部交付信息
     * @return
     */
    @Select("SELECT r.staff_id,e.staff_name,e.phone,g.goods_name,r.return_time,r.return_flag " +
            "FROM return_goods r,all_gains ag,goods g,entry_regist e " +
            "WHERE r.staff_id=e.staff_id AND r.gain_id=ag.gain_id AND ag.goods_id=g.goods_id AND r.return_flag=#{returnFlag}")
    List<ReturnGoodsVo> selectByFlag(Boolean returnFlag);

    /**
     * 更新交付信息：用户进行交付后，更新交付表信息
     * @param returnGoods
     * @return
     */
    @Update("update return_goods set return_time = #{returnTime},return_flag = #{returnFlag} where gain_id = #{gainId}")
    int updateByGainId(ReturnGoods returnGoods);

}