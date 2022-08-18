package com.atguigu.crud.interceptor;

import com.atguigu.crud.bean.Admin;
import com.atguigu.crud.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o)
            throws Exception {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Admin admin=(Admin)session.getAttribute("admin");
        if (null==user && null==admin) {
            System.out.println("尚未登录，请登录!");
            response.sendRedirect("http://localhost:8080/Test/login.jsp");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//        System.out.println("afterCompletion");
    }
}
