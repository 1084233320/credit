package com.example.studentscore.demo.po.credit;

//学术报告 7
public class Report {
    private double grade;
    //报告名称
    private String name;
    //时间
    private String time;

    private int id;

    @Override
    public String toString() {
        return "Report{" +
                "grade=" + grade +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
