package com.atguigu.crud.controller;

import com.atguigu.crud.bean.GainGoods;
import com.atguigu.crud.bean.Goods;
import com.atguigu.crud.bean.ReturnGoods;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.constant.Constant;
import com.atguigu.crud.service.EntryRegistService;
import com.atguigu.crud.service.GainGoodsService;
import com.atguigu.crud.service.ReturnGoodsService;
import com.atguigu.crud.util.DateUtil;
import com.atguigu.crud.vo.GainGoodsVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Gain")
public class GainController {

    @Autowired
    private GainGoodsService gainService;

    @Autowired
    private EntryRegistService entryRegistService;

    @Autowired
    private GainGoodsService gainGoodsService;

    @Autowired
    private ReturnGoodsService returnService;

    //显示所有领取记录至后台
    @RequestMapping("/select")
    public String selectAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn , Model model) {
        PageHelper.startPage(pn , Constant.PAGE_NUMBER);
        List<GainGoodsVo> gainGoodsVoList = gainService.selectAll();

        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(gainGoodsVoList , Constant.PAGE_NUMBER);
        model.addAttribute("pageInfo" , page);
        model.addAttribute("gainGoodsVoList" , gainGoodsVoList);
        return "gainList";
    }

    //按物资名称查询所有领取记录显示至后台
    @RequestMapping(value = "/selectAllByName", method = RequestMethod.GET)
    public String selectAllByGoodsName(@RequestParam("goodsName") String goodsName ,
                                    @RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model) {
        if (goodsName == null || "".equals(goodsName))
            return "forward:/Gain/select";

        PageHelper.startPage(pn , Constant.PAGE_NUMBER);
        List<GainGoodsVo> gainGoodsVoList = gainService.selectAllByName(goodsName);

        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(gainGoodsVoList , Constant.PAGE_NUMBER);
        model.addAttribute("pageInfo" , page);
        model.addAttribute("gainGoodsVoList" , gainGoodsVoList);
        return "gainList";
    }

    //添加领取信息至数据库
    @RequestMapping("/add")
    public String addGain(@RequestParam("goodsId") Long goodsId , HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Long userId = user.getId();

        Long staffId = entryRegistService.getById(userId);  //获取当前用户职员ID

        GainGoods gainGoods = gainGoodsService.selectById(staffId , goodsId);
        if (gainGoods == null) {
            gainGoodsService.insert(new GainGoods(staffId,goodsId,DateUtil.string1Date())); //领取
            gainGoodsService.allInsert(new GainGoods(staffId,goodsId,DateUtil.string1Date()));  //备份所有领取记录
            GainGoods gainGoods1 = gainGoodsService.selectById(staffId , goodsId);
            returnService.insert(new ReturnGoods(staffId,gainGoods1.getGainId()));
        }

        return "forward:/Goods/selectU";
    }

    //按职员ID查询个人领取物资信息至后台
    @RequestMapping("/selectGainById")
    public String selectGainById(HttpServletRequest request , @RequestParam(value = "pn", defaultValue = "1") Integer pn , Model model) {
        User user = (User) request.getSession().getAttribute("user");
        Long userId = user.getId();

        Long staffId = entryRegistService.getById(userId);

        PageHelper.startPage(pn , Constant.PAGE_NUMBER);
        List<GainGoodsVo> gainGoodsVoList = gainGoodsService.selectGainById(staffId);

        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(gainGoodsVoList , Constant.PAGE_NUMBER);
        model.addAttribute("pageInfo" , page);
        model.addAttribute("gainGoodsVoList" , gainGoodsVoList);

        return "fore/gainListU";
    }

    //按物资名称查询个人领取物资信息至后台
    @RequestMapping(value = "/selectByName", method = RequestMethod.GET)
    public String selectByGoodsName(@RequestParam("goodsName") String goodsName , HttpServletRequest request,
                                    @RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model) {
        if (goodsName == null || "".equals(goodsName))
            return "forward:/Gain/selectGainById";

        User user = (User) request.getSession().getAttribute("user");
        Long userId = user.getId();
        Long staffId = entryRegistService.getById(userId);
        PageHelper.startPage(pn, Constant.PAGE_NUMBER);
        List<GainGoodsVo> gainGoodsVoList = gainGoodsService.selectGainById(staffId);
        List<GainGoodsVo> findByGoodsName = new ArrayList<GainGoodsVo>();

        //条件查询：从已领取物资中按物资名称查找物资信息
        for (GainGoodsVo gainGoodsVo : gainGoodsVoList) {
            if (goodsName.equals(gainGoodsVo.getGoodsName())){
                findByGoodsName.add(gainGoodsVo);
            }
        }

        PageInfo page = new PageInfo(findByGoodsName,Constant.PAGE_NUMBER);
        model.addAttribute("pageInfo", page);
        request.setAttribute("gainGoodsVoList" , findByGoodsName);
        return "fore/gainListU";
    }

}
