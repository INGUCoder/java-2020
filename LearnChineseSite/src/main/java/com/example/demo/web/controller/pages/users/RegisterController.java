package com.example.demo.web.controller.pages.users;

import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/register")
@Controller
public class RegisterController {
    @Autowired
    private UsersService usersService;

    //检查账号  是否已经存在
    @PostMapping("/checkUserName")
    @ResponseBody
    public void CheckName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String flag = "1";
        String userName = request.getParameter("userName");
        //如果没有查询到该账户
        if (usersService.selectByUserName(userName) == null) {
            flag = "0";
        }
        response.getWriter().write(flag);
    }

}
