package com.carbuybuy.carbuybuy.admin.controller;

import com.carbuybuy.carbuybuy.entity.Orders;
import com.carbuybuy.carbuybuy.redis.service.RedisService;
import com.carbuybuy.carbuybuy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller("AdminOrderManagerController")
public class AdminOrderManagerController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RedisService redisService;

    //订单列表
    @RequestMapping("/admin/pages/order/list")
    public String adminOrderList(HttpServletRequest request, Model model, HttpSession session){
        String name = (String) session.getAttribute("name");
        //防止sql注入
        if (name == "" || redisService.get("userId:" + name) == null) {
            return "404";
        }
        List<Orders> orders = this.orderService.selectAll();
        model.addAttribute("orderNums",orders.size());
        model.addAttribute("orders",orders);

        return "orders-list";

    }

    @PostMapping("/admin/pages/confirm/order")
    @ResponseBody
    public void confirmOrder(HttpServletRequest request,HttpSession session) throws IOException {
        String name = (String) session.getAttribute("name");
        //防止sql注入
        if (name != "" || redisService.get("userId:" + name) != null) {
            String orderId = request.getParameter("orderId");
            Orders orders = this.orderService.selectByOrderId(orderId);
            orders.setStatus(2);
            this.orderService.updateOrderStatus(orders);
        }


    }

    @PostMapping("/admin/pages/delete/order")
    @ResponseBody
    public void deletOrder(HttpServletRequest request,HttpSession session) throws IOException {
        String name = (String) session.getAttribute("name");
        //防止sql注入
        if (name != "" || redisService.get("userId:" + name) != null) {
            String orderId = request.getParameter("orderId");
            Orders orders = this.orderService.selectByOrderId(orderId);
            this.orderService.deleteOrder(orders);
        }


    }







}
