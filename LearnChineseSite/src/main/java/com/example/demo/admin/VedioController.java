package com.example.demo.admin;

import com.example.demo.domain.Admin;
import com.example.demo.domain.Course;
import com.example.demo.domain.vedio;
import com.example.demo.service.admin.AdminService;
import com.example.demo.service.admin.VedioService;
import com.example.demo.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RequestMapping("/vedio")
@Controller
public class VedioController {
    @Autowired
    private VedioService vedioService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/list")
    public String list(HttpSession session, Model model) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }
        List<vedio> vedioList = this.vedioService.selectByAll();
        model.addAttribute("adminList", vedioList);
        Admin admin = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin.getType());
        model.addAttribute("admin", admin);
        return "vediolist";
    }


    @RequestMapping("/pages/add")
    public String pagesAdd(HttpSession session, Model model) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }

        return "addVedio";
    }

    @RequestMapping("/add")
    public String add(HttpSession session, Model model, String id, HttpServletRequest request) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }
        String name = request.getParameter("name");
        String pictureUrl = request.getParameter("pictureUrl");
        String playUrl = request.getParameter("playUrl");
        String courseId = request.getParameter("courseId");
        String description = request.getParameter("description");

        vedio vedio = new vedio(UUIDUtil.getUUID(),name,pictureUrl,playUrl,courseId,new Date(),description);
        this.vedioService.insert(vedio);

        List<vedio> vedioList = this.vedioService.selectByAll();
        model.addAttribute("adminList", vedioList);
        Admin admin1 = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin1.getType());
        model.addAttribute("admin", admin1);
        return "vediolist";

    }

    @RequestMapping("/pages/edit")
    public String pagesEdit(HttpSession session, Model model, String id) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }
        model.addAttribute("id", id);
        return "editvedio";
    }

    @RequestMapping("/edit")
    public String edit(HttpSession session, Model model, String id, HttpServletRequest request) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }

        String name = request.getParameter("name");
        String pictureUrl = request.getParameter("pictureUrl");
        String playUrl = request.getParameter("playUrl");
        String courseId = request.getParameter("courseId");
        String description = request.getParameter("description");

        vedio vedio = new vedio(id,name,pictureUrl,playUrl,courseId,null,description);

        this.vedioService.updateByPrimaryKeySelective(vedio);

        List<vedio> vedioList = this.vedioService.selectByAll();
        model.addAttribute("adminList", vedioList);
        Admin admin1 = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin1.getType());
        model.addAttribute("admin", admin1);
        return "vediolist";

    }


    @RequestMapping("/delete")
    public String delete(HttpSession session, Model model, String id, HttpServletRequest request) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }
        this.vedioService.deleteByPrimaryKey(id);
        List<vedio> vedioList = this.vedioService.selectByAll();
        model.addAttribute("adminList", vedioList);
        Admin admin1 = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin1.getType());
        model.addAttribute("admin", admin1);
        return "vediolist";

    }


}
