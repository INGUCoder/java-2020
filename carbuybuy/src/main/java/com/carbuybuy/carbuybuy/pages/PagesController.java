package com.carbuybuy.carbuybuy.pages;

import com.carbuybuy.carbuybuy.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;

/**
 * 页面控制器
 */
@Controller
@RequestMapping("/pages")
public class
PagesController {

    @Autowired
    private RedisService redisService;

    /**
     * 首页
     */
    @RequestMapping("/index")
    public String index(HttpSession session) {
        if (session.getAttribute("userIdForPhone") != null) {
            String userIdForPhone = (String) session.getAttribute("userIdForPhone");
            if (redisService.get("userId:" + userIdForPhone) != null) {
                return "index";
            } else {
                return "phoneLogin";
            }
        }
        if (session.getAttribute("userIdForName") != null) {
            String userIdForName = (String) session.getAttribute("userIdForName");
            if (redisService.get("userId:" + userIdForName) != null) {
                return "index";
            } else {
                return "phoneLogin";
            }
        }
        return "phoneLogin";
    }

    /**
     * 登陆
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 注册
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 手机号登录页面
     */
    @RequestMapping("/phoneLogin")
    public String phoneLogin() {
        return "phoneLogin";
    }

    /**
     * 汽车详情页
     */
    @RequestMapping("/product")
    public String productIndex(){
        return "productIndex";
    }

    /**
     *错误处理界面    无权限 跳转页面 防止恶意注入
     */
    @RequestMapping("/errorPage")
    public String errorPage(){
        return "404";
    }
    //测试订单页面
    @RequestMapping("/order")
    public String order(){
        return "order";
    }

    //会员中心
    @RequestMapping("/myCenter")
    public String myOrder(){
        return "myCenter";
    }

    //修改密码界面
    @RequestMapping("/alterPassPassword")
    public String alterPassword(){
        return "AlterPassword";
    }

    //修改手机号界面
    @RequestMapping("/alterPhone")
    public String alterPhone(){
        return "AlterPhone";
    }

}
