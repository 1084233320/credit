package com.example.studentscore.demo.mapper;


import com.example.studentscore.demo.po.Student;
import com.example.studentscore.demo.po.credit.MysqlCredit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {

    public String findPsdById(String id);

    public void insertActivity(String name, String hold, String time, String location, String content, String credit);

    public void changePsd(String id,String password);

    public String findNameById(String id);

    public List<Student> findAllStudent();

    public List<Student> findDissStudent();

    public List<MysqlCredit> findAllNewCredit();
}
