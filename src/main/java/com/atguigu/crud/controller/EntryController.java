package com.atguigu.crud.controller;

import com.atguigu.crud.bean.EntryRegist;
import com.atguigu.crud.bean.Goods;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.bean.UserRegist;
import com.atguigu.crud.constant.Constant;
import com.atguigu.crud.service.EntryRegistService;
import com.atguigu.crud.service.UserService;
import com.atguigu.crud.util.DateUtil;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Entry")
public class EntryController {

    @Autowired
    EntryRegistService entryService;

    @Autowired
    UserService userService;

    //显示所有入职登记记录至后台
    @RequestMapping("/select")
    public String select(@RequestParam(value = "pn", defaultValue = "1") Integer pn , Model model) {
        PageHelper.startPage(pn , Constant.PAGE_NUMBER);
        List<EntryRegist> entryList = entryService.selectAll();

        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(entryList , Constant.PAGE_NUMBER);
        model.addAttribute("pageInfo" , page);
        model.addAttribute("entryList" , entryList);
        return "entryList";
    }

    //入职登记信息、账户信息、关系信息录入数据库
    @RequestMapping("/add")
    public String add(HttpServletRequest request) {
        EntryRegist entryRegist = new EntryRegist();

        entryRegist.setEntryTime(DateUtil.string3Date());
        entryRegist.setAddress(request.getParameter("address"));
        entryRegist.setPhone(request.getParameter("phone"));
        String sex = request.getParameter("sex");
        Boolean b = false;
        if ("男".equals(sex)) {
            b = true;
        }
        String name = request.getParameter("name");
        entryRegist.setSex(b);
        entryRegist.setStaffName(name);
        entryRegist.setAge(Integer.parseInt(request.getParameter("age")));
        int sult = entryService.insert(entryRegist);
        Long registId = entryService.getId(entryRegist);
        System.out.println(registId);

        User user = new User();
        user.setUserName(name + registId);
        user.setPassword(Constant.INIT_PASSWARD);

        int fult = userService.insert(user);
        Long userId = userService.getId(user);

        UserRegist userRegist = new UserRegist();
        userRegist.setRegistId(registId);
        userRegist.setUserId(userId);

        entryService.insertUserRegist(userRegist);

        return "forward:/Entry/select";
    }

    //按职员ID查询入职登记信息
    @RequestMapping(value = "/selectById/{staffId}", method = RequestMethod.GET)
    public ModelAndView selectById(@PathVariable("staffId") Long staffId) {
        EntryRegist entryRegist = entryService.selectById(staffId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("entryRegist" , entryRegist);
        modelAndView.setViewName("entryUpdate");
        return modelAndView;
    }

    //按职员姓名查询入职登记信息
    @RequestMapping(value = "/selectByName", method = RequestMethod.GET)
    public String selectByGoodsName(@RequestParam("staffName") String staffName ,
                                    @RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model) {
        if (staffName == null || "".equals(staffName))
            return "forward:/Entry/select";

        PageHelper.startPage(pn, Constant.PAGE_NUMBER);
        List<EntryRegist> entryList = entryService.selectByName(staffName);

        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(entryList , Constant.PAGE_NUMBER);
        model.addAttribute("pageInfo" , page);
        model.addAttribute("entryList" , entryList);
        return "entryList";
    }

    //按账户ID查询职员信息
    @RequestMapping(value = "selectById", method = RequestMethod.GET)
    public ModelAndView selectByIdU(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");
        EntryRegist entryRegist = entryService.selectById(user.getId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("entryRegist" , entryRegist);
        modelAndView.setViewName("fore/userMessage");
        return modelAndView;
    }

    //职员修改个人信息
    @RequestMapping("/update")
    public String update(HttpServletRequest request) {
        EntryRegist entryRegist = new EntryRegist();
        entryRegist.setStaffId(Long.parseLong(request.getParameter("staffId")));
        entryRegist.setAddress(request.getParameter("address"));
        entryRegist.setPhone(request.getParameter("phone"));
        String sex = request.getParameter("sex");
        Boolean b = false;
        if ("男".equals(sex)) {
            b = true;
        }
        entryRegist.setSex(b);
        entryRegist.setStaffName(request.getParameter("staffName"));
        entryRegist.setAge(Integer.parseInt(request.getParameter("age")));

        entryService.update(entryRegist);

        return "forward:/Entry/select";

    }

}
