package cn.edu.nuc.creditstatistics;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import cn.edu.nuc.creditstatistics.Fragment.TotalFragment;
import cn.edu.nuc.creditstatistics.po.Credit;
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


public class MainActivity extends AppCompatActivity {

    private Button btn_login = null;
    private Button btn_deletePassword = null;
    private EditText ed_userName = null;
    private EditText ed_password = null;
    private TextView right = null;
    private Context mContext;
    private String urlStr = "checking";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Credit credit = (Credit) getApplication();
        credit.practice = new Practice();
        credit.business = new Business();
        credit.papers = new Papers();
        credit.knowledge = new Knowledge();
        credit.research = new Research();
        credit.report = new Report();
        credit.lecture = new Lecture();
        credit.others = new Others();
        credit.game = new Game();


        btn_login = findViewById(R.id.btn_login);
        ed_userName = findViewById(R.id.ed_userName);
        ed_password = findViewById(R.id.ed_password);
        right = findViewById(R.id.right);
        btn_deletePassword = findViewById(R.id.btn_deletePassword);
        btn_login.setOnClickListener(buttonLisenter);
        btn_deletePassword.setOnClickListener(buttonLisenter);

    }

    Button.OnClickListener buttonLisenter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_login:
                    new Thread(){
                        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                        @Override
                        public void run() {
                            Map<String,String> map = new HashMap<String,String>();
                            String id = ed_userName.getText().toString();
                            String password = ed_password.getText().toString();

                            map.put("id",id);
                            map.put("password",password);
                            String result = sendHttpRequest(urlStr,"POST",map);
                            Log.d("ATW","result"+result);
                            if (result.equals("true")){
                                Intent intent = new Intent(MainActivity.this, TotalFragment.class);
                                intent.putExtra("id",ed_userName.getText().toString());
                                final Credit credit = (Credit) getApplication();
                                credit.setId(id);
                                startActivity(intent);
                            }else{
                                right.setText("账号或密码有误，请重新输入");
                            }

//                        info.setText(result);
                        }
                    }.start();
                    break;
                case R.id.btn_deletePassword:
                    ed_password.setText("");
                    break;
            }
        }
    };
}