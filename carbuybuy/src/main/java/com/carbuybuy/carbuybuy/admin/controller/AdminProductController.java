package com.carbuybuy.carbuybuy.admin.controller;

import com.carbuybuy.carbuybuy.entity.Cars;
import com.carbuybuy.carbuybuy.redis.service.RedisService;
import com.carbuybuy.carbuybuy.service.CarsService;
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

@Controller("AdminProductController")
public class AdminProductController {
    @Autowired
    private RedisService redisService;

    @Autowired
    private CarsService carsService;

    //产品列表
    @RequestMapping("/admin/pages/product/list")
    public String adminProductList(HttpServletRequest request, HttpSession session, Model model){
        String name = (String) session.getAttribute("name");
        //防止sql注入
        if (name != "" || redisService.get("userId:" + name) != null) {

            List<Cars> cars = this.carsService.selectAll();
            model.addAttribute("cars",cars);
            model.addAttribute("carsNums",cars.size());


        }


        return "product-list";
    }

    @PostMapping("/admin/pages/product/add")
    @ResponseBody
    public void register(HttpServletRequest request,HttpSession session) throws IOException {
        String name = (String) session.getAttribute("name");
        //防止sql注入
        if (name != "" || redisService.get("userId:" + name) != null) {

            String carName = request.getParameter("carName");
            System.out.println(carName);
            Integer types = Integer.valueOf(request.getParameter("types"));
            String introduce = request.getParameter("introduce");
            String price = request.getParameter("price");
            String fromAddress = request.getParameter("fromAddress");
            String level = request.getParameter("level");
            String costType= request.getParameter("carName");
            String engine = request.getParameter("engine");
            String changeSpeed = request.getParameter("changeSpeed");
            String speed = request.getParameter("speed");
            String url = request.getParameter("url");

            Cars cars = new Cars();
            cars.setName(carName);
            cars.setTypes(types);
            cars.setIntroduce(introduce);
            cars.setPrice(price);
            cars.setFromAddress(fromAddress);
            cars.setLevel(level);
            cars.setCostType(costType);
            cars.setEngine(engine);
            cars.setChangeSpeed(changeSpeed);
            cars.setSpeed(speed);
            cars.setUrl(url);

            this.carsService.insertCar(cars);


        }


    }

    @PostMapping("/admin/delete/cars")
    @ResponseBody
    public void deletOrder(HttpServletRequest request,HttpSession session) throws IOException {
        String name = (String) session.getAttribute("name");
        //防止sql注入
        if (name != "" || redisService.get("userId:" + name) != null) {
            Integer id = Integer.valueOf(request.getParameter("id"));
            System.out.println(id);
            this.carsService.deleteCar(id);
        }

    }





}
