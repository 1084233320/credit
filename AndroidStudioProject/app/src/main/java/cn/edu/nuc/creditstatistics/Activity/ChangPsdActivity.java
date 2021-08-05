package cn.edu.nuc.creditstatistics.Activity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.edu.nuc.creditstatistics.Fragment.HomeFragment;
import cn.edu.nuc.creditstatistics.Fragment.MineFragment;
import cn.edu.nuc.creditstatistics.R;
import cn.edu.nuc.creditstatistics.po.Student;

import static cn.edu.nuc.creditstatistics.tools.HttpUtil.sendHttpRequest;

public class ChangPsdActivity extends AppCompatActivity {

    private EditText edUsername;
    private EditText edPassword;
    private Button btnDeletePassword;
    private EditText edConfirmPassword;
    private Button btnDeletePassword1;
    private Button change;

    //flag用来标志子线程执行结束
    static boolean flag = false;
    private String urlStr = "change";
    String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.changpsd);

        edUsername = (EditText) findViewById(R.id.ed_username);
        edPassword = (EditText) findViewById(R.id.ed_password);
        btnDeletePassword = (Button) findViewById(R.id.btn_deletePassword);
        edConfirmPassword = (EditText) findViewById(R.id.ed_confirmPassword);
        btnDeletePassword1 = (Button) findViewById(R.id.btn_deletePassword_1);
        change = (Button) findViewById(R.id.btn_change);


        change.setOnClickListener(buttonListener);

//        while(!flag);
//        if (result.equals("true")){
//            Log.d("AAA","result"+result);
//            Toast.makeText(ChangPsdActivity.this,"修改成功",Toast.LENGTH_LONG).show();
//        }
    }

    Button.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new Thread(){
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void run() {
                    Map<String,String> map = new HashMap<String,String>();
                    map.put("id",edUsername.getText().toString());
                    map.put("password",edPassword.getText().toString());
//                    Log.d("ATW","传递参数之前" + map);
                    result = sendHttpRequest(urlStr,"POST",map);
//                    Log.d("ATW","是否成功修改" + result);
                    ChangPsdActivity.callback();
                    Toast.makeText(ChangPsdActivity.this,"修改成功",Toast.LENGTH_LONG).show();
                    finish();

                }
            }.start();
        }
    };


    public static void callback()
    {
        System.out.println("子线程执行结束");
        flag = true;
    }
}
