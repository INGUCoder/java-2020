package com.carbuybuy.carbuybuy.admin.controller;

import com.carbuybuy.carbuybuy.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginOutController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/admin/pages/loginOut")
    public String LoginOut(HttpSession session, HttpServletRequest request){
        String name = (String) session.getAttribute("name");

        //清空redis记录
        this.redisService.remove("userId:"+name);
        //让所有session失效
        request.getSession().invalidate();

        return "redirect:/admin/pages/login";

    }


}
