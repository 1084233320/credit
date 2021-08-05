package cn.edu.nuc.creditstatistics.po.credit;

import java.io.Serializable;

//科研活动  6
    public class Research implements Serializable {

        @Override
        public String toString() {
            return "Research{" +
                    "grade=" + grade +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", leader='" + leader + '\'' +
                    '}';
        }

    private double grade;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //项目名称
    private String name;
    //项目负责人
    private String leader;

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

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }
}
