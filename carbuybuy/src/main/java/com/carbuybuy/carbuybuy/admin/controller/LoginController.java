package com.carbuybuy.carbuybuy.admin.controller;

import com.carbuybuy.carbuybuy.admin.service.AdminUsersService;
import com.carbuybuy.carbuybuy.redis.service.RedisService;
import com.carbuybuy.carbuybuy.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@Controller("/AdminLoginController")
public class LoginController {

    @Autowired
    private AdminUsersService adminUsersService;

    @Autowired
    private RedisService redisService;

    //设置验证码过期时间为20分钟
    private static long CODE_EXPIRE_SECONDS = 1200;

    //管理员登陆
    @RequestMapping("/admin/login")
    public String login(HttpServletRequest request, HttpSession session) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        //如果用户强行登陆   就直接到404页面    前台账号密码输入都有提醒
        if(this.adminUsersService.selectByrName(name)==null||(!this.adminUsersService.selectByrName(name).getPassword().equals(MD5Utils.md5(password)))){
            return "404";
        }
        //整合sso   就不用session 过期时间为20分钟
        String token = UUID.randomUUID().toString();
        redisService.set("userId:"+name,token);
        redisService.expire("userId:"+name,CODE_EXPIRE_SECONDS);
        session.setAttribute("name",name);

        return "adminIndex";
    }

    //检查账号是否存在  存在返回0

    @PostMapping("/admin/checkName")
    @ResponseBody
    public void checkName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String flag = "1";
        if (name.equals("")) {
            response.getWriter().write(flag);
        } else if (adminUsersService.selectByrName(name) != null) {
            flag = "0";
        }
        response.getWriter().write(flag);
    }


    //检查密码是否正确  正确返回0

    @PostMapping("/admin/checkPassword")
    @ResponseBody
    public void checkPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String flag = "1";

        if (name.equals("") || password.equals("")) {
            response.getWriter().write(flag);
        } else if (MD5Utils.md5(password).equals(this.adminUsersService.selectByrName(name).getPassword())) {
            flag = "0";
        }
        response.getWriter().write(flag);
    }


}
