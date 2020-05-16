package com.carbuybuy.carbuybuy.controller;

import com.carbuybuy.carbuybuy.entity.Users;
import com.carbuybuy.carbuybuy.redis.service.RedisService;
import com.carbuybuy.carbuybuy.service.UsersService;
import com.carbuybuy.carbuybuy.utils.MD5Utils;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//用户中心操作
@Controller
public class UserController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RedisService redisService;

    //用户修改密码 提示 原先密码是否错误
    @PostMapping("/user/checkPassword")
    @ResponseBody
    public void CheckPassword(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String userId = (String) session.getAttribute("userId");
        System.out.println(userId);
        //防止非法注入
        if (userId.equals("")) {
            String flag = "1";
            response.getWriter().write(flag);
        } else {
            String flag = "1";
            String oldPassword = request.getParameter("oldPassword");
            Users user = this.usersService.selectByUserId(userId);
            System.out.println(user.getUserpassword());
            //如果密码匹配 返回0
            if (MD5Utils.md5(oldPassword).equals(user.getUserpassword())) {
                flag = "0";
            }

            //不匹配返回1
            response.getWriter().write(flag);

        }

    }

    //用户修改密码逻辑
    @PostMapping("/user/AlterPassword")
    @ResponseBody
    public void AlterPassword(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String userId = (String) session.getAttribute("userId");
        String newPassword = request.getParameter("newPassword");
        String oldPassword = request.getParameter("oldPassword");

        System.out.println(newPassword);
        System.out.println("test---");
        //防止非法注入
        if (userId.equals("")) {
            String flag = "1";
            response.getWriter().write(flag);
        } else {
            String flag = "1";

            Users user = this.usersService.selectByUserId(userId);
            //如果密码修改成功 返回0
            if (MD5Utils.md5(oldPassword).equals(user.getUserpassword()) ) {
                user.setUserpassword(MD5Utils.md5(newPassword));
                user.setId(userId);
                this.usersService.updatePassword(user);
                flag = "0";
            }

            //失败返回1
            response.getWriter().write(flag);

        }

    }

    //用户修改手机号码逻辑
    @PostMapping("/user/AlterPhone")
    @ResponseBody
    public void AlterPhone(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String userId = (String) session.getAttribute("userId");
        String phone = request.getParameter("phone");
        String smsCode = request.getParameter("smsCode");

        //防止非法注入
        if (userId.equals("")) {
            String flag = "1";
            response.getWriter().write(flag);
        } else {
            String flag = "1";

            Users user = this.usersService.selectByUserId(userId);
            //如果验证码匹配  返回0
            if (this.redisService.get(phone).equals(smsCode)) {

                user.setId(userId);
                user.setPhone(phone);
                this.usersService.updatePhone(user);
                flag = "0";
            }

            //不匹配返回1
            response.getWriter().write(flag);

        }

    }



}
