package com.example.demo.admin;

import com.example.demo.domain.Admin;
import com.example.demo.domain.Course;
import com.example.demo.domain.UserUgc;
import com.example.demo.service.admin.AdminService;
import com.example.demo.service.admin.UGCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/ugc")
@Controller
public class UGCController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UGCService ugcService;

    @RequestMapping("/list")
    public String list(HttpSession session, Model model) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }
        List<UserUgc> courseList = this.ugcService.selectAll();
        model.addAttribute("adminList", courseList);
        Admin admin = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin.getType());
        model.addAttribute("admin", admin);

        return "ugclist";
    }

    @RequestMapping("/delete")
    public String delete(HttpSession session, Model model, String id, HttpServletRequest request) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }
        this.ugcService.deleteByPrimaryKey(id);
        List<UserUgc> adminList = this.ugcService.selectAll();
        model.addAttribute("adminList", adminList);
        Admin admin1 = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin1.getType());
        model.addAttribute("admin", admin1);
        return "ugclist";
    }


    @RequestMapping("/pass")
    public String pass(HttpSession session, Model model, String id, HttpServletRequest request) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }
        UserUgc userUgc = new UserUgc();
        userUgc.setId(id);
        userUgc.setUserLimit(2);
        this.ugcService.updateByPrimaryKeySelective(userUgc);
        List<UserUgc> adminList = this.ugcService.selectAll();
        model.addAttribute("adminList", adminList);
        Admin admin1 = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin1.getType());
        model.addAttribute("admin", admin1);
        return "ugclist";
    }


    @RequestMapping("/reful")
    public String reful(HttpSession session, Model model, String id, HttpServletRequest request) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }
        UserUgc userUgc = new UserUgc();
        userUgc.setId(id);
        userUgc.setUserLimit(3);
        this.ugcService.updateByPrimaryKeySelective(userUgc);
        List<UserUgc> adminList = this.ugcService.selectAll();
        model.addAttribute("adminList", adminList);
        Admin admin1 = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin1.getType());
        model.addAttribute("admin", admin1);
        return "ugclist";
    }


}
