package com.example.demo.web.controller.pages.users;

import com.example.demo.service.UsersService;
import com.example.demo.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/login")
@Controller
public class LoginController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/checkPassWord")
    @ResponseBody
    public void CheckPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String flag = "1";
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        //如果没有匹配成功
        if (!usersService.selectByUserName(userName).getPassWord().equals(MD5Util.md5(passWord))) {
            flag = "0";
        }
        response.getWriter().write(flag);
    }


}
