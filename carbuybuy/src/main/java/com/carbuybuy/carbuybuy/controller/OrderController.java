package com.carbuybuy.carbuybuy.controller;

import com.carbuybuy.carbuybuy.entity.*;
import com.carbuybuy.carbuybuy.service.CarsService;
import com.carbuybuy.carbuybuy.service.OrderService;
import com.carbuybuy.carbuybuy.service.UserOrderService;
import com.carbuybuy.carbuybuy.service.UsersService;
import com.carbuybuy.carbuybuy.utils.OrderIdByTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserOrderService userOrderService;

    @Autowired
    private CarsService carsService;

    @Autowired
    private UsersService usersService;

    //跳转到order订单页面 传递汽车id参数
    @RequestMapping("/order/toOrder")
    public String toOrder(String id, Model model,HttpSession session){
        String userId = (String) session.getAttribute("userId");
        if(id==null || userId.equals("")){
            return "404";
        }
        int carId = Integer.parseInt(id);
        model.addAttribute("carId",carId);
        return "order";
    }

    //处理订单  加入用户意向下单汽车表
    @RequestMapping("/order/getOrder")
    public String getOrder(String id, HttpServletResponse response, HttpServletRequest request,HttpSession session) throws IOException {
        String userId = (String) session.getAttribute("userId");
        //防止恶意注入
        if(userId.equals("") || id.equals("")){
            return "404";
        }
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");

        int carId = Integer.parseInt(id);

        Orders order = new Orders();
        order.setName(name);
        order.setAddress(city);
        order.setPhone(phone);
        order.setUserId(userId);
        order.setCarId(carId);



        Cars cars = this.carsService.selectById(carId);
        UserOrder userOrder = new UserOrder();
        userOrder.setCarId(carId);
        userOrder.setUserId(userId);
        userOrder.setUrl(cars.getUrl());
        userOrder.setCarName(cars.getName());

        Users users = this.usersService.selectByUserId(userId);
        //订单数量加1
        users.setOrders(users.getOrders()+1);
        this.usersService.updateOrders(users);

        //插入订单
        this.userOrderService.insert(userOrder);

        order.setOrderId(OrderIdByTimeUtils.getOrderIdByTime());
        order.setCarName(cars.getName());
        order.setPrice(cars.getPrice());
        order.setOrderForUserName(users.getName());

        //设置订单状态  已下单  未完成
        order.setStatus(1);

        this.orderService.insert(order);
        return "orderSuccess";
    }



}
