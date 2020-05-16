package com.carbuybuy.carbuybuy.controller;

import com.carbuybuy.carbuybuy.entity.Cars;
import com.carbuybuy.carbuybuy.entity.UserCollect;
import com.carbuybuy.carbuybuy.entity.UserOrder;
import com.carbuybuy.carbuybuy.entity.Users;
import com.carbuybuy.carbuybuy.service.CarsService;
import com.carbuybuy.carbuybuy.service.UserCollectService;
import com.carbuybuy.carbuybuy.service.UserOrderService;
import com.carbuybuy.carbuybuy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户中心
 */
@Controller
public class MyCenterController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UserCollectService userCollectService;

    @Autowired
    private UserOrderService userOrderService;

    @Autowired
    private CarsService carsService;

    //会员中心
    @RequestMapping("/myCenter/index")
    public String index(HttpSession session, Model model){
        String userId = (String) session.getAttribute("userId");
        if(userId.equals("")){
            return "404";
        }

        Users user = usersService.selectByUserId(userId);
        model.addAttribute("user",user);

        List<UserCollect> userCollects = this.userCollectService.selectByUserId(userId);
        model.addAttribute("userCollects",userCollects);

        List<UserOrder> userOrders = this.userOrderService.selectByUserId(userId);
        model.addAttribute("userOrders",userOrders);



        return "myCenter";
    }



}
