package com.example.demo.web.controller.AliPay;

import com.example.demo.domain.Course;
import com.example.demo.domain.UserOrder;
import com.example.demo.service.UsersService;
import com.example.demo.service.admin.CourseService;
import com.example.demo.service.admin.UserOrderService;
import com.example.demo.service.aliPay.AlipayService;
import com.example.demo.utils.RandomNumber;
import com.example.demo.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    AlipayService alipayService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserOrderService userOrderService;

    @RequestMapping("/pay")
    public void payMent(HttpServletResponse response, HttpServletRequest request, String id, HttpSession session) {
        try {
            System.out.println(UUIDUtil.getUUID());
            String orderId = UUIDUtil.getUUID();
            String userId = (String) session.getAttribute("userId");

            Course course = this.courseService.selectByPrimaryKey(id);
            UserOrder userOrder = new UserOrder();

            userOrder.setId(orderId);
            userOrder.setUserId(userId);
            userOrder.setCourseId(id);
            userOrder.setProduceTime(new Date());
            this.userOrderService.insert(userOrder);
            String orderName = course.getName();
            double price = course.getPrice();
            alipayService.aliPay(response,request,orderId, orderName, price);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
