package com.example.studentscore.demo.web;

import com.example.studentscore.demo.mapper.ActivityMapper;
import com.example.studentscore.demo.mapper.AdminMapper;
import com.example.studentscore.demo.mapper.StudentMapper;
import com.example.studentscore.demo.po.AdminStudent;
import com.example.studentscore.demo.po.Student;
import com.example.studentscore.demo.po.credit.MysqlCredit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class WebController {

    AdminStudent adminStudent = new AdminStudent();

    @Autowired
    AdminMapper adminMapper;
    StudentMapper studentMapper;


    @GetMapping("/index")
    public String index(Model model){
        String id = adminStudent.getId();
        String name = adminMapper.findNameById(id);
        adminStudent.setName(name);
        model.addAttribute("name",name);
        return "index";}

    @RequestMapping("/login")
    public String login(String id,String password,Model model){
        adminStudent.setId(id);
        System.out.println("username" + id);
        System.out.println(password);
        String psd = adminMapper.findPsdById(id);
        System.out.println(psd);
        if(psd == null)   {System.out.println("醉了");}
        else if(psd.equals(password)){
            return "redirect:/index";
        }else{
            String info = "账号或密码错误，请重新输入";
            model.addAttribute("info",info);
        }
        return "login";
    }

    @RequestMapping("/showAll")
    public String showALL(Model model){
        List<Student> studentList = adminMapper.findAllStudent();
        model.addAttribute("studentList",studentList);
        return "showAll";
    }

    @RequestMapping("/diss")
    public String diss(Model model){
        List<Student> studentList = adminMapper.findDissStudent();
        model.addAttribute("studentList",studentList);
        return "diss";
    }
//
//
//
//    @RequestMapping("/pass")
//    public void wocwoc(){
//        System.out.println(11111);
//    }




    @RequestMapping("/woc")
    @ResponseBody
    public List<MysqlCredit> woc(){
        List<MysqlCredit> mysqlCreditList = adminMapper.findAllNewCredit();
        return mysqlCreditList;
    }


    @RequestMapping("/credit")
    public String credit(Model model){
        List<MysqlCredit> mysqlCreditList = adminMapper.findAllNewCredit();
        model.addAttribute(mysqlCreditList);
        return "credit";
    }
    @RequestMapping("/addActivity")
    public String addActivity(String name,String hold,String time,String location,String content,String credit){

        if(name != null){
            adminMapper.insertActivity(name,hold,time,location,content,credit);

        }
        return "addActivity";

    }

    @RequestMapping("/mine")
    public String mine(Model model){
        model.addAttribute("name",adminStudent.getName());
        return "mine";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "redirect:login";
    }

    @RequestMapping("/changePsd")
    public String changePsd(String password){
        System.out.println("密码是" + password);
        System.out.println("id是" + adminStudent.getId());

        if(password != null){
            adminMapper.changePsd(adminStudent.getId(),password);
            return "redirect:login";
        }
        return "changePsd";
    }


//    @RequestMapping("/chanegCredit")
//    public String chanegCredit(String id){
//
//        if(password != null){
//            adminMapper.chanegCredit(adminStudent.getId(),password);
//            return "redirect:login";
//        }
//        return "changePsd";
//    }
}
