package com.atguigu.crud.controller;

import com.atguigu.crud.bean.LeaveOffice;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.constant.Constant;
import com.atguigu.crud.service.EntryRegistService;
import com.atguigu.crud.service.LeaveOfficeService;
import com.atguigu.crud.service.UserRegistService;
import com.atguigu.crud.service.UserService;
import com.atguigu.crud.util.DateUtil;
import com.atguigu.crud.vo.LeaveOfficeVo;
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
@RequestMapping("/Leave")
public class LeaveController {

    @Autowired
    private LeaveOfficeService leaveOfficeService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRegistService userRegistService;

    //查询所有离职人员显示至后台
    @RequestMapping("/select")
    public String selectAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn , Model model) {
        PageHelper.startPage(pn , Constant.PAGE_NUMBER);
        List<LeaveOfficeVo> leaveVoList = leaveOfficeService.selectAll();
        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(leaveVoList , Constant.PAGE_NUMBER);
        model.addAttribute("pageInfo" , page);
        model.addAttribute("leaveVoList" , leaveVoList);
        return "leaveList";
    }

    //按职员姓名查询所有离职记录显示至后台
    @RequestMapping("/selectByStaffName")
    public String selectByStaffName(@RequestParam("staffName") String staffName ,
                                    @RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model) {
        if (staffName == null || "".equals(staffName))
            return "forward:/Leave/select";

        PageHelper.startPage(pn , Constant.PAGE_NUMBER);
        List<LeaveOfficeVo> leaveVoList = leaveOfficeService.selectByStaffName(staffName);

        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(leaveVoList , Constant.PAGE_NUMBER);
        model.addAttribute("pageInfo" , page);
        model.addAttribute("leaveVoList" , leaveVoList);
        return "leaveList";
    }

    //添加离职信息至数据库
    @RequestMapping("/add")
    public String addLeave(@RequestParam("staffId") Long staffId , HttpServletRequest request) {
        userRegistService.deleteById(staffId);
        User user = (User) request.getSession().getAttribute("user");

        userService.deleteById(user.getId());

        LeaveOffice leaveOffice = new LeaveOffice();
        leaveOffice.setStaffId(staffId);
        leaveOffice.setLeaveTime(DateUtil.string3Date());

        leaveOfficeService.insert(leaveOffice);
        request.getSession().invalidate();
        return "login";
    }

}
