package com.example.demo.controller;

import com.example.demo.domain.Answer;
import com.example.demo.domain.dianweiTtemple;
import com.example.demo.service.AnswerService;
import com.example.demo.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @RequestMapping("/answer/info/insert")
    public String insert(HttpServletRequest request, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        String templateId = request.getParameter("templateId");
        String locationName = request.getParameter("locationName");
        int a1 = Integer.parseInt(request.getParameter("a1"));
        int a2 = Integer.parseInt(request.getParameter("a2"));
        int a3 = Integer.parseInt(request.getParameter("a3"));
        int a4 = Integer.parseInt(request.getParameter("a4"));
        int a5 = Integer.parseInt(request.getParameter("a5"));
        int a6 = Integer.parseInt(request.getParameter("a6"));
        int a7 = Integer.parseInt(request.getParameter("a7"));
        int a8 = Integer.parseInt(request.getParameter("a8"));
        int total = a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8;
        int[] score = {a1, a2, a3, a4, a5, a6, a7, a8};
        Arrays.sort(score);
        int min = score[0];
        Answer answer = new Answer(UUIDUtil.getUUID(), templateId, userId, locationName, a1, a2, a3, a4, a5, a6, a7, a8, total, 0, min);
        this.answerService.insert(answer);
        return "addAnswerSuccess";

    }

    @RequestMapping("/answer/info/update")
    @Transactional
    public String update(HttpServletRequest request, HttpSession session) {
        String answerId = request.getParameter("answerId");

        String locationName = null;
        Integer a1 = null;
        Integer a2 = null;
        Integer a3 = null;
        Integer a4 = null;
        Integer a5 = null;
        Integer a6 = null;
        Integer a7 = null;
        Integer a8 = null;

        int total = 0;

        if (!request.getParameter("locationName").equals("")) {
            locationName = request.getParameter("locationName");
        }
        if (!request.getParameter("a1").equals("")) {
            a1 = Integer.parseInt(request.getParameter("a1"));

        }
        if (!request.getParameter("a2").equals("")) {
            a2 = Integer.parseInt(request.getParameter("a2"));

        }
        if (!request.getParameter("a3").equals("")) {
            a3 = Integer.parseInt(request.getParameter("a3"));

        }
        if (!request.getParameter("a4").equals("")) {
            a4 = Integer.parseInt(request.getParameter("a4"));

        }
        if (!request.getParameter("a5").equals("")) {
            a5 = Integer.parseInt(request.getParameter("a5"));

        }
        if (!request.getParameter("a6").equals("")) {
            a6 = Integer.parseInt(request.getParameter("a6"));

        }
        if (!request.getParameter("a7").equals("")) {
            a7 = Integer.parseInt(request.getParameter("a7"));

        }
        if (!request.getParameter("a8").equals("")) {
            a8 = Integer.parseInt(request.getParameter("a8"));

        }

        Answer answer = new Answer(answerId, null, null, locationName, a1, a2, a3, a4, a5, a6, a7, a8, null, null, 0);
        this.answerService.updateByPrimaryKeySelective(answer);

        Answer answer1 = this.answerService.selectById(answerId);
        total = answer1.getA1() + answer1.getA2() + answer1.getA3() + answer1.getA4() + answer1.getA5() + answer1.getA6() + answer1.getA7() + answer1.getA8();

        int[] score = {answer1.getA1(), answer1.getA2(), answer1.getA3(), answer1.getA4(), answer1.getA5(), answer1.getA6(), answer1.getA7(), answer1.getA8()};
        Arrays.sort(score);
        int min = score[0];

        Answer answer2 = new Answer(answerId, null, null, null, null, null, null, null, null, null, null, null, total, 0, min);

        this.answerService.updateByPrimaryKeySelective(answer2);
        return "updateAnswerSuccess";

    }


}
