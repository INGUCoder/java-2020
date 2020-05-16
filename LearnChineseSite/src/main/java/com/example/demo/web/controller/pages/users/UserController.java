package com.example.demo.web.controller.pages.users;

import com.example.demo.domain.Course;
import com.example.demo.domain.UserUgc;
import com.example.demo.domain.Users;
import com.example.demo.service.SocreTotalService;
import com.example.demo.service.UsersService;
import com.example.demo.service.admin.CourseService;
import com.example.demo.service.admin.UGCService;
import com.example.demo.utils.MD5Util;
import com.example.demo.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private CourseService courseService;

    @Autowired
    private UGCService ugcService;

    @Autowired
    private SocreTotalService socreTotalService;

    @RequestMapping("/pages/alter")
    public String pagesAlter(){
        return "alterUserInfo";
    }

    /**
     * 注册
     */
    @RequestMapping("/register")
    public String reGister(Model model, HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String chineseName = request.getParameter("chineseName");
        Integer learnType = Integer.valueOf(request.getParameter("learnType"));
        Users users = new Users(UUIDUtil.getUUID(), userName, MD5Util.md5(passWord), name, city, phone, email, chineseName, learnType);
        try {
            this.usersService.insert(users);
        } catch (Exception e) {
            return "404";
        }
        return "index";
    }


    /**
     * 登陆
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpSession session, Model model, HttpServletResponse response) throws UnsupportedEncodingException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(this.usersService.selectByUserName(username)==null || !this.usersService.selectByUserName(username).getPassWord().equals(MD5Util.md5(password)))
        {
            return "404";
        }

        Users users = this.usersService.selectByUserName(username);
        session.setAttribute("userId",users.getId());
        List<Course> courseList = this.courseService.selectAll();
        for (int i =0;i<courseList.size();i++){
            courseList.get(i).setScore(this.socreTotalService.selectByAvg(courseList.get(i).getId()));
        }
        model.addAttribute("courseList",courseList);
        return "courseIndex";
    }
    @RequestMapping("/alter")
    public String alter(HttpServletRequest request,HttpSession session){
        Users users = new Users();
        String userId = (String) session.getAttribute("userId");
        String passWord = request.getParameter("passWord");
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String chineseName = request.getParameter("chineseName");
        String learnType= request.getParameter("learnType");

        Integer newType = null;
        users.setPassWord(passWord);
        users.setName(name);
        users.setCity(city);
        users.setPhone(phone);
        users.setEmail(email);
        users.setChineseName(chineseName);
        if(learnType!=null&&!learnType.equals("")){
            newType = Integer.parseInt(learnType);
            users.setLearnType(newType);
        }
        users.setId(userId);
        this.usersService.updateByPrimaryKeySelective(users);
        return "index";
    }
    @RequestMapping("/pages/push")
    public String pagesPush(){

        return "addwenzhang";
    }

    @RequestMapping("/push")
    public String Push(HttpServletRequest request,HttpSession session,Model model){
        String title = request.getParameter("title");
        String neirong = request.getParameter("neirong");
        UserUgc userUgc = new UserUgc();

        userUgc.setId(UUIDUtil.getUUID());
        userUgc.setUserId((String) session.getAttribute("userId"));
        userUgc.setTitle(title);
        userUgc.setNeirong(neirong);
        userUgc.setPushTime(new Date());
        userUgc.setUserLimit(1);

        this.ugcService.insert(userUgc);
        Users users = this.usersService.selectByPrimaryKey((String) session.getAttribute("userId"));
        session.setAttribute("userId",users.getId());
        List<Course> courseList = this.courseService.selectAll();
        model.addAttribute("courseList",courseList);
        return "courseIndex";
    }

    @RequestMapping("/seach")
    public String seach(HttpServletRequest request,HttpSession session,Model model){
        String part = request.getParameter("part");
        System.out.println(part);
        Users users = this.usersService.selectByPrimaryKey((String) session.getAttribute("userId"));
        session.setAttribute("userId",users.getId());
        List<Course> courseList = this.courseService.selectBySearch(part);;
        model.addAttribute("courseList",courseList);
        return "courseIndex";
    }



}
