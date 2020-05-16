package com.carbuybuy.carbuybuy.admin.controller;

import com.carbuybuy.carbuybuy.admin.service.AdminUsersService;
import com.carbuybuy.carbuybuy.entity.Users;
import com.carbuybuy.carbuybuy.redis.service.RedisService;
import com.carbuybuy.carbuybuy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("AdminController")
public class AdminComtroller {

    @Autowired
    private AdminUsersService adminUsersService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private UsersService usersService;

    //会员列表
    @RequestMapping("/admin/pages/list")
    public String adminList(HttpSession session, HttpServletRequest request, Model model) {

        String name = (String) session.getAttribute("name");
        //如果用户名为为空  或者 redis 中没有该数据  则拒绝登陆   跳转到404页面
        if (name == "" || redisService.get("userId:" + name) == null) {
            return "404";
        }
        List<Users> users = this.usersService.selectAll();
        Integer userNums = users.size();
        model.addAttribute("users", users);
        model.addAttribute("userNums", userNums);
        return "member-list";

    }

    //添加会员
    @RequestMapping("/admin/pages/add/user")
    public String addUser() {
        return "member-add";
    }

    //添加产品
    @RequestMapping("/admin/pages/add/product")
    public String addproduct() {
        return "car-product-add";
    }


    //修改密码
    @RequestMapping("/admin/pages/alter/password")
    public String deleteUser(){
        return "member-password";
    }
    //编辑信息
    @RequestMapping("/admin/pages/edit/user")
    public String editUser(){
        return "member-edit";
    }

    //订单管理
    @RequestMapping("/admin/pages/manager/order")
    public String managerOrder(){
        return "orders-list";
    }


}
