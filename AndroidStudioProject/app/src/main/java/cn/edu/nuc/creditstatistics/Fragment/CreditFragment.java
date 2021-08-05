package cn.edu.nuc.creditstatistics.Fragment;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


import java.util.HashMap;
import java.util.Map;

import cn.edu.nuc.creditstatistics.Dialog.AllDialog;
import cn.edu.nuc.creditstatistics.Dialog.BusinessDialog;
import cn.edu.nuc.creditstatistics.Dialog.GameDialog;
import cn.edu.nuc.creditstatistics.Dialog.KnowledgeDialog;
import cn.edu.nuc.creditstatistics.Dialog.LectureDialog;
import cn.edu.nuc.creditstatistics.Dialog.OthersDialog;
import cn.edu.nuc.creditstatistics.Dialog.PapersDialog;
import cn.edu.nuc.creditstatistics.Dialog.PracticeDialog;
import cn.edu.nuc.creditstatistics.Dialog.PreviewDialog;
import cn.edu.nuc.creditstatistics.Dialog.ReportDialog;
import cn.edu.nuc.creditstatistics.Dialog.ResearchDialog;
import cn.edu.nuc.creditstatistics.R;
import cn.edu.nuc.creditstatistics.po.Credit;
import cn.edu.nuc.creditstatistics.po.MysqlCredit;
import cn.edu.nuc.creditstatistics.po.Student;
import cn.edu.nuc.creditstatistics.po.credit.Business;
import cn.edu.nuc.creditstatistics.po.credit.Game;
import cn.edu.nuc.creditstatistics.po.credit.Knowledge;
import cn.edu.nuc.creditstatistics.po.credit.Lecture;
import cn.edu.nuc.creditstatistics.po.credit.Others;
import cn.edu.nuc.creditstatistics.po.credit.Papers;
import cn.edu.nuc.creditstatistics.po.credit.Practice;
import cn.edu.nuc.creditstatistics.po.credit.Report;
import cn.edu.nuc.creditstatistics.po.credit.Research;

import static cn.edu.nuc.creditstatistics.tools.HttpUtil.sendHttpRequest;


public class CreditFragment  extends BaseFragment{


    private static boolean flag = false;
    private Button practive;
    private Button game;
    private Button business;
    private Button papers;
    private Button knowlegde;
    private Button research;
    private Button report;
    private Button lecture;
    private Button others;
    private Button yulan;
    private Button all;
    private Button up;

    String result;
    String UrlStr = "insertCredit";
    MysqlCredit hei = new MysqlCredit();
    Credit hei1 = new Credit();






    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_credit,null);
        Credit credit = (Credit) getActivity().getApplication();
        practive = view.findViewById(R.id.practive);
        game = view.findViewById(R.id.game);
        business = view.findViewById(R.id.business);
        papers = view.findViewById(R.id.papers);
        knowlegde = view.findViewById(R.id.knowlegde);
        research = view.findViewById(R.id.research);
        report = view.findViewById(R.id.report);
        lecture = view.findViewById(R.id.lecture);
        others = view.findViewById(R.id.others);
        yulan = view.findViewById(R.id.yulan);
        all = view.findViewById(R.id.all);
        up = view.findViewById(R.id.up);

        practive.setOnClickListener(buttonListener);
        game.setOnClickListener(buttonListener);
        business.setOnClickListener(buttonListener);
        papers.setOnClickListener(buttonListener);
        knowlegde.setOnClickListener(buttonListener);
        research.setOnClickListener(buttonListener);
        report.setOnClickListener(buttonListener);
        lecture.setOnClickListener(buttonListener);
        others.setOnClickListener(buttonListener);
        yulan.setOnClickListener(buttonListener);
        up.setOnClickListener(buttonListener);
        all.setOnClickListener(buttonListener);

        return view;
    }

    private static void callback() {
        flag = true;
    }


    Button.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Credit credit = (Credit) getActivity().getApplication();
            switch (v.getId()){
                case R.id.practive:
                    PracticeDialog practiceDialog = new PracticeDialog(CreditFragment.this.getContext(),credit);
                    practiceDialog.show();
//                    Log.d("AAA","credit:::"+credit.practice.toString());
                    break;
                case R.id.business:
                    BusinessDialog businessDialog = new BusinessDialog(CreditFragment.this.getContext(),credit);
                    businessDialog.show();
                    break;
                case R.id.papers:
                    PapersDialog papersDialog = new PapersDialog(CreditFragment.this.getContext(),credit);
                    papersDialog.show();
                    break;
                case R.id.knowlegde:
                    KnowledgeDialog knowledgeDialog = new KnowledgeDialog(CreditFragment.this.getContext(),credit);
                    knowledgeDialog.show();
                    break;
                case R.id.research:
                    ResearchDialog researchDialog = new ResearchDialog(CreditFragment.this.getContext(),credit);
                    researchDialog.show();
                    break;
                case R.id.report:
                    ReportDialog reportDialog = new ReportDialog(CreditFragment.this.getContext(),credit);
                    reportDialog.show();
                    break;
                case R.id.lecture:
                    LectureDialog lectureDialog = new LectureDialog(CreditFragment.this.getContext(),credit);
                    lectureDialog.show();
                    break;
                case R.id.game:
                    GameDialog gameDialog = new GameDialog(CreditFragment.this.getContext(),credit);
                    gameDialog.show();
                    break;
                case R.id.others:
                    OthersDialog othersDialog = new OthersDialog(CreditFragment.this.getContext(),credit);
                    othersDialog.show();
                    break;
                case R.id.yulan:
                    PreviewDialog previewDialog = new PreviewDialog(CreditFragment.this.getContext(),credit);
                    previewDialog.show();
                    Log.d("AAA","credit:::"+credit.toString());
                    break;
                case R.id.up:
                    new Thread(){
                        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                        @Override
                        public void run() {
                            Map<String,String> map = new HashMap<>();

                            String practiveJson = JSON.toJSONString(credit.practice);
                            String gameJson = JSON.toJSONString(credit.game);
                            String businessJson = JSON.toJSONString(credit.business);
                            String papersJson = JSON.toJSONString(credit.papers);
                            String knowledgeJson = JSON.toJSONString(credit.knowledge);
                            String researchJson = JSON.toJSONString(credit.research);
                            String reportJson = JSON.toJSONString(credit.report);
                            String lectureJson = JSON.toJSONString(credit.lecture);
                            String othersJson = JSON.toJSONString(credit.others);
                            Log.d("ATW","转JSON后：" + practiveJson);
                            map.put("id",String.valueOf(credit.getId()));
                            map.put("practiveJSON",practiveJson);
                            map.put("gameJSON",gameJson);
                            map.put("businessJSON",businessJson);
                            map.put("papersJSON",papersJson);
                            map.put("knowledgeJSON",knowledgeJson);
                            map.put("researchJSON",researchJson);
                            map.put("reportJSON",reportJson);
                            map.put("lectureJSON",lectureJson);
                            map.put("othersJSON",othersJson);
                            Log.d("ATW","上传之前的map：" +  map);
                            result = sendHttpRequest("insertCredit","POST",map);
                            Log.d("ATW","是否上传学分：" +  result);
//                            Toast.makeText(CreditFragment.this.getContext(),"上传成功！",Toast.LENGTH_LONG).show();
                        }
                    }.start();
                    break;
                case R.id.all:
                    Toast.makeText(CreditFragment.this.getContext(),"点击了查看我的学分",Toast.LENGTH_LONG).show();
                    new Thread(){
                        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                        @Override
                        public void run() {
                            Map<String,String> map = new HashMap<>();
                            map.put("id",credit.getId());
                            String result = sendHttpRequest("getCreditById","POST",map);

//                            hei = JSONObject.parseObject(result,Credit.class);
                            Log.d("ATW","传递回来的Credit类是：" +  result);
//                            Student hei12 = JSONObject.parseObject(result, Student.class);
//                            Log.d("ATW", "解析之后的Student: " + hei12.toString());
                            hei = JSONObject.parseObject(result, MysqlCredit.class);
                            Practice practice1 = JSON.parseObject(hei.getPractice(),Practice.class);
                            Game game1 = JSON.parseObject(hei.getGame(),Game.class);
                            Business business1 = JSON.parseObject(hei.getBusiness(),Business.class);
                            Papers papers1 = JSON.parseObject(hei.getPapers(),Papers.class);
                            Knowledge knowledge1 = JSON.parseObject(hei.getKnowledge(),Knowledge.class);
                            Research research1 = JSON.parseObject(hei.getResearch(),Research.class);
                            Report report1 = JSON.parseObject(hei.getReport(),Report.class);
                            Lecture lecture1 = JSON.parseObject(hei.getLecture(),Lecture.class);
                            Others others1 = JSON.parseObject(hei.getOthers(),Others.class);
//
                            hei1.setPractice(practice1);
                            hei1.setGame(game1);
                            hei1.setBusiness(business1);
                            hei1.setPapers(papers1);
                            hei1.setKnowledge(knowledge1);
                            hei1.setResearch(research1);
                            hei1.setReport(report1);
                            hei1.setLecture(lecture1);
                            hei1.setOthers(others1);

                            Log.d("BBB","practice::::" + hei.getPractice());
                            Log.d("BBB","practice1::::" + practice1);
                            Log.d("BBB","hei1::::" + hei1);
                            CreditFragment.callback();
                        }
                    }.start();
                    while(!flag);
                    AllDialog allDialog = new AllDialog(CreditFragment.this.getContext(),hei1);
                    allDialog.show();
                    break;

            }
        }
    };


}
