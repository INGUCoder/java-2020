package com.example.demo.admin;

import com.example.demo.domain.Admin;
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

@RequestMapping("/admin/manager")
@Controller
public class AdminManagerController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/list")
    public String list(HttpSession session, Model model){
        if(session.getAttribute("adminId")==null||session.getAttribute("adminId").equals("")){
            return "admin404";
        }
        List<Admin> adminList = this.adminService.selectAll();
        model.addAttribute("adminList",adminList);
        Admin admin = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type",admin.getType());
        model.addAttribute("admin",admin);
        return "adminlist";
    }

    @RequestMapping("/delete")
    public String delete(HttpSession session, Model model,String id){
        if(session.getAttribute("adminId")==null||session.getAttribute("adminId").equals("")){
            return "admin404";
        }
        this.adminService.deleteByPrimaryKey(id);

        List<Admin> adminList = this.adminService.selectAll();
        model.addAttribute("adminList",adminList);
        Admin admin = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type",admin.getType());
        model.addAttribute("admin",admin);
        return "adminlist";
    }

    @RequestMapping("/pages/add")
    public String pagesAdd(HttpSession session, Model model,String id){
        if(session.getAttribute("adminId")==null||session.getAttribute("adminId").equals("")){
            return "admin404";
        }
        return "addAdmin";
    }

    @RequestMapping("/add")
    public String add(HttpSession session, Model model, String id, HttpServletRequest request){
        if(session.getAttribute("adminId")==null||session.getAttribute("adminId").equals("")){
            return "admin404";
        }
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        Integer type = Integer.valueOf(request.getParameter("type"));
        Admin admin = new Admin(UUIDUtil.getUUID(),userName,MD5Util.md5(password),name,type);
        this.adminService.insert(admin);

        List<Admin> adminList = this.adminService.selectAll();
        model.addAttribute("adminList",adminList);
        Admin admin1 = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type",admin1.getType());
        model.addAttribute("admin",admin1);
        return "adminlist";

    }

    @RequestMapping("/pages/edit")
    public String userEdit(String id, Model model){
        model.addAttribute("id",id);
        return "editAdmin";
    }

    @RequestMapping("/edit")
    public String edit(Model model, HttpServletRequest request,HttpSession session,String id) {
        if(session.getAttribute("adminId")==null||session.getAttribute("adminId").equals("")){
            return "admin404";
        }

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String newPass = null;
        Integer newType=null;

        if(type!=null&&!type.equals("")){
            newType = Integer.valueOf(type);
        }
        if(password!=null&&!password.equals("")){
            newPass = MD5Util.md5(password);
        }
        Admin admin1 = new Admin(id,userName,newPass,name,newType);
        try {
            this.adminService.updateByPrimaryKeySelective(admin1);
        } catch (Exception e) {
            return "admin404";
        }
        if(session.getAttribute("adminId")==null ||session.getAttribute("adminId").equals("")){
            return "admin404";
        }
        List<Admin> adminList = this.adminService.selectAll();
        model.addAttribute("adminList",adminList);
        Admin admin = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type",admin.getType());
        model.addAttribute("admin",admin);

        return "adminlist";
    }



}
