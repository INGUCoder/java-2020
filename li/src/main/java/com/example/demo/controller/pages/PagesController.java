package com.example.demo.controller.pages;

import com.example.demo.domain.Users;
import com.example.demo.domain.dianweiTtemple;
import com.example.demo.service.DianweiTtempService;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class PagesController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private DianweiTtempService dianweiTtempService;

    @RequestMapping("/pages/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/pages/index")
    public String index(){
        return "index";
    }
    //user首页
    @RequestMapping("/pages/userindex")
    public String userIndex(HttpSession session,Model model){
        String userId = (String) session.getAttribute("userId");
        Users user = this.usersService.selectByAccount(userId);
        List<dianweiTtemple> dianweiTtempleList = this.dianweiTtempService.selectAll();
        model.addAttribute("dianweiTtempleList", dianweiTtempleList);
        model.addAttribute("user", user);
        return "userIndex";
    }

    //admin首页
    @RequestMapping("/pages/adminindex")
    public String adminIndex(HttpSession session,Model model){
        String userId = (String) session.getAttribute("userId");
        Users user = this.usersService.selectById(userId);
        List<dianweiTtemple> dianweiTtempleList = this.dianweiTtempService.selectAll();
        model.addAttribute("dianweiTtempleList", dianweiTtempleList);
        model.addAttribute("user", user);
        return "adminIndex";
    }

    //修改密码页面
    @RequestMapping("/pages/alterPassword")
    public String alterPassword(){
        return "alterUserPassword";
    }

    //修改用户信息页面
    @RequestMapping("/pages/alterUserInfo")
    public String alterUserInfo(){
        return "alterUserinfo1";
    }


    //user 个人中心
    @RequestMapping("/pages/userMine")
    public String userMine(HttpSession session,Model model){
        System.out.println("安卓端测试1+-------------");
        String userId = (String) session.getAttribute("userId");
        Users user = usersService.selectById(userId);
        model.addAttribute("user",user);
        return "userMine";
    }

    //admin 个人中心
    @RequestMapping("/pages/adminMine")
    public String adminMine(HttpSession session, Model model){
        String userId = (String) session.getAttribute("userId");
        Users user = usersService.selectById(userId);
        model.addAttribute("user",user);
        return "adminMine";
    }


}
