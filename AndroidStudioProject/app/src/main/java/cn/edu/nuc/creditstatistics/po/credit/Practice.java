package cn.edu.nuc.creditstatistics.po.credit;

import java.io.Serializable;

//创新创业训练项目
public class Practice implements Serializable {
    //1-----创新创业训练项目
    private int id;

    //项目名字
    private String name;
    //立项时间
    private String time;
    //级别
    private String ranking;

    private double grade;

    private String picture;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    @Override
    public String toString() {
        return "practice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", ranking='" + ranking + '\'' +
                ", grade=" + grade +
                '}';
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }


    public String getRanking() {
        return ranking;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
}
