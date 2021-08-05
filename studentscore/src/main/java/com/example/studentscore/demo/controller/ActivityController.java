package com.example.studentscore.demo.controller;

import com.example.studentscore.demo.po.Activity;
import com.example.studentscore.demo.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ActivityController {
    @Autowired
    ActivityMapper activityMapper;

    @RequestMapping("/findAllActivity")
    public List<Activity> findAllActivity(){ return activityMapper.findAllActicity();}


}
