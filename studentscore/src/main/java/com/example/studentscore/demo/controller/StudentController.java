package com.example.studentscore.demo.controller;


import com.alibaba.fastjson.JSON;
import com.example.studentscore.demo.po.Credit;
import com.example.studentscore.demo.po.Student;
import com.example.studentscore.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    StudentMapper studentMapper;


    @RequestMapping("/pass")
    public String pass(String id,String is,double credit){
        if(is.equals("1")){
            Student student = studentMapper.findStudentbyId(id);
            double all = student.getCredit() + credit;
            studentMapper.updateCredit(id,credit);
            return "success";
        }
        return "error";
    }

    @RequestMapping("/insertstudent")
    @ResponseBody
    public String save(@RequestParam("stu") String str) {
        Student stu = JSON.parseObject(str, Student.class);
        studentMapper.save(stu);
        return "Save success";
    }

//  根据传过来的用户名查找密码
    @RequestMapping("/checking")
    public boolean check(String id,String password) {



        String psd = studentMapper.findPsdById(id);

        if(psd.equals(password)){
            return true;
        }
        return false;

    }
    
    @RequestMapping("/demo")
    public String demo(String id){
        return id;
    }


    //根据传递过来的id号，找到该同学的全部信息
    @RequestMapping("/findStudentById")
    public Student findStudentById(String id){
        System.out.println("信息传递过来了"+id);
        return studentMapper.findStudentbyId(id);
    }



    //修改密码
    @RequestMapping("/change")
    public boolean changeStudent(String id,String password){
        studentMapper.changeStudent(id,password);
        if (studentMapper.findStudentbyId(id).getPassword().equals(password)){
            return true;
        }
        return false;
    }






    @RequestMapping("/insertStudent")
    public boolean insertStudent(String name,String password){
        studentMapper.insertStudent(name,password);
        return true;
    }









    @RequestMapping("/findAllStudent")
    public List<Student> findAllStudent(){
        return studentMapper.findAllStudent();
    }



    @RequestMapping("/changshi")
    public Student changshi(String name,String i){
        Student student = new Student();
        student.setName(name);
        student.setId(i);
        return student;
    }







}
