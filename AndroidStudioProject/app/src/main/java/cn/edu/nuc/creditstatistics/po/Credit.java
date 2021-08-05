package cn.edu.nuc.creditstatistics.po;


import android.app.Application;

import java.io.Serializable;

import cn.edu.nuc.creditstatistics.po.credit.Business;
import cn.edu.nuc.creditstatistics.po.credit.Game;
import cn.edu.nuc.creditstatistics.po.credit.Knowledge;
import cn.edu.nuc.creditstatistics.po.credit.Lecture;
import cn.edu.nuc.creditstatistics.po.credit.Others;
import cn.edu.nuc.creditstatistics.po.credit.Papers;
import cn.edu.nuc.creditstatistics.po.credit.Practice;
import cn.edu.nuc.creditstatistics.po.credit.Report;
import cn.edu.nuc.creditstatistics.po.credit.Research;

public class Credit extends Application implements Serializable {
    //学号
    private String id;
    //创新创业训练项目
    public Practice practice;
    //学科竞赛
    public Game game;
    //创业实践
    public Business business;
    //学术论文
    public Papers papers;
    //知识产权
    public Knowledge knowledge;
    //科研活动
    public Research research;
    //学术报告
    public Report report;
    //创新创业讲座
    public Lecture lecture;
    //其他类
    public Others others;

    public double allGrade;

    @Override
    public String toString() {
        return "Credit{" +
                "id='" + id + '\'' +
                ", practice=" + practice +
                ", game=" + game +
                ", business=" + business +
                ", papers=" + papers +
                ", knowledge=" + knowledge +
                ", research=" + research +
                ", report=" + report +
                ", lecture=" + lecture +
                ", others=" + others +
                ", allGrade=" + allGrade +
                '}';
    }

    public double getAllGrade() {
        allGrade = practice.getGrade() +
                business.getGrade() +
                game.getGrade() +
                knowledge.getGrade() +
                lecture.getGrade() +
                others.getGrade() +
                papers.getGrade() +
                report.getGrade() +
                research.getGrade();
        return allGrade;
    }

    public void setAllGrade(double allGrade) {
        this.allGrade = allGrade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Practice getPractice() {
        return practice;
    }

    public void setPractice(Practice practice) {
        this.practice = practice;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Papers getPapers() {
        return papers;
    }

    public void setPapers(Papers papers) {
        this.papers = papers;
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }

    public Research getResearch() {
        return research;
    }

    public void setResearch(Research research) {
        this.research = research;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Others getOthers() {
        return others;
    }

    public void setOthers(Others others) {
        this.others = others;
    }
}
