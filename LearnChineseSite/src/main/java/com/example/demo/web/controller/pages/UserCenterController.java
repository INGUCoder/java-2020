package com.example.demo.web.controller.pages;

import com.example.demo.domain.UserUgc;
import com.example.demo.domain.Users;
import com.example.demo.service.UsersService;
import com.example.demo.service.admin.UGCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/userCenter")
@Controller
public class UserCenterController {
    @Autowired
    private UGCService ugcService;
    @Autowired
    private UsersService usersService;
    @RequestMapping("/index")
    public String index(HttpServletRequest request,Model model){
        List<UserUgc> userUgcList = this.ugcService.selectByStatus();
        model.addAttribute("userUgcList",userUgcList);
        model.addAttribute("numbers",userUgcList.size());
        return "UserCenter";
    }

    @RequestMapping("/neirong")
    public String neirong(String id,Model model){
        UserUgc userUgc = this.ugcService.selectByPrimaryKey(id);
        System.out.println(userUgc.toString());
        Users users = this.usersService.selectByPrimaryKey(userUgc.getUserId());
        model.addAttribute("users",users);
        model.addAttribute("userUgc",userUgc);
        return "UserCenterNeirong";
    }


}
