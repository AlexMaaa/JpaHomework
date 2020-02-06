package com.jinming.ma.controller;

import com.jinming.ma.dao.ResumeDao;
import com.jinming.ma.pojo.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author majm
 * @create 2020-02-06 18:09
 * @desc
 **/
@Controller
public class CrudController {
    @Autowired
    private ResumeDao resumeDao;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Resume> findAll() {
        return resumeDao.findAll();
    }

    @RequestMapping("/save")
    @ResponseBody
    public Resume save(@RequestBody Resume resume) {
        return resumeDao.save(resume);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Long id) {
        resumeDao.deleteById(id);
        return "ok";
    }
}
