package com.carbuybuy.carbuybuy.admin.pages;


import com.carbuybuy.carbuybuy.admin.entity.AdminUsers;
import com.carbuybuy.carbuybuy.admin.service.AdminUsersService;
import com.carbuybuy.carbuybuy.entity.Cars;
import com.carbuybuy.carbuybuy.entity.Users;
import com.carbuybuy.carbuybuy.redis.service.RedisService;
import com.carbuybuy.carbuybuy.service.CarsService;
import com.carbuybuy.carbuybuy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 管理员页面控制器
 */
@Controller("AdminPagesController")
public class PagesController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private AdminUsersService adminUsersService;

    @Autowired
    private CarsService carsService;

    @Autowired
    private UsersService usersService;

    //管理员登陆页面
    @RequestMapping("/admin/pages/login")
    public String adminLogin(){
        return "adminLogin";
    }

    //index页面
    @RequestMapping("/admin/pages/index")
    public String adminIndex(){
        return "adminIndex";
    }

    //欢迎页面
    @RequestMapping("/admin/pages/welcome")
    public String adminWelcome(HttpSession session, Model model){
        String name = (String) session.getAttribute("name");
        //如果用户名为为空  或者 redis 中没有该数据  则拒绝登陆   跳转到404页面
        if(name==""||redisService.get("userId:"+name)==null){
            return "404";
        }
        AdminUsers adminUsers = this.adminUsersService.selectByrName(name);
        model.addAttribute("username",adminUsers.getUserName());

        //统计有多少产品
        List<Cars> cars = this.carsService.selectAll();
        model.addAttribute("productsNums",cars.size());

        //统计有多少用户
        List<Users> users = this.usersService.selectAll();
        model.addAttribute("usersNums",users.size());

        //统计有多少管理员
        List<AdminUsers> adminUsersList = this.adminUsersService.selectAll();
        model.addAttribute("adminsNums",adminUsersList.size());

        return "adminWelcome";
    }





}
