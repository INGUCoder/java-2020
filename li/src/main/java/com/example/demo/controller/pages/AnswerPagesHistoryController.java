package com.example.demo.controller.pages;

import com.example.demo.controller.dto.AnswerAndTemplateDto;
import com.example.demo.domain.Answer;
import com.example.demo.service.AnswerService;
import com.example.demo.service.UsersService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AnswerPagesHistoryController {

    @Autowired
    private AnswerService answerService;
    @Autowired
    private UsersService usersService;

    @RequestMapping("/answer/history/list")
    public String answerHistoryList(HttpSession session, Model model) {
        String userId = (String) session.getAttribute("userId");
        List<Map<Object, Object>> answers = this.answerService.selectByUserId(userId);
        List list = new ArrayList();
        for (int i = 0; i < answers.size(); i++) {
            AnswerAndTemplateDto answerAndTemplateDto = new AnswerAndTemplateDto();

            answerAndTemplateDto.setLocationName((String) answers.get(i).get("locationName"));
            answerAndTemplateDto.setName((String) answers.get(i).get("name"));
            answerAndTemplateDto.setType((String) answers.get(i).get("type"));
            answerAndTemplateDto.setTotal((Integer) answers.get(i).get("total"));

            list.add(answerAndTemplateDto);
        }
        System.out.println(list.size());
        model.addAttribute("infoList", list);
        return "answerHistory";

    }

    @RequestMapping("/answer/history/alter")
    public String answerHistoryAlter(HttpSession session, Model model) {
        String userId = (String) session.getAttribute("userId");
        List<Map<Object, Object>> answers = this.answerService.selectByUserId(userId);
        List list = new ArrayList();
        for (int i = 0; i < answers.size(); i++) {
            AnswerAndTemplateDto answerAndTemplateDto = new AnswerAndTemplateDto();
            answerAndTemplateDto.setId((String) answers.get(i).get("id"));
            answerAndTemplateDto.setLocationName((String) answers.get(i).get("locationName"));
            answerAndTemplateDto.setName((String) answers.get(i).get("name"));
            answerAndTemplateDto.setType((String) answers.get(i).get("type"));
            answerAndTemplateDto.setTotal((Integer) answers.get(i).get("total"));
            answerAndTemplateDto.setStatus((Integer) answers.get(i).get("status"));
            System.out.println("status"+(Integer) answers.get(i).get("status"));
            list.add(answerAndTemplateDto);
        }
        System.out.println(list.size());
        model.addAttribute("infoList", list);
        return "userAlterDianwei";

    }
    //通过申请

    @RequestMapping("/pass/answer/history/alter")
    public String passAnswerHistoryAlter(String id) {
        Answer answer = answerService.selectById(id);
        System.out.println(answer.toString());
        answer.setStatus(1);
        answerService.updateByPrimaryKeySelective(answer);
        return "userAlterDianweiSuccess";
    }

}
