package com.carbuybuy.carbuybuy.controller;

import com.carbuybuy.carbuybuy.entity.Cars;
import com.carbuybuy.carbuybuy.redis.service.RedisService;
import com.carbuybuy.carbuybuy.service.CarsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

/**
 * 汽车详情页面控制器
 */
@Controller
@RequestMapping("/cars")
public class CarIntroduceController {
    @Autowired
    private CarsService carsService;
    @Autowired
    private RedisService redisService;

    @RequestMapping("/index")
    public String index(String id, Model model, HttpSession session){
        if(id==null||session.getAttribute("userId")==null){
                return "search404";
        }
        int carId = Integer.parseInt(id);
        Cars car = carsService.selectById(carId);
        model.addAttribute("car",car);
        return "productIndex";
    }

    @RequestMapping("/search")
    public String search(Model model, HttpSession session, HttpServletRequest request){
        String name = request.getParameter("name");
        if(name==null||session.getAttribute("userId")==null){
            return "search404";
        }
        List<Cars> cars = carsService.selectByCarName(name);
        if(cars.size()==0){
            return "search404";
        }
        redisService.addSet((String) session.getAttribute("userId"),name);
        redisService.expire("userId",600*6*24*5);
        Random random = new Random();
        int index = random.nextInt(cars.size());
        model.addAttribute("car",cars.get(index));
        return "productIndex";
    }

}
