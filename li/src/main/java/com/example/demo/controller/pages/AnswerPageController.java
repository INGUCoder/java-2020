package com.example.demo.controller.pages;

import com.example.demo.domain.Answer;
import com.example.demo.domain.dianweiTtemple;
import com.example.demo.service.AnswerService;
import com.example.demo.service.DianweiTtempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnswerPageController {
    @Autowired
    private DianweiTtempService dianweiTtempService;
    @Autowired
    private AnswerService answerService;

    @RequestMapping("/answer/index")
    public String answerIndex(String id, Model model){
        dianweiTtemple dianweiTtemple = this.dianweiTtempService.selectById(id);
        model.addAttribute("dianweiTtemple",dianweiTtemple);
        return "addAnswer";
    }

    @RequestMapping("/answer/user/alter")
    public String answerAlter(String id, Model model){
        Answer answer = this.answerService.selectById(id);
        dianweiTtemple dianweiTtemple = this.dianweiTtempService.selectById(answer.getTemplateId());
        model.addAttribute("answer",answer);
        model.addAttribute("dianweiTtemple",dianweiTtemple);
        return "userAlterAnswer";
    }








}
