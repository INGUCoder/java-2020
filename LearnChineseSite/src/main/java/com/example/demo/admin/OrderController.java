package com.example.demo.admin;

import com.example.demo.domain.Admin;
import com.example.demo.domain.UserOrder;
import com.example.demo.service.admin.AdminService;
import com.example.demo.service.admin.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/order")
@Controller
public class OrderController {
    @Autowired
    private UserOrderService userOrderService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/list")
    public String list(HttpSession session, Model model) {
        if (session.getAttribute("adminId") == null || session.getAttribute("adminId").equals("")) {
            return "admin404";
        }
        List<UserOrder> orderList = this.userOrderService.selectAll();
        model.addAttribute("adminList", orderList);
        Admin admin = this.adminService.selectById((String) session.getAttribute("adminId"));
        model.addAttribute("type", admin.getType());
        model.addAttribute("admin", admin);
        return "orderlist";
    }

}
