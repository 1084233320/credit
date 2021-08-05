package com.example.studentscore.demo.po.credit;

import java.util.Arrays;

//学科竞赛  2
public class Game {

    private int id;
    //比赛名称
    private String game_name;
    //项目名称
    private String project_name;
    //获奖级别
    private int[] level;

    private double grade;

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", game_name='" + game_name + '\'' +
                ", project_name='" + project_name + '\'' +
                ", level=" + Arrays.toString(level) +
                ", grade=" + grade +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGame_name() {
        return game_name;
    }

    public String getProject_name() {
        return project_name;
    }

    public int[] getLevel() {
        return level;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public void setLevel(int[] level) {
        this.level = level;
    }
}
