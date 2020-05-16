package com.example.demo.admin;

import com.example.demo.domain.Admin;
import com.example.demo.domain.UserComment;
import com.example.demo.domain.UserUgc;
import com.example.demo.service.admin.AdminService;
import com.example.demo.service.admin.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/comment")
@Controller
public class UserCommentController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserCommentService userCommentService;

    @RequestMapping("/list")
    public String list(HttpSession session, Model model) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }
        List<UserComment> courseList = this.userCommentService.selectAll();
        model.addAttribute("adminList", courseList);
        Admin admin = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin.getType());
        model.addAttribute("admin", admin);

        return "commentclist";
    }

    @RequestMapping("/delete")
    public String delete(HttpSession session, Model model, String id, HttpServletRequest request) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }
        this.userCommentService.deleteByPrimaryKey(id);
        List<UserComment> adminList = this.userCommentService.selectAll();
        model.addAttribute("adminList", adminList);
        Admin admin1 = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin1.getType());
        model.addAttribute("admin", admin1);
        return "commentclist";
    }


    @RequestMapping("/pass")
    public String pass(HttpSession session, Model model, String id, HttpServletRequest request) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }
        UserComment userComment = new UserComment();
        userComment.setId(id);
        userComment.setCommentStatus(2);
        this.userCommentService.updateByPrimaryKeySelective(userComment);
        List<UserComment> adminList = this.userCommentService.selectAll();
        model.addAttribute("adminList", adminList);
        Admin admin1 = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin1.getType());
        model.addAttribute("admin", admin1);
        return "commentclist";
    }


    @RequestMapping("/reful")
    public String reful(HttpSession session, Model model, String id, HttpServletRequest request) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }
        UserComment userComment = new UserComment();
        userComment.setId(id);
        userComment.setCommentStatus(3);
        this.userCommentService.updateByPrimaryKeySelective(userComment);
        List<UserComment> adminList = this.userCommentService.selectAll();
        model.addAttribute("adminList", adminList);
        Admin admin1 = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin1.getType());
        model.addAttribute("admin", admin1);
        return "commentclist";
    }

}
