package com.jinming.ma.controller;

import com.jinming.ma.dao.ResumeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String resume(String userName, String passWord, Model model) {
        model.addAttribute("list", resumeDao.findAll());
        return "jsp/resume";
    }

    @RequestMapping("/toLogin")
    public String login(String userName, String passWord) {
        return "jsp/login";
    }
}
