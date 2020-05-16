package com.example.demo.admin;

import com.example.demo.domain.Admin;
import com.example.demo.domain.Course;
import com.example.demo.service.SocreTotalService;
import com.example.demo.service.admin.AdminService;
import com.example.demo.service.admin.CourseService;
import com.example.demo.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RequestMapping("/course")
@Controller
public class CourseController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private CourseService courseService;

    @Autowired
    private SocreTotalService socreTotalService;

    @RequestMapping("/list")
    public String list(HttpSession session, Model model) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }

        List<Course> courseList = this.courseService.selectAll();
        for (int i =0;i<courseList.size();i++){
            courseList.get(i).setScore(this.socreTotalService.selectByAvg(courseList.get(i).getId()));
        }
        model.addAttribute("adminList", courseList);
        Admin admin = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin.getType());
        model.addAttribute("admin", admin);


        return "courselist";
    }


    @RequestMapping("/pages/add")
    public String pagesAdd(HttpSession session, Model model) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }

        return "addCourse";
    }

    @RequestMapping("/add")
    public String add(HttpSession session, Model model, String id, HttpServletRequest request) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }
        String name = request.getParameter("name");
        String teacher = request.getParameter("teacher");
        String category = request.getParameter("category");
        String price = request.getParameter("price");
        String url = request.getParameter("url");
        String introduce = request.getParameter("introduce");
        String introduceEn = request.getParameter("introduceEn");
        Course course = new Course(UUIDUtil.getUUID(), name, teacher, category, Double.parseDouble(price),
                null, url, introduce, introduceEn, new Date());
        this.courseService.insert(course);

        List<Course> adminList = this.courseService.selectAll();
        model.addAttribute("adminList", adminList);
        Admin admin1 = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin1.getType());
        model.addAttribute("admin", admin1);
        return "courselist";

    }

    @RequestMapping("/pages/edit")
    public String pagesEdit(HttpSession session, Model model, String id) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }
        model.addAttribute("id", id);
        return "editCourse";
    }

    @RequestMapping("/edit")
    public String edit(HttpSession session, Model model, String id, HttpServletRequest request) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }

        String name = request.getParameter("name");
        String teacher = request.getParameter("teacher");
        String category = request.getParameter("category");
        String price = request.getParameter("price");
        String url = request.getParameter("url");
        String introduce = request.getParameter("introduce");
        Double newPrice = null;
        if (price != null && !price.equals("")) {
            newPrice = Double.parseDouble(price);
        }

        Course course = new Course(id, name, teacher, category, newPrice,
                null, url, introduce, null, new Date());

        this.courseService.updateByPrimaryKeySelective(course);


        List<Course> adminList = this.courseService.selectAll();
        model.addAttribute("adminList", adminList);
        Admin admin1 = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin1.getType());
        model.addAttribute("admin", admin1);
        return "courselist";

    }


    @RequestMapping("/delete")
    public String delete(HttpSession session, Model model, String id, HttpServletRequest request) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }
        this.courseService.deleteByPrimaryKey(id);
        List<Course> adminList = this.courseService.selectAll();
        model.addAttribute("adminList", adminList);
        Admin admin1 = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin1.getType());
        model.addAttribute("admin", admin1);
        return "courselist";

    }


}
