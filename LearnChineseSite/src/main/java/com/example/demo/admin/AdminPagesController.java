package com.example.demo.admin;

import com.example.demo.domain.Admin;
import com.example.demo.domain.Users;
import com.example.demo.service.UsersService;
import com.example.demo.service.admin.AdminService;
import com.example.demo.utils.MD5Util;
import com.example.demo.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminPagesController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/user/edit")
    public String userEdit(String id, Model model){
        model.addAttribute("id",id);
        return "editUser";
    }

    /**
     * 注册
     */
    @RequestMapping("/add")
    public String add(Model model, HttpServletRequest request,HttpSession session) {
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
        Integer learnType = Integer.valueOf(request.getParameter("learnType"));
        Users users = new Users(UUIDUtil.getUUID(), userName, MD5Util.md5(passWord), name, city, phone, email, chineseName, learnType);
        try {
            this.usersService.insert(users);
        } catch (Exception e) {
            return "admin404";
        }
        List<Users> usersList = this.usersService.selectAll();
        Admin admin = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("usersList",usersList);
        model.addAttribute("admin",admin);
        return "member";
    }

    /**
     * 删除
     * @param id
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/delete")
    public String delete(String id, HttpSession session,Model model){

        System.out.println(id);
        if(session.getAttribute("adminId")==null||session.getAttribute("adminId").equals("")){
            return "admin404";
        }
        this.usersService.deleteByPrimaryKey(id);
        List<Users> usersList = this.usersService.selectAll();
        model.addAttribute("usersList",usersList);
        Admin admin = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("admin",admin);
        return "member";
    }



}
