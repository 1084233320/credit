package com.example.studentscore.demo.po;

public class Activity {


    //活动名称
    private String name;
    //举办单位
    private String hold;
    //加多少学分
    private double credit;
    //举办时间
    private String time;
    //举办地点
    private String location;
    //简介
    private String content;

    @Override
    public String toString() {
        return "Activity{" +
                ", name='" + name + '\'' +
                ", hold='" + hold + '\'' +
                ", credit=" + credit +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", content='" + content + '\'' +
                '}';
    }


    public String getName() {
        return name;
    }

    public String getHold() {
        return hold;
    }

    public double getCredit() {
        return credit;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getContent() {
        return content;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setHold(String hold) {
        this.hold = hold;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
