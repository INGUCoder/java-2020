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

@Controller
public class AdminController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private DianweiTtempService dianweiTtempService;

    //管理员添加的可以直接通过
    @RequestMapping("/admin/add/user")
    public String addUser(HttpServletRequest request) {
        Users users = new Users();
        users.setId(UUIDUtil.getUUID());
        users.setAccount(request.getParameter("username"));
        users.setPassword(request.getParameter("password"));
        users.setPhone(request.getParameter("phone"));
        users.setUserEmail(request.getParameter("email"));
        users.setUserGroup(request.getParameter("group"));
        users.setUserImit(1);
        users.setName(request.getParameter("realName"));
        System.out.println(users.toString() + "test");
        this.usersService.insert(users);
        return "addUserSuccess";
    }

    @RequestMapping("/admin/alterUserInfo")
    public String alterUserInfo(HttpServletRequest request, HttpSession session,HttpServletResponse response) throws IOException {
        System.out.println("修改管理员信息测试+-------------");
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
        return "alterAdminInfoSuccess";

    }

    //修改密码
    @RequestMapping("/admin/alterPassword")
    public String alterPassword(HttpServletRequest request, HttpSession session,HttpServletResponse response) throws IOException {
        System.out.println("管理员修改密码-------------");
        String password = request.getParameter("password");
        String userId = (String) session.getAttribute("userId");
        Users user = this.usersService.selectById(userId);
        user.setPassword(password);
        int result = this.usersService.updateByPrimaryKeySelective(user);
        return "alterAdminPasswordSuccess";

    }


    //修改密码  检查密码是否正确
    @PostMapping("/admin/checkAlterPassword")
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

    @RequestMapping("/admin/passUser")
    public String index(String id, Model model){
        Users user = this.usersService.selectById(id);
        user.setUserImit(1);
        this.usersService.updateByPrimaryKeySelective(user);
        return "adminPassUserSuccess";
    }

    @RequestMapping("/admin/deleteDianweiTemplate")
    public String deleteDianweiTemplate(String id){
        this.dianweiTtempService.deleteByPrimaryKey(id);
        return "adminDeleteDianWeiTemplateSuccess";
    }

    @RequestMapping("/admin/addDianweiTemplate")
    public String addDianweiTemplate(HttpServletRequest request){

        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String q1 = request.getParameter("q1");
        String q2 = request.getParameter("q2");
        String q3 = request.getParameter("q3");
        String q4 = request.getParameter("q4");
        String q5 = request.getParameter("q5");
        String q6 = request.getParameter("q6");
        String q7 = request.getParameter("q7");
        String q8 = request.getParameter("q8");
        dianweiTtemple dianweiTtemple = new dianweiTtemple(UUIDUtil.getUUID(),name,type,q1,q2,q3,q4,q5,q6,q7,q8);
        this.dianweiTtempService.insertSelective(dianweiTtemple);
        return "adminAddianWeiTemplateSuccess";
    }
    //修改点位模板详细页面
    @RequestMapping("/admin/alterDianweiTemplate")
    public String alterDianweiTemplate(String id,Model model){
        model.addAttribute("id",id);
        return "alterDianWeiTemplateInfo";
    }
    //修改点位模板信息页面
    @RequestMapping("/admin/alterDianweiTemplateInfo")
    public String alterDianweiTemplateInfo(HttpServletRequest request){
        String id = request.getParameter("userId");
        System.out.println(id+"userId");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String q1 = request.getParameter("q1");
        String q2 = request.getParameter("q2");
        String q3 = request.getParameter("q3");
        String q4 = request.getParameter("q4");
        String q5 = request.getParameter("q5");
        String q6 = request.getParameter("q6");
        String q7 = request.getParameter("q7");
        String q8 = request.getParameter("q8");

        dianweiTtemple dianweiTtemple = this.dianweiTtempService.selectById(id);
        if(name!=null && !name.equals("")){
            dianweiTtemple.setName(name);
        }
        if(type!=null && !type.equals("")){
            dianweiTtemple.setType(type);
        }
        if(q1!=null && !q1.equals("")){
            dianweiTtemple.setQ1(q1);
        }
        if(q2!=null && !q2.equals("")){
            dianweiTtemple.setQ2(q2);
        }
        if(q3!=null && !q3.equals("")){
            dianweiTtemple.setQ3(q3);
        }
        if(q4!=null && !q4.equals("")){
            dianweiTtemple.setQ4(q4);
        }
        if(q5!=null && !q5.equals("")){
            dianweiTtemple.setQ5(q5);
        }
        if(q6!=null && !q6.equals("")){
            dianweiTtemple.setQ6(q6);
        }
        if(q7!=null && !q7.equals("")){
            dianweiTtemple.setQ7(q7);
        }
        if(q8!=null && !q8.equals("")){
            dianweiTtemple.setQ8(q8);
        }
        this.dianweiTtempService.updateByPrimaryKeySelective(dianweiTtemple);
        return "alterDianWeiTemplateSuccess";
    }


}
