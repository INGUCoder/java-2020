package com.example.demo.web.controller.pages.course;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/course")
@Controller
public class CoursePageController {


    //课程首页
    @RequestMapping("/index")
    public String couresIndex(){
        return "courseIndex";
    }


}
