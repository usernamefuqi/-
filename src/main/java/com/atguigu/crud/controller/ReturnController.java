package com.atguigu.crud.controller;

import com.atguigu.crud.bean.ReturnGoods;
import com.atguigu.crud.constant.Constant;
import com.atguigu.crud.service.GainGoodsService;
import com.atguigu.crud.service.ReturnGoodsService;
import com.atguigu.crud.util.DateUtil;
import com.atguigu.crud.vo.ReturnGoodsVo;
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
@RequestMapping("/Return")
public class ReturnController {

    @Autowired
    private ReturnGoodsService returnService;

    @Autowired
    private GainGoodsService gainGoodsService;

    //显示所有交付信息至后台
    @RequestMapping("/select")
    public String selectAll(HttpServletRequest request , @RequestParam(value = "pn", defaultValue = "1") Integer pn , Model model) {
        PageHelper.startPage(pn , Constant.PAGE_NUMBER);
        List<ReturnGoodsVo> retunrVoList = returnService.selectAll();

        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(retunrVoList , Constant.PAGE_NUMBER);
        model.addAttribute("pageInfo" , page);
        model.addAttribute("retunrVoList" , retunrVoList);
        return "returnList";
    }

    //按职员姓名查询所有离职记录显示至后台
    @RequestMapping("/selectByFlag")
    public String selectByReturnFlag(@RequestParam("returnFlag") String returnFlag ,
                                     @RequestParam(value = "pn", defaultValue = "1") Integer pn , Model model) {
        if (returnFlag == null || "".equals(returnFlag) || "交付".equals(returnFlag))
            return "forward:/Return/select";

        PageHelper.startPage(pn , Constant.PAGE_NUMBER);
        Boolean flag = false;
        if ("是".equals(returnFlag)) {
            flag = true;
        }
        List<ReturnGoodsVo> retunrVoList = returnService.selectByFlag(flag);

        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(retunrVoList , Constant.PAGE_NUMBER);
        model.addAttribute("pageInfo" , page);
        model.addAttribute("retunrVoList" , retunrVoList);
        return "returnList";
    }

    //用户进行交付物资
    @RequestMapping("/returnGoods")
    public String returnGoods(@RequestParam("gainId") Long gainId , HttpServletRequest request) {
        //更新交付表
        ReturnGoods returnGoods = new ReturnGoods(gainId , DateUtil.string1Date() , Constant.RETURN_FlAG_TRUE);
        int count = returnService.updateByGainId(returnGoods);

        //删除领取信息
        gainGoodsService.deleteById(gainId);

        return "forward:/Gain/selectGainById";
    }

}
