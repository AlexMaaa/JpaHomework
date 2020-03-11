package com.jinming.ma.controller;

import com.jinming.ma.dao.ResumeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author majm
 * @create 2020-02-06 15:12
 * @desc
 **/
@Controller
public class LoginController {
    @Autowired
    private ResumeDao resumeDao;

    @RequestMapping("/resume")
    public String resume(Model model, String username, String password, HttpSession session) {
        model.addAttribute("list", resumeDao.findAll());
        return "jsp/resume";
    }

    @RequestMapping("/toLogin")
    public String login() {
        return "jsp/login";
    }
    @RequestMapping("/dealLogin")
    public String dealLogin(Model model, String userName, String passWord, HttpSession session){
        if("admin".equals(userName) && "admin".equals(passWord)) {
            System.out.println("合法用户");
            session.setAttribute("userName",userName + System.currentTimeMillis());
            return "redirect:/resume";
        }else{
            // 非法用户返回登录页面
            System.out.println("非法，跳转");
            return "jsp/login";
        }
    }

}
