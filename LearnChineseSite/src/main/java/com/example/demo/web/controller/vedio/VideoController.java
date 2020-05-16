package com.example.demo.web.controller.vedio;

import com.example.demo.domain.*;
import com.example.demo.service.SocreTotalService;
import com.example.demo.service.UsersService;
import com.example.demo.service.admin.CourseService;
import com.example.demo.service.admin.UserCommentService;
import com.example.demo.service.admin.UserOrderService;
import com.example.demo.service.admin.VedioService;
import com.example.demo.utils.UUIDUtil;
import org.apache.catalina.Session;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/user/vedio")
@Controller
public class VideoController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserOrderService userOrderService;
    @Autowired
    private VedioService vedioService;
    @Autowired
    private UserCommentService userCommentService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private SocreTotalService socreTotalService;



    //视频课程页面
    @RequestMapping("/indexPage")
    public String indexPage(HttpSession session, HttpServletRequest request,Model model) {
        String userId = (String) session.getAttribute("userId");
        List<Course> courseList = new ArrayList<>();
        List<vedio> vedioList = new ArrayList<>();
        if(userId!=null&&!userId.equals("")){
            List<UserOrder> userOrderList = this.userOrderService.selectByUserId(userId);
            if(userOrderList.size()>0){
                for (int i=0;i<userOrderList.size();i++){
                    courseList.add(this.courseService.selectByPrimaryKey(userOrderList.get(i).getCourseId()));

                }
                model.addAttribute("courseList",courseList);
                return "vedioHome";
            }
            else {
                return "404";
            }
        }

        return "404";
    }

    //单个视频课程页面
    @RequestMapping("/singlePage")
    public String singlePage(String id,Model model,HttpSession session) {
        List<vedio> videoList = this.vedioService.selectByCourseId(id);
        //验证用户有没评分
        int panduan = 1;
        List<SocreTotal> socreTotalList = this.socreTotalService.selectByCourseId((String) session.getAttribute("userId"),id);
        if(socreTotalList==null || socreTotalList.size()==0){
            panduan = 0;
        }
        model.addAttribute("panduan",panduan);
        model.addAttribute("vedio",videoList.get(0));
        List<UserComment> commentList = this.userCommentService.selectAllByStatus();
        model.addAttribute("commentList",commentList);
        model.addAttribute("courseId",id);
        return "single-video";
    }

    @RequestMapping("/addComment")
    public String addComment(Model model,HttpServletRequest request,HttpSession session) {
        Users user = this.usersService.selectByPrimaryKey((String) session.getAttribute("userId"));
        UserComment userComment = new UserComment();
        userComment.setId(UUIDUtil.getUUID());
        userComment.setUserId((String) session.getAttribute("userId"));
        userComment.setUserName(user.getName());
        userComment.setNeirong(request.getParameter("neirong"));
        userComment.setCommentStatus(1);
        userComment.setPushTime(new Date());
        this.userCommentService.insert(userComment);
        String courseId = request.getParameter("courseId");
        List<vedio> videoList = this.vedioService.selectByCourseId(courseId);
        model.addAttribute("vedio",videoList.get(0));
        List<UserComment> commentList = this.userCommentService.selectAllByStatus();
        String score = request.getParameter("score");
        System.out.println(request.getParameter("score")+"testetstettstet");
        if(score!=null&& !score.equals("")){
            SocreTotal socreTotal = new SocreTotal();
            socreTotal.setId(UUIDUtil.getUUID());
            socreTotal.setCourseId(courseId);
            socreTotal.setUserId((String) session.getAttribute("userId"));
            socreTotal.setScore(Float.parseFloat(score));
            this.socreTotalService.insert(socreTotal);
        }
        model.addAttribute("commentList",commentList);
        return "single-video";
    }


}
