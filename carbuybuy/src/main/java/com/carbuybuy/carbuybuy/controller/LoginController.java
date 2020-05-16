package com.carbuybuy.carbuybuy.controller;

import com.carbuybuy.carbuybuy.entity.Cars;
import com.carbuybuy.carbuybuy.entity.Users;
import com.carbuybuy.carbuybuy.entity.UsersLoginRecords;
import com.carbuybuy.carbuybuy.redis.service.RedisService;
import com.carbuybuy.carbuybuy.service.CarsService;
import com.carbuybuy.carbuybuy.service.UsersLoginRecordsService;
import com.carbuybuy.carbuybuy.service.UsersService;
import com.carbuybuy.carbuybuy.sms.SmsUtils;
import com.carbuybuy.carbuybuy.utils.DateUtils;
import com.carbuybuy.carbuybuy.utils.IpUtils;
import com.carbuybuy.carbuybuy.utils.MD5Utils;
import com.carbuybuy.carbuybuy.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private CarsService carsService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private UsersLoginRecordsService usersLoginRecordsService;

    //设置验证码过期时间为10分钟
    private static long CODE_EXPIRE_SECONDS = 600;

    //查询所有人员
    @RequestMapping("/login/selectAll")
    public String selectAll() {
        System.out.println("test---");
        List<Users> users = usersService.selectAll();
        for (Users users1 : users) {
            System.out.println(users1);
        }
        return "hello";
    }

    /**
     * 注册
     *
     * @return
     */
    @RequestMapping("/login/register")
    public String register(HttpServletRequest request) {


        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        String idcard = request.getParameter("idcard");
        String phone = request.getParameter("phone");
        //对密码进行md5加密
        String md5Password = MD5Utils.md5(userpassword);

        Users users = new Users();

        users.setId(UUIDUtil.getUUID());
        users.setName(name);
        users.setUsername(username);
        users.setUserpassword(md5Password);
        users.setIdcard(idcard);
        users.setPhone(phone);
        users.setStatus(1);

        usersService.addUser(users);

        return "login";

    }

    /**
     * 账号密码登录
     *
     * @return
     */
    @RequestMapping("/login/userLogin")
    public String userLogin(HttpServletRequest request, Model model) throws IOException {
        String name = request.getParameter("name");
        String userpassword = request.getParameter("userpassword");

        //验证密码输入是否正确
        if (name != null) {
            Users user = usersService.selectByName(name);
            String password = MD5Utils.md5(userpassword);

            if (!password.equals(user.getUserpassword())) {
                return "redirect:/pages/login";
            } else {
                //redis  session 整合  实现sso
                HttpSession session = request.getSession();
                String token = UUID.randomUUID().toString();
                session.setAttribute("userId:" + name, token);
                session.setAttribute("userId", user.getId());
                redisService.set("userId:" + name, token);
                redisService.expire("userId:" + name, CODE_EXPIRE_SECONDS);

                //插入用户登陆记录
                String ip = IpUtils.getIpAddress(request);
                //查看最后登陆表中是否有记录 如果有
                if (usersLoginRecordsService.selectByUserId(user.getId()) != null) {
                    UsersLoginRecords usersLoginRecords = usersLoginRecordsService.selectByUserId(user.getId());
                    //时间相同 修改ip
                    if (DateUtils.getDateForYMD().equals(DateUtils.getDateForYMD2(usersLoginRecords.getLastLoginTime())) == true) {
                        usersLoginRecords.setIp(ip);
                        usersLoginRecordsService.updateIp(usersLoginRecords);
                    }

                    //时间不相同
                    if (!DateUtils.getDateForYMD().equals(DateUtils.getDateForYMD2(usersLoginRecords.getLastLoginTime())) == true) {
                        System.out.println(DateUtils.getDateForYMD().equals(usersLoginRecords.getLastLoginTime()));
                        System.out.println(DateUtils.getDateForYMD());
                        System.out.println(usersLoginRecords.getLastLoginTime());

                        //积分规则   每日登陆 积分加1 修改时间
                        Users userForPoints = usersService.selectByName(name);
                        userForPoints.setPoints(userForPoints.getPoints() + 1);
                        usersService.updatePoints(userForPoints);
                        usersLoginRecords.setIp(ip);
                        usersLoginRecordsService.updateUserLoginRecord(usersLoginRecords);
                    }

                }
                if (usersLoginRecordsService.selectByUserId(user.getId()) == null) {
                    //如果登陆表中没有记录
                    UsersLoginRecords usersLoginRecords = new UsersLoginRecords();
                    usersLoginRecords.setIp(ip);
                    usersLoginRecords.setUserId(user.getId());
                    usersLoginRecordsService.insert(usersLoginRecords);
                    //积分加1
                    Users userForPoints = usersService.selectByName(name);
                    userForPoints.setPoints(1);
                    usersService.updatePoints(userForPoints);
                }

                List<Cars> cars6 = new ArrayList<>();
                //最顶层汽车展示 固定值为6
                cars6 = carsService.selectByTypes(6);

                //热门车
                List<Cars> cars1;
                cars1 = carsService.selectByTypes(1);
                //豪华车
                List<Cars> cars2;
                cars2 = carsService.selectByTypes(2);
                //小型或其他
                List<Cars> cars3;
                cars3 = carsService.selectByTypes(3);
                //商用车
                List<Cars> cars4;
                cars4 = carsService.selectByTypes(4);
                //猜你喜欢
                List<Cars> cars5;
                if (redisService.getSet((String) session.getAttribute("userId")) != null) {
                    Object[] array = redisService.getSet((String) session.getAttribute("userId")).toArray();
                    Random random = new Random();
                    int index = random.nextInt(array.length);
                    cars5 = carsService.selectByCarName((String) array[index]);
                    if (cars5.size() < carsService.selectByTypes(5).size()) {
                        for (int i = 0; i < carsService.selectByTypes(5).size() - cars5.size(); i++) {
                            cars5.add(carsService.selectByTypes(5).get(i));
                        }
                    }
                    if (cars5.size() > 5) {
                        int num = cars5.size() - carsService.selectByTypes(5).size();
                        for (int i = 0; i < num; i++) {
                            cars5.remove(carsService.selectByTypes(5).size() - i);
                        }
                    }

                } else {
                    cars5 = carsService.selectByTypes(5);
                }
                model.addAttribute("cars5", cars5);
                model.addAttribute("cars4", cars4);
                model.addAttribute("cars3", cars3);
                model.addAttribute("cars2", cars2);
                model.addAttribute("cars1", cars1);
                model.addAttribute("cars6", cars6);

                session.setAttribute("userIdForName", name);
                model.addAttribute("user", user);
                return "index";
            }
        } else {
            return "login";
        }

    }

    /**
     * 手机登录
     */
    @RequestMapping("/login/userPhoneLogin")
    public String userPhoneLogin(HttpServletRequest request, Model model) throws IOException {
        String phone = request.getParameter("phone");
        String smsCode = request.getParameter("smsCode");
        String redisSmsCode = redisService.get(phone);

        //sso单点登录设计  redis  + session
        HttpSession session = request.getSession();
        String token = UUID.randomUUID().toString();
        Users user = usersService.selectByPhone(phone);
        session.setAttribute("userId:" + phone, token);
        session.setAttribute("userId", user.getId());
        redisService.set("userId:" + phone, token);
        redisService.expire("userId:" + phone, CODE_EXPIRE_SECONDS);
        Users users = new Users();
        List<Cars> cars6 = new ArrayList<>();
        if (usersService.selectByPhone(phone) != null) {
            users = usersService.selectByPhone(phone);
        }
        if (smsCode.equals(redisSmsCode)) {
            //最顶层汽车展示 固定值为6
            cars6 = carsService.selectByTypes(6);
            //热门车
            List<Cars> cars1;
            cars1 = carsService.selectByTypes(1);
            //豪华车
            List<Cars> cars2;
            cars2 = carsService.selectByTypes(2);
            //小型或其他
            List<Cars> cars3;
            cars3 = carsService.selectByTypes(3);
            //商用车
            List<Cars> cars4;
            cars4 = carsService.selectByTypes(4);
            //猜你喜欢
            List<Cars> cars5;
            cars5 = carsService.selectByTypes(5);

            //插入用户登陆记录
            String ip = IpUtils.getIpAddress(request);
            //查看最后登陆表中是否有记录 如果有
            if (usersLoginRecordsService.selectByUserId(user.getId()) != null) {
                UsersLoginRecords usersLoginRecords = usersLoginRecordsService.selectByUserId(user.getId());
                //时间相同 修改ip
                if (DateUtils.getDateForYMD().equals(DateUtils.getDateForYMD2(usersLoginRecords.getLastLoginTime())) == true) {
                    usersLoginRecords.setIp(ip);
                    usersLoginRecordsService.updateIp(usersLoginRecords);
                }

                //时间不相同
                if (!DateUtils.getDateForYMD().equals(DateUtils.getDateForYMD2(usersLoginRecords.getLastLoginTime())) == true) {
                    System.out.println(DateUtils.getDateForYMD().equals(usersLoginRecords.getLastLoginTime()));
                    System.out.println(DateUtils.getDateForYMD());
                    System.out.println(usersLoginRecords.getLastLoginTime());

                    //积分规则   每日登陆 积分加1 修改时间
                    Users userForPoints = usersService.selectByPhone(phone);
                    userForPoints.setPoints(userForPoints.getPoints() + 1);
                    usersService.updatePoints(userForPoints);
                    usersLoginRecords.setIp(ip);
                    usersLoginRecordsService.updateUserLoginRecord(usersLoginRecords);
                }

            }
            if (usersLoginRecordsService.selectByUserId(user.getId()) == null) {
                //如果登陆表中没有记录
                UsersLoginRecords usersLoginRecords = new UsersLoginRecords();
                usersLoginRecords.setIp(ip);
                usersLoginRecords.setUserId(user.getId());
                usersLoginRecordsService.insert(usersLoginRecords);
                //积分加1
                Users userForPoints = usersService.selectByPhone(phone);
                userForPoints.setPoints(1);
                usersService.updatePoints(userForPoints);
            }
            //采用session 存入 userIdForPhone
            session.setAttribute("userIdForPhone", phone);
            model.addAttribute("user", users);
            model.addAttribute("cars6", cars6);
            model.addAttribute("cars5", cars5);
            model.addAttribute("cars4", cars4);
            model.addAttribute("cars3", cars3);
            model.addAttribute("cars2", cars2);
            model.addAttribute("cars1", cars1);
            return "index";
        } else {
            return "phoneLogin";
        }
    }


    @GetMapping("/login/sendSms")
    @ResponseBody
    public void sendSms(@RequestParam("phone") String phone) {
        String smsCode = SmsUtils.sendSms(phone);
        //存储验证码 设置过期时间
        System.out.println(smsCode);
        redisService.set(phone, smsCode);
        redisService.expire(phone, CODE_EXPIRE_SECONDS);
    }


}
