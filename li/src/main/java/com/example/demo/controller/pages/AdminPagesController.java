package com.example.demo.controller.pages;

import com.example.demo.controller.dto.AnswerAndTemplateDto;
import com.example.demo.domain.Answer;
import com.example.demo.domain.Users;
import com.example.demo.domain.dianweiTtemple;
import com.example.demo.service.AnswerService;
import com.example.demo.service.DianweiTtempService;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class AdminPagesController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private DianweiTtempService dianweiTtempService;
    @Autowired
    private AnswerService answerService;

    @RequestMapping("/admin/pages/addUser")
    public String register() {
        return "adminAddUser";
    }

    //修改用户信息页面
    @RequestMapping("/admin/pages/alterUserInfo")
    public String alterUserInfo() {
        return "alterAdmininfo";
    }

    //修改密码页面
    @RequestMapping("/admin/pages/alterPassword")
    public String alterPassword() {
        return "alterAdminPassword";
    }

    //用户申请记录页面
    @RequestMapping("/admin/pages/shenhe")
    public String shenhe(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        Users users = this.usersService.selectById(userId);
        List<Users> usersList = this.usersService.selectByLimit();

        System.out.println(usersList.size());
        List<Answer> answers = this.answerService.selectByStatus();
        if (answers.size() > 0) {
            for (Answer answer : answers) {
                answer.setTemplateId(users.getName());
            }
        }

        model.addAttribute("answers", answers);
        model.addAttribute("usersList", usersList);


        return "shenhe";
    }

    //添加点位模板
    @RequestMapping("/admin/pages/addTemPlate")
    public String addDainweiTemplate() {
        return "AddDianTemplate";
    }

    //修改点位模板页面
    @RequestMapping("/admin/pages/alterTemPlate")
    public String alterDainweiTemplate(Model model) {
        List<dianweiTtemple> dianweiTtempleList = this.dianweiTtempService.selectAll();
        model.addAttribute("dianweiTtempleList", dianweiTtempleList);
        return "alterDianWeiTemplate";
    }

    //通过修改申请
    @RequestMapping("/admin/pass/alter/dianwei")
    public String passAlterDainwei(String id) {
        Answer answer = this.answerService.selectById(id);
        answer.setStatus(2);
        this.answerService.updateByPrimaryKeySelective(answer);
        return "passUserAlterDianWei";
    }

    //统计功能
    @RequestMapping("/admin/tongji/dianwei")
    public String tongJiDainwei(HttpSession session, Model model) {
        List<Answer> answers = this.answerService.selectAll();
        List list = new ArrayList();
        for (int i = 0; i < answers.size(); i++) {
            AnswerAndTemplateDto answerAndTemplateDto = new AnswerAndTemplateDto();
            dianweiTtemple dianweiTtemple = this.dianweiTtempService.selectById(answers.get(i).getTemplateId());
            Users user = this.usersService.selectById(answers.get(i).getUserId());
            answerAndTemplateDto.setLocationName(answers.get(i).getLocationName());
            answerAndTemplateDto.setName(dianweiTtemple.getName());
            answerAndTemplateDto.setType(dianweiTtemple.getType());
            answerAndTemplateDto.setTotal(answers.get(i).getTotal());
            answerAndTemplateDto.setUserName(user.getName());

            list.add(answerAndTemplateDto);
        }
        System.out.println(list.size());
        model.addAttribute("infoList", list);

        return "adminAnalyInfo";
    }

    //统计功能 点位排名
    @RequestMapping("/admin/tongji/paiming")
    public String tongJiDainweiPaiming(HttpSession session, Model model) {
        List<Answer> answers = this.answerService.selectAllByzPaiming();
        List list = new ArrayList();
        for (int i = 0; i < answers.size(); i++) {
            AnswerAndTemplateDto answerAndTemplateDto = new AnswerAndTemplateDto();
            dianweiTtemple dianweiTtemple = this.dianweiTtempService.selectById(answers.get(i).getTemplateId());
            Users user = this.usersService.selectById(answers.get(i).getUserId());
            answerAndTemplateDto.setLocationName(answers.get(i).getLocationName());
            answerAndTemplateDto.setName(dianweiTtemple.getName());
            answerAndTemplateDto.setType(dianweiTtemple.getType());
            answerAndTemplateDto.setTotal(answers.get(i).getTotal());
            answerAndTemplateDto.setUserName(user.getName());

            list.add(answerAndTemplateDto);
        }
        System.out.println(list.size());
        model.addAttribute("infoList", list);
        return "adminAnalyInfo2";
    }

    //问题突出点位信息
    @RequestMapping("/admin/tongji/tuchu")
    public String tongJiDainweiChishu(HttpSession session, Model model) {
        /**
         * 根据 answer最小值   根据最小值得到 问题信息  然后加上每个问题的所有最小值
         */
        List<Answer> answers = this.answerService.selectAllByzTuchu();
        List list = new ArrayList();
        for (int i = 0; i < answers.size(); i++) {
            AnswerAndTemplateDto answerAndTemplateDto = new AnswerAndTemplateDto();
            dianweiTtemple dianweiTtemple = this.dianweiTtempService.selectById(answers.get(i).getTemplateId());
            Users user = this.usersService.selectById(answers.get(i).getUserId());
            answerAndTemplateDto.setLocationName(answers.get(i).getLocationName());
            answerAndTemplateDto.setName(dianweiTtemple.getName());
            answerAndTemplateDto.setType(dianweiTtemple.getType());
            answerAndTemplateDto.setTotal(answers.get(i).getTotal());
            answerAndTemplateDto.setUserName(user.getName());

            list.add(answerAndTemplateDto);
        }
        System.out.println(list.size());
        model.addAttribute("infoList", list);
        return "adminAnalyInfo3";
    }

    //社区问题最突出
    @RequestMapping("/admin/shequ/tuchu")
    public String shequtuch(HttpSession session, Model model) {
        List<Answer> answers = this.answerService.selectAllByShequ();
        List list = new ArrayList();
        for (int i = 0; i < answers.size(); i++) {
            AnswerAndTemplateDto answerAndTemplateDto = new AnswerAndTemplateDto();
            dianweiTtemple dianweiTtemple = this.dianweiTtempService.selectById(answers.get(i).getTemplateId());
            Users user = this.usersService.selectById(answers.get(i).getUserId());
            answerAndTemplateDto.setLocationName(answers.get(i).getLocationName());
            answerAndTemplateDto.setName(dianweiTtemple.getName());
            answerAndTemplateDto.setType(dianweiTtemple.getType());
            answerAndTemplateDto.setTotal(answers.get(i).getTotal());
            answerAndTemplateDto.setUserName(user.getName());

            list.add(answerAndTemplateDto);
        }
        System.out.println(list.size());
        model.addAttribute("infoList", list);
        return "adminAnalyInfo4";
    }


}
