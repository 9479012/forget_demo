package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.User;
import com.qf.service.IEmailService;
import com.qf.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * @author 王铭
 * @Date 2019/6/29
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Reference
    private IUserService userService;

    @Reference
    private IEmailService emailService;

    @RequestMapping("/insert")
    public String insert(User user,Integer suiji,HttpServletRequest request){
        HttpSession session = request.getSession();
        if (suiji.equals(session.getAttribute("suiji"))){
        userService.insertUser(user);
        return "index";
        }
        return "regist";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(User user){
        List<User> users = userService.queryList();
        for (User user1 : users) {
            if (user.getUsername().equals(user1.getUsername()) && user.getPassword().equals(user1.getPassword())){
                return "ok";
            }
        }
        return "fail";
    }

    @RequestMapping("/send")
    public void toSend(User user, HttpServletRequest request){
        Random random = new Random();
        Integer suiji =random.nextInt(10000-100 + 1) + 100 ;
        HttpSession session = request.getSession();
        session.setAttribute("suiji",suiji);
        emailService.yanZheng(user.getEmail(),suiji);
    }

    @RequestMapping("/found")
    public void  found(){
    }
}
