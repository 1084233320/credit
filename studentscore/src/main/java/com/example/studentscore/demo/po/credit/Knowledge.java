package com.example.studentscore.demo.po.credit;

import java.util.Arrays;

//知识产权 5
public class Knowledge {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Knowledge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + Arrays.toString(level) +
                ", grade=" + grade +
                '}';
    }

    //专利名称
    private String name;
    //专利类别
    private int[] level;

    private double grade;

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getLevel() {
        return level;
    }

    public void setLevel(int[] level) {
        this.level = level;
    }
}
