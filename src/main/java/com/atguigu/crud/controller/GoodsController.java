package com.atguigu.crud.controller;

import com.atguigu.crud.bean.EntryRegist;
import com.atguigu.crud.bean.Goods;
import com.atguigu.crud.constant.Constant;
import com.atguigu.crud.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/Goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    //显示所有物资信息至管理员后台
    @RequestMapping("/select")
    public String selectAll(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, Constant.PAGE_NUMBER);
        List<Goods> goodsList = goodsService.selectAll();

        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(goodsList,Constant.PAGE_NUMBER);
        model.addAttribute("pageInfo", page);
        model.addAttribute("goodsList",goodsList);
        return "goodsList";
    }

    //显示所有物资信息至用户前台
    @RequestMapping("/selectU")
    public String selectAllU(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, Constant.PAGE_NUMBER);
        List<Goods> goodsList = goodsService.selectAll();

        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(goodsList,Constant.PAGE_NUMBER);
        model.addAttribute("pageInfo", page);
        model.addAttribute("goodsList",goodsList);
        return "fore/goodsListU";
    }

    //按物资名称查询所有物资信息记录显示至后台
    @RequestMapping(value = "/selectByName", method = RequestMethod.GET)
    public String selectByGoodsName(@RequestParam("goodsName") String goodsName , HttpServletRequest request,
                                    @RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model) {
        if (goodsName == null || "".equals(goodsName))
            return "forward:/Goods/select";

        PageHelper.startPage(pn, Constant.PAGE_NUMBER);
        List<Goods> goodsList = goodsService.selectByGoodsName(goodsName);

        PageInfo page = new PageInfo(goodsList,Constant.PAGE_NUMBER);
        model.addAttribute("pageInfo", page);
        request.setAttribute("goodsList" , goodsList);
        return "goodsList";
    }

    //物资信息录入数据库
    @RequestMapping("/add")
    public String add(@RequestParam("name") String name , @RequestParam("price") String price) {
        Double prices = Double.parseDouble(price);
        if (name == null || "".equals(null))
            return "goodsAdd";

        Goods goods = new Goods(name , prices);
        int count = goodsService.insert(goods);
        if (count <= 0) {
            return "goodsAdd";
        }

        return "forward:/Goods/select";
    }

    //按物资ID删除物资信息
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteById(@RequestParam("goodsId") Long goodsId) {
        goodsService.deleteById(goodsId);

        return "forward:/Goods/select";

    }

    //按
    @RequestMapping("/selectById/{goodsId}")
    public ModelAndView selectById(@PathVariable("goodsId") Long goodsId) {
        Goods goods = goodsService.selectById(goodsId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("goods" , goods);
        modelAndView.setViewName("goodsUpdate");
        return modelAndView;
    }

    @RequestMapping("/update")
    public String update(Goods goods) {
        goodsService.updateGoods(goods);

        return "forward:/Goods/select";

    }

}
