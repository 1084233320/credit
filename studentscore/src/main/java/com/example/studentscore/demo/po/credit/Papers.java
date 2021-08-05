package com.example.studentscore.demo.po.credit;
//学术论文 4
public class Papers {

    private int id;

    private double grade;

    @Override
    public String toString() {
        return "Papers{" +
                "id=" + id +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                ", newspapers='" + newspapers + '\'' +
                '}';
    }

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
