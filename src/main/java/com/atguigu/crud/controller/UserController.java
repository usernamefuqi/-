package com.atguigu.crud.controller;

import com.atguigu.crud.bean.User;
import com.atguigu.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/selectById")
    public ModelAndView selectById(HttpServletRequest request) {
        User users = (User) request.getSession().getAttribute("user");
        User user = userService.selectById(users.getId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user" , user);
        modelAndView.setViewName("fore/userUpdate");
        return modelAndView;
    }

    @RequestMapping("/updateUser")
    public ModelAndView updateUser(User user , HttpServletRequest request) {
        int count = userService.updateById(user);
        if (count != 0) {
            request.getSession().invalidate();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
