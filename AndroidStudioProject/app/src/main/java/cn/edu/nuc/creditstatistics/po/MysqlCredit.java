package cn.edu.nuc.creditstatistics.po;


public class MysqlCredit {
    //学号
    private int id;
    //创新创业训练项目
    private String practice;
    //学科竞赛
    private String game;
    //创业实践
    private String business;
    //学术论文
    private String papers;
    //知识产权
    private String knowledge;
    //科研活动
    private String research;
    //学术报告
    private String report;
    //创新创业讲座
    private String lecture;
    //其他类
    private String others;

    private double allGrade;

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", practice='" + practice + '\'' +
                ", game='" + game + '\'' +
                ", business='" + business + '\'' +
                ", papers='" + papers + '\'' +
                ", knowledge='" + knowledge + '\'' +
                ", research='" + research + '\'' +
                ", report='" + report + '\'' +
                ", lecture='" + lecture + '\'' +
                ", others='" + others + '\'' +
                ", allGrade=" + allGrade +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getPapers() {
        return papers;
    }

    public void setPapers(String papers) {
        this.papers = papers;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public double getAllGrade() {
        return allGrade;
    }

    public void setAllGrade(double allGrade) {
        this.allGrade = allGrade;
    }
}
