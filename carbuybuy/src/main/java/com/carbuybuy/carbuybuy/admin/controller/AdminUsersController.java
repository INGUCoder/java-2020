package com.carbuybuy.carbuybuy.admin.controller;

import com.carbuybuy.carbuybuy.entity.Users;
import com.carbuybuy.carbuybuy.service.UsersService;
import com.carbuybuy.carbuybuy.utils.MD5Utils;
import com.carbuybuy.carbuybuy.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller("AdminUsersController")
public class AdminUsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 停用账号
     *
     * @param request
     */
    @PostMapping("/admin/user/stopUser")
    @ResponseBody
    public void stopUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!request.getParameter("id").equals("")) {
            String id = request.getParameter("id");
            Users users = this.usersService.selectByUserId(id);
            users.setStatus(0);
            System.out.println(users);
            this.usersService.updateStatus(users);
        }
        //假数据  避免发送request页面继续返回其他的参数
        response.getWriter().write("1");
}

    /**
     * 启用账号
     *
     * @param request
     */
    @RequestMapping("/admin/user/startUser")
    @ResponseBody
    public void startUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        if (!request.getParameter("id").equals("")) {
            String id = request.getParameter("id");
            Users users = this.usersService.selectByUserId(id);
            users.setStatus(1);
            System.out.println(users);
            this.usersService.updateStatus(users);
        }
        //假数据  避免发送request页面继续返回其他的参数
        response.getWriter().write("1");

    }


    /**
     * 增加用户
     *
     * @return
     */
    @PostMapping("/admin/user/register")
    @ResponseBody
    public void register(HttpServletRequest request,HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        String idcard = request.getParameter("idcard");
        String phone = request.getParameter("phone");
        //对密码进行md5加密
        String md5Password = MD5Utils.md5(userpassword);

        Users users = new Users();

        users.setId(UUIDUtil.getUUID());
        users.setName(name);
        users.setUsername(username);
        users.setUserpassword(md5Password);
        users.setIdcard(idcard);
        users.setPhone(phone);
        users.setStatus(1);
        usersService.addUser(users);
        //注册成功 向前台发送 1
        response.getWriter().write(1);


    }

    /**
     * @return
     */
    @PostMapping("/admin/user/delete")
    @ResponseBody
    public void deleteUser(HttpServletRequest request,HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        Users users = this.usersService.selectByUserId(id);
        this.usersService.deleteUser(users);
        //删除成功 向前台发送 1
        response.getWriter().write(1);


    }






}
