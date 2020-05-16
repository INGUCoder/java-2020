package com.example.demo.controller;

import com.example.demo.domain.Users;
import com.example.demo.domain.dianweiTtemple;
import com.example.demo.service.DianweiTtempService;
import com.example.demo.service.UsersService;
import com.example.demo.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private DianweiTtempService dianweiTtempService;
    @RequestMapping("/user/register")
    public String Register(HttpServletRequest request) {
        Users users = new Users();
        users.setId(UUIDUtil.getUUID());
        users.setAccount(request.getParameter("username"));
        users.setPassword(request.getParameter("password"));
        users.setPhone(request.getParameter("phone"));
        users.setUserEmail(request.getParameter("email"));
        users.setUserGroup(request.getParameter("group"));
        users.setUserImit(0);
        users.setName(request.getParameter("realName"));
        System.out.println(users.toString() + "test");
        this.usersService.insert(users);
        return "index";
    }

    @RequestMapping("/user/login")
    public String login(HttpServletRequest request, HttpSession session, Model model) {
        String account = request.getParameter("account");
        Users user = this.usersService.selectByAccount(account);
        if(user==null){
            return "index";
        }
        //设置session  方便识别
        session.setAttribute("userId", user.getId());
        if (user.getUserImit() == 1) {
            List<dianweiTtemple> dianweiTtempleList = this.dianweiTtempService.selectAll();
            model.addAttribute("dianweiTtempleList", dianweiTtempleList);
            model.addAttribute("user", user);
            return "userIndex";
        }
        if (user.getUserImit() == 0) {

            return "index";
        }
        //limit = 2 管理员权限
        if (user.getUserImit()==2){
            List<dianweiTtemple> dianweiTtempleList = this.dianweiTtempService.selectAll();
            model.addAttribute("dianweiTtempleList", dianweiTtempleList);
            model.addAttribute("user", user);
            return "adminIndex";
        }
        return "index";


    }

    @RequestMapping("/user/alterPassword")
    public String alterPassword(HttpServletRequest request, HttpSession session,HttpServletResponse response) throws IOException {
        System.out.println("安卓端测试2+-------------");
        String password = request.getParameter("password");
        String userId = (String) session.getAttribute("userId");
        Users user = this.usersService.selectById(userId);
        user.setPassword(password);
        int result = this.usersService.updateByPrimaryKeySelective(user);
        return "alterPasswordSuccess";

    }


    @RequestMapping("/user/alterUserInfo")
    public String alterUserInfo(HttpServletRequest request, HttpSession session,HttpServletResponse response) throws IOException {
        System.out.println("修改用户信息测试+-------------");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String group = request.getParameter("group");
        String name = request.getParameter("name");
        String userId = (String) session.getAttribute("userId");
        Users user = this.usersService.selectById(userId);
        if(phone!=null && !phone.equals("")){
            user.setPhone(phone);
        }
        if(email!=null && !email.equals("")){
            user.setUserEmail(email);
        }
        if(group!=null && !group.equals("")){
            user.setUserGroup(group);
        }
        if(name!=null && !name.equals("")){
            user.setName(name);
        }
        int result = this.usersService.updateByPrimaryKeySelective(user);
        return "alterUserInfoSuccess";

    }



    //检查账号是否存在  存在返回0

    @PostMapping("/users/checkAccount")
    @ResponseBody
    public void checkName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        String flag = "1";
        if (account.equals("")) {
            response.getWriter().write(flag);
        } else if (usersService.selectByAccount(account) != null) {
            if (usersService.selectByAccount(account).getUserImit() == 0) {
                flag = "2";
            } else {
                flag = "0";
            }

        }
        response.getWriter().write(flag);
    }


    //检查密码是否正确  正确返回0

    @PostMapping("/users/checkPassword")
    @ResponseBody
    public void checkPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("name");
        String password = request.getParameter("password");
        String flag = "1";
        System.out.println(account+"account");
        if (account==null || account.equals("") || password.equals("")) {
            response.getWriter().write(flag);
        } else if (password.equals(this.usersService.selectByAccount(account).getPassword())) {
            flag = "0";
        }
        System.out.println(flag+"flag");
        response.getWriter().write(flag);
    }

    //修改密码  检查密码是否正确
    @PostMapping("/users/checkAlterPassword")
    @ResponseBody
    public void checkAlterPassword(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String userId = (String) session.getAttribute("userId");
        String password = request.getParameter("password");
        System.out.println(password);
        String flag = "1";
        System.out.println(userId);

        if (password==null || password.equals("")) {
            response.getWriter().write(flag);
        }
        System.out.println(this.usersService.selectById(userId).getPassword()+"test");
        if (password.equals(this.usersService.selectById(userId).getPassword())) {
            System.out.println("test");
            flag = "0";
        }

        System.out.println(flag);
        response.getWriter().write(flag);
    }





}
