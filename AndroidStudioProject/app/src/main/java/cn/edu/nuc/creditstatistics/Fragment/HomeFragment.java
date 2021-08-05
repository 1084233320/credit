package cn.edu.nuc.creditstatistics.Fragment;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSONObject;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import cn.edu.nuc.creditstatistics.R;
import cn.edu.nuc.creditstatistics.po.Student;

import static cn.edu.nuc.creditstatistics.tools.HttpUtil.sendHttpRequest;


public class HomeFragment  extends BaseFragment{

    //flag用来标志子线程执行结束
    static boolean flag = false;
    private String urlStr = "findStudentById";
    String result;
    String id;
    Student student = new Student();


    public HomeFragment(String num) {
        id = num;
        Log.d("ATW","构造id"+id);
    }


    TextView myname = null;
    TextView have_credit = null;
    TextView need_credit = null;
    TextView ending = null;


    @Override
    public View initView() {


        View view = View.inflate(mContext, R.layout.fragment_home,null);
        myname = view.findViewById(R.id.myname);
        have_credit = view.findViewById(R.id.have_credit);
        need_credit = view.findViewById(R.id.need_credit);
        ending = view.findViewById(R.id.ending);
        new Thread(){
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                Map<String,String> map = new HashMap<String,String>();
                map.put("id",id);

                result = sendHttpRequest(urlStr,"POST",map);
                Log.d("ATW","result" + result);
                student = JSONObject.parseObject(result,Student.class);
                HomeFragment.callback();
//                students= JSONUtil.fromJsons(result,new TypeToken<List<Student>>(){}.getType());
                Log.d("ATW","student" + student);

            }
        }.start();

        //等待子线程执行结束
        while(!flag);
        Log.d("ATW","输出之前" + student);
        myname.setText(student.getName());
        have_credit.setText(String.valueOf(student.getCredit()));
        if (student.getCredit() >= 4.0){
            need_credit.setText("您已修满！");
            ending.setText("恭喜！");
        }else {
            BigDecimal bg = new BigDecimal(4 - student.getCredit());
            double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            DecimalFormat df = new DecimalFormat("#.00");
            need_credit.setText("还需修学分：" + String.valueOf(f1));
            ending.setText("要积极参加比赛和活动啊！");
        }


        return view;
    }


    public static void callback()
    {
        System.out.println("子线程执行结束");
        flag = true;
    }
}

