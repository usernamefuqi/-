package com.atguigu.crud.controller;

import com.atguigu.crud.util.AuthCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/Image")
public class ImageController {
    @RequestMapping(value = "jpeg",method = RequestMethod.GET)
    public void image(HttpServletRequest request, HttpServletResponse response){
        String authCode = AuthCode.getAuthCode();

        request.getSession().setAttribute("authCode", authCode);  //将验证码保存到session中，便于以后验证

        try {
            //发送图片
            ImageIO.write(AuthCode.getAuthImg(authCode), "JPEG", response.getOutputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
