package cn.edu.nuc.creditstatistics.po.credit;

import java.io.Serializable;

//学术论文 4
public class Papers implements Serializable {

    @Override
    public String toString() {
        return "Papers{" +
                "id=" + id +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                ", newspapers='" + newspapers + '\'' +
                '}';
    }

    private int id;

    private double grade;

    //论文名称
    private String name;
    //发表的期刊
    private String newspapers;

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

    public String getNewspapers() {
        return newspapers;
    }

    public void setNewspapers(String newspapers) {
        this.newspapers = newspapers;
    }
}
