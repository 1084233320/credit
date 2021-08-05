package com.example.studentscore.demo.po;

public class Student {
    private String id;
    private String name;
    private double credit;
    private String password;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", password='" + password + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCredit() {
        return credit;
    }

    public String getPassword() {
        return password;
    }

}
