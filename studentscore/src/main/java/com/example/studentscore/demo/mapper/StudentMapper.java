package com.example.studentscore.demo.mapper;


import com.example.studentscore.demo.po.Student;
import com.example.studentscore.demo.po.AdminStudent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper

@Repository
public interface StudentMapper {


    public Student findStudentbyId(String id);

    public Student findStudentbyName(String name);

    public List<Student> findAll();



    public List<Student> findAllStudent();



    public String checking(String id);

    public Student getinfo(String name,String password);


    public List<AdminStudent> findAll_delete();


    public void insertStudent(String name,String password);

    public void changeStudent(String id,String password);



    void save(Student stu);

    public String findPsdById(String id);

    public void updateCredit(String id, double credit);
}
