package com.example.studentscore.demo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Mapper
@Repository
public interface CreditMapper {

    public void insertCredit(String id, String practiveJSON,
                             String gameJSON, String businessJSON,
                             String papersJSON, String knowledgeJSON,
                             String researchJSON, String reportJSON,
                             String lectuerJSON, String othersJson);

    public String findPracticeByid(String id);
    public String findGameByid(String id);

    public String findBusinessByid(String id);

    public String findPapersByid(String id);

    public String findKnowledgeByid(String id);

    public String findResearchByid(String id);

    public String findReportByid(String id);

    public String findLectureByid(String id);

    public String findOtherByid(String id);

    public boolean isExist(String id);

    public int findCreditIsExist(String id);
}
