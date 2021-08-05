package com.example.studentscore.demo.controller;

import com.example.studentscore.demo.po.credit.MysqlCredit;
import com.example.studentscore.demo.mapper.CreditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CreditController {

    @Autowired
    CreditMapper creditMapper;

    MysqlCredit mysqlCredit = new MysqlCredit();
    @RequestMapping("/insertCredit")
    public boolean insertCredit(String id, String practiveJSON, String gameJSON,String businessJSON,
                                String papersJSON, String knowledgeJSON, String researchJSON,
                                String reportJSON, String lectureJSON, String othersJSON){

            System.out.println("credit" + mysqlCredit.toString());
            creditMapper.insertCredit(id, practiveJSON, gameJSON, businessJSON,
                    papersJSON, knowledgeJSON, researchJSON,
                    reportJSON, lectureJSON, othersJSON);

            return true;
    }

    @RequestMapping("getCreditById")
    public MysqlCredit getCreditById(String id){
        MysqlCredit credit1  = new MysqlCredit();
        System.out.println("要查找的id是： \n" + id);
        String practice = creditMapper.findPracticeByid(id);
        String game = creditMapper.findGameByid(id);
        String business = creditMapper.findBusinessByid(id);
        String papers = creditMapper.findPapersByid(id);
        String knowledge = creditMapper.findKnowledgeByid(id);
        String research = creditMapper.findResearchByid(id);
        String report = creditMapper.findReportByid(id);
        String lecture = creditMapper.findLectureByid(id);
        String others = creditMapper.findOtherByid(id);

        credit1.setPractice(practice);
        credit1.setBusiness(business);
        credit1.setGame(game);
        credit1.setKnowledge(knowledge);
        credit1.setLecture(lecture);
        credit1.setOthers(others);
        credit1.setReport(report);
        credit1.setResearch(research);
        credit1.setPapers(papers);

        return credit1;
    }
}
