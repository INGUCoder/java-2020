package com.example.demo.web.controller.pages;

import com.example.demo.domain.Users;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("/pages")
@Controller
public class PagesController {
    @Autowired
    private UsersService usersService;
    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model){
        List<Users> usersList = this.usersService.selectAll();
        model.addAttribute("usersList",usersList);
        return "index";
    }
    /**
     * 注册
     */
    @RequestMapping("/signup")
    public String signUp(){
        return "signup";
    }


}
