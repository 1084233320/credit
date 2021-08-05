package cn.edu.nuc.creditstatistics.po.credit;

import java.io.Serializable;

//其他类 9
public class Others implements Serializable {

    private String  remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Others{" +
                "remarks='" + remarks + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String name;

    private double grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
