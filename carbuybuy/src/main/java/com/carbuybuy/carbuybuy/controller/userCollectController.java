package com.carbuybuy.carbuybuy.controller;

import com.carbuybuy.carbuybuy.entity.Cars;
import com.carbuybuy.carbuybuy.entity.UserCollect;
import com.carbuybuy.carbuybuy.entity.Users;
import com.carbuybuy.carbuybuy.service.CarsService;
import com.carbuybuy.carbuybuy.service.UserCollectService;
import com.carbuybuy.carbuybuy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class userCollectController {

    @Autowired
    private UserCollectService userCollectService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private CarsService carsService;

    //加入收藏
    @PostMapping("/userCollect/add")
    @ResponseBody
    public void collectAdd(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String flag = "1";
        String userId = (String) session.getAttribute("userId");
        String id = request.getParameter("id");
        System.out.println(id);
        if (this.userCollectService.selectByIdAndUserId(userId,Integer.parseInt(id))==null && !userId.equals("")) {
            UserCollect userCollect = new UserCollect();
            userCollect.setUserId(userId);
            Cars cars = this.carsService.selectById(Integer.parseInt(id));
            userCollect.setCarId(Integer.parseInt(id));
            userCollect.setUrl(cars.getUrl());
            userCollect.setCarName(cars.getName());
            this.userCollectService.insert(userCollect);

            //增加订单数量
            Users users =this.usersService.selectByUserId(userId);
            users.setCollects(users.getCollects()+1);
            this.usersService.updateCollects(users);
            flag = "0";
        }
        response.getWriter().write(flag);
    }

    //移除收藏

    //


}
