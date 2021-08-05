package cn.edu.nuc.creditstatistics.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import cn.edu.nuc.creditstatistics.R;
import cn.edu.nuc.creditstatistics.po.Credit;

public class PreviewDialog extends Dialog {

    private TextView practiveName;
    private TextView practiveTime;
    private TextView practiveRank;
    private TextView practiveCredit;
    private TextView gameName;
    private TextView gameProgram;
    private TextView gameRank;
    private TextView gameCredit;
    private TextView businessName;
    private TextView businessMoney;
    private TextView businessCredit;
    private TextView papersName;
    private TextView reportNewpapers;
    private TextView papersCredit;
    private TextView knowlegdeName;
    private TextView knowlegdeCredit;
    private TextView researchName;
    private TextView researchLeader;
    private TextView researchCredit;
    private TextView reportName;
    private TextView reportTime;
    private TextView reportCredit;
    private TextView lectureName;
    private TextView lectureTime;
    private TextView lectureCredit;
    private TextView othersName;
    private TextView othersRemarks;
    private TextView allCredit;




    public PreviewDialog(@NonNull Context context, Credit credit) {

        super(context,R.style.LoginDialog);
        setContentView(R.layout.dialog_preview);

        double all = credit.practice.getGrade() +
                credit.others.getGrade() +
                credit.lecture.getGrade() +
                credit.report.getGrade() +
                credit.research.getGrade() +
                credit.knowledge.getGrade() +
                credit.papers.getGrade() +
                credit.game.getGrade() +
                credit.business.getGrade();

        allCredit = (TextView)findViewById(R.id.all);
        BigDecimal bg = new BigDecimal(all);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        DecimalFormat df = new DecimalFormat("#.00");
        setTitle("本次申报总学分为：" + String.valueOf(f1));
        setCancelable(true);

        practiveName = (TextView) findViewById(R.id.practive_name);
        practiveName.setText(credit.practice.getName());
        practiveTime = (TextView) findViewById(R.id.practive_time);
        practiveTime.setText(credit.practice.getTime());
        practiveRank = (TextView) findViewById(R.id.practive_rank);
        practiveRank.setText(credit.practice.getRanking());
        practiveCredit = (TextView) findViewById(R.id.practive_credit);
        practiveCredit.setText(String.valueOf(credit.practice.getGrade()));

        gameName = (TextView) findViewById(R.id.game_name);
        gameName.setText(credit.game.getGame_name());
        gameProgram = (TextView) findViewById(R.id.game_program);
        gameProgram.setText(credit.game.getProject_name());
        gameRank = (TextView) findViewById(R.id.game_rank);
        gameRank.setText(credit.game.getRank());
        gameCredit = (TextView) findViewById(R.id.game_credit);
        gameCredit.setText(String.valueOf(credit.game.getGrade()));

        businessName = (TextView) findViewById(R.id.business_name);
        businessName.setText(credit.business.getName());
        businessMoney = (TextView) findViewById(R.id.business_money);
        businessMoney.setText(credit.business.getMoney());
        businessCredit = (TextView) findViewById(R.id.business_credit);
        businessCredit.setText(String.valueOf(credit.business.getGrade()));

        papersName = (TextView) findViewById(R.id.papers_name);
        papersName.setText(credit.papers.getName());
        papersCredit = (TextView) findViewById(R.id.papers_credit);
        papersCredit.setText(String.valueOf(credit.papers.getGrade()));

        knowlegdeName = (TextView) findViewById(R.id.knowlegde_name);
        knowlegdeName.setText(credit.knowledge.getName());
        knowlegdeCredit = (TextView) findViewById(R.id.knowlegde_credit);
        knowlegdeCredit.setText(String.valueOf(credit.knowledge.getGrade()));

        researchName = (TextView) findViewById(R.id.research_name);
        researchName.setText(credit.research.getName());
        researchLeader = (TextView) findViewById(R.id.research_leader);
        researchLeader.setText(credit.research.getLeader());
        researchCredit = (TextView) findViewById(R.id.research_credit);
        researchCredit.setText(String.valueOf(credit.research.getGrade()));

        reportName = (TextView) findViewById(R.id.report_name);
        reportName.setText(credit.report.getName());
        reportTime = (TextView) findViewById(R.id.report_time);
        reportTime.setText(credit.report.getTime());
        reportNewpapers = (TextView) findViewById(R.id.report_newpapers);
        reportNewpapers.setText(credit.papers.getNewspapers());
        reportCredit = (TextView) findViewById(R.id.report_credit);
        reportCredit.setText(String.valueOf(credit.report.getGrade()));

        lectureName = (TextView) findViewById(R.id.lecture_name);
        lectureName.setText(credit.lecture.getName());
        lectureTime = (TextView) findViewById(R.id.lecture_time);
        lectureTime.setText(credit.lecture.getTime());
        lectureCredit = (TextView) findViewById(R.id.lecture_credit);
        lectureCredit.setText(String.valueOf(credit.lecture.getGrade()));

        othersName = (TextView) findViewById(R.id.others_name);
        othersName.setText(credit.others.getName());
        othersRemarks = (TextView) findViewById(R.id.others_remarks);
        othersRemarks.setText(String.valueOf(credit.others.getGrade()));










    }
}
