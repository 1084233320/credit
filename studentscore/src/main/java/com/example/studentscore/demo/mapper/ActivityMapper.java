package com.example.studentscore.demo.mapper;

import com.example.studentscore.demo.po.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface ActivityMapper {

    public List<Activity> findAllActicity();

    public Activity findActivityByName(String name);

    public Activity findActivityById(int id);
}
