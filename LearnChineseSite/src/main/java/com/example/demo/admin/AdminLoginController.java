package com.example.demo.admin;

import com.example.demo.domain.Admin;
import com.example.demo.domain.Users;
import com.example.demo.service.UsersService;
import com.example.demo.service.admin.AdminService;
import com.example.demo.utils.MD5Util;
import com.example.demo.utils.MySocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminLoginController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UsersService usersService;

    @RequestMapping("/pages/login")
    public String login(){
        return "adminlogin";
    }
    @RequestMapping("/login")
    public String login(HttpSession session, HttpServletRequest request, Model model){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        MySocket mySocket = new MySocket();

        if(this.adminService.selectByUserName(userName)!=null && this.adminService.selectByUserName(userName).getPassword().equals(MD5Util.md5(password))){
            Admin admin = this.adminService.selectByUserName(userName);
            session.setAttribute("adminId",admin.getId());
            model.addAttribute("type",admin.getType());
            model.addAttribute("admin",admin);
            model.addAttribute("online_num",mySocket.getOnline_num());
            return "adminindex";
        }
        return "admin404";
    }

    @RequestMapping("/member/list")
    public String memberList(Model model,HttpSession session){
        if(session.getAttribute("adminId")==null||session.getAttribute("adminId").equals("")){
            return "admin404";
        }
        Admin admin = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type",admin.getType());
        List<Users> usersList = this.usersService.selectAll();
        model.addAttribute("usersList",usersList);
        model.addAttribute("admin",admin);
        return "member";
    }

    @RequestMapping("/pages/edit")
    public String addUser(){
        return "addUser";
    }


    @RequestMapping("/admin/edit")
    public String edit(Model model, HttpServletRequest request,HttpSession session,String id) {
        if(session.getAttribute("adminId")==null||session.getAttribute("adminId").equals("")){
            return "admin404";
        }
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String chineseName = request.getParameter("chineseName");
        String type= request.getParameter("learnType");
        Integer learnType = null;
        String newPass = null;
        System.out.println(id+"test");
        if(type!=null&&!type.equals("")){
            learnType = Integer.valueOf(type);
        }
        if(passWord!=null&&!passWord.equals("")){
            newPass = MD5Util.md5(passWord);
        }
        Users users = new Users(id, userName, newPass, name, city, phone, email, chineseName, learnType);
        try {
            this.usersService.updateByPrimaryKeySelective(users);
        } catch (Exception e) {
            return "admin404";
        }
        if(session.getAttribute("adminId")==null ||session.getAttribute("adminId").equals("")){
            return "admin404";
        }
        List<Users> usersList = this.usersService.selectAll();
        model.addAttribute("usersList",usersList);
        Admin admin = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type",admin.getType());
        model.addAttribute("admin",admin);

        return "member";
    }


}
