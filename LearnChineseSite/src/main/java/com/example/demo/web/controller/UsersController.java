package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@RequestMapping("/user")
@Controller
public class UsersController {
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "hello";
    }

}
