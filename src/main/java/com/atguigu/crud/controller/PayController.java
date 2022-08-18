package com.atguigu.crud.controller;

import com.atguigu.crud.bean.PayGoods;
import com.atguigu.crud.bean.ReturnGoods;
import com.atguigu.crud.constant.Constant;
import com.atguigu.crud.service.GainGoodsService;
import com.atguigu.crud.service.PayGoodsService;
import com.atguigu.crud.service.ReturnGoodsService;
import com.atguigu.crud.util.DateUtil;
import com.atguigu.crud.vo.LeaveOfficeVo;
import com.atguigu.crud.vo.PayGoodsVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/Pay")
public class PayController {

    @Autowired
    private PayGoodsService payService;

    @Autowired
    private GainGoodsService gainGoodsService;

    @Autowired
    private ReturnGoodsService returnService;

    //显示所有赔偿信息至后台
    @RequestMapping("/select")
    public String selectAll(HttpServletRequest request, @RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, Constant.PAGE_NUMBER);
        List<PayGoodsVo> payGoodsVoList = payService.selectAll();

        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(payGoodsVoList,Constant.PAGE_NUMBER);
        model.addAttribute("pageInfo", page);
        model.addAttribute("payGoodsVoList" , payGoodsVoList);
        return "payList";
    }

    //按职员姓名查询所有离职记录显示至后台
    @RequestMapping("/selectByGoodsName")
    public String selectByGoodsName(@RequestParam("goodsName") String goodsName ,
                                    @RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model) {
        if (goodsName == null || "".equals(goodsName))
            return "forward:/Pay/select";

        PageHelper.startPage(pn , Constant.PAGE_NUMBER);
        List<PayGoodsVo> payGoodsVoList = payService.selectByGoodsName(goodsName);

        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(payGoodsVoList,Constant.PAGE_NUMBER);
        model.addAttribute("pageInfo", page);
        model.addAttribute("payGoodsVoList" , payGoodsVoList);
        return "payList";
    }

    //用户进行赔偿物资,数据信息录入数据库
    @RequestMapping("/payGoods")
    public String payGoods(@RequestParam("gainId") Long gainId) {
        //赔偿
        PayGoods payGoods = payService.selectByGainId(gainId);
        payService.insert(payGoods);

        //更新交付表
        ReturnGoods returnGoods = new ReturnGoods(gainId , DateUtil.string1Date() , Constant.RETURN_FlAG_TRUE);
        returnService.updateByGainId(returnGoods);

        //删除领取信息
        gainGoodsService.deleteById(gainId);

        return "forward:/Gain/selectGainById";
    }

}
