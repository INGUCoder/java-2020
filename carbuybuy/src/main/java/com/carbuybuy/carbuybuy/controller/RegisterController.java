package com.carbuybuy.carbuybuy.controller;

import com.carbuybuy.carbuybuy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RegisterController {

    @Autowired
    private UsersService usersService;

    /**
     * 检测  注册时 用户名 是否重复
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @PostMapping("/register/checkName")
    @ResponseBody
    public void CheckName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String flag = "1";
        String name = request.getParameter("name");
        //如果没有查询到该账户
        if (usersService.selectByName(name) == null) {
            flag = "0";
        }
        response.getWriter().write(flag);
    }

    /**
     * 检测  注册时 手机号是否重复
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @PostMapping("/register/checkPhone")
    @ResponseBody
    public void CheckPhone(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String flag = "1";
        String phone = request.getParameter("phone");
        //如果没有查询到该账户
        if (usersService.selectByPhone(phone) == null) {
            flag = "0";
        }
        response.getWriter().write(flag);
    }


}
