package com.atguigu.crud.controller;

import com.atguigu.crud.bean.Admin;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.service.AdminService;
import com.atguigu.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String login1(@RequestParam("username") String username , @RequestParam String password , @RequestParam("code") String code , HttpServletRequest request) {
        String authCode = (String) request.getSession().getAttribute("authCode");
        if (authCode != null) {
            if (authCode.equals(code)) {
                String n = null;
                n = userService.queryByNamePwd(username , password);
                if (n != null) {
                    User user = new User();
                    user.setUserName(username);
                    user.setPassword(password);
                    Long userId = userService.getId(user);
                    user.setId(userId);
                    request.getSession().setAttribute("user" , user);
                    return "fore/UserMain";
                } else {
                    return "login";
                }
            } else {
                return "login";
            }
        }
        return "login";
    }

    @RequestMapping("/admin")
    public String login2(@RequestParam("username") String username , @RequestParam String password , @RequestParam("code") String code , HttpServletRequest request) {
        String authCode = (String) request.getSession().getAttribute("authCode");
        if (authCode != null) {
            if (authCode.equals(code)) {
                String n = null;
                n = adminService.queryByNamePwd(username , password);
                if (n != null) {
                    Admin admin = new Admin();
                    admin.setName(username);
                    admin.setPassword(password);
                    request.getSession().setAttribute("admin" , admin);
                    return "AdminMain";
                } else {
                    return "login";
                }
            } else {
                return "login";
            }
        }
        return "login";
    }

    @RequestMapping("/userOut")
    public String userOutLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "login";
    }

    @RequestMapping("/adminOut")
    public String adminOutLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "login";
    }

}
