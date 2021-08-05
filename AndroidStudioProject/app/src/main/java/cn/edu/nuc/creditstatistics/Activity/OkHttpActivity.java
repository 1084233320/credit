package cn.edu.nuc.creditstatistics.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;


import cn.edu.nuc.creditstatistics.R;
import cn.edu.nuc.creditstatistics.po.Student;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends Activity {
    private static final int GET = 1;
    private static final int POST = 2;
    private Student student = new Student();
    public static final MediaType JSON =
            MediaType.parse("application/json; charset=utf-8");

    private OkHttpClient client = new OkHttpClient();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case GET:
                    Student student1 = new Student();
                   // student1 = (Student) msg.obj;
                    textView.setText((String)msg.obj);
             //       textView.setText(String.valueOf(student1.getCredit()));
                    break;
                case POST:
                    textView.setText((String)msg.obj);
                    break;
            }
        }
    };

    Button getpost = null;
    TextView textView = null;
    private String localhost = "http://10.128.110.231:8080/";
    private String urlStr = localhost + "findAllActivity";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wocao);
        getpost = findViewById(R.id.bt_refresh);
        textView = findViewById(R.id.text);

        getpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.bt_refresh:
                        textView.setText("");
                        //getDataFromPost();
                        getDataFromGet();
                        break;
                }
            }
        });

    }
//  使用get请求网络数据
    private void getDataFromGet(){
        new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    String result = getUrl(urlStr);
                    //student = (Student) com.alibaba.fastjson.JSONArray.parseArray(result,Student.class);
                    Log.e("sucess", result);
                    Message msg = new Message();
                    //msg.obj = student;
                    msg.obj = result;
                    msg.what = GET;
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }


    //  使用post请求网络数据
//    private void getDataFromPost(){
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//
//                JSONObject object = new JSONObject();
//                try {
//                    object.put("String","1807004235");
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                try {
//                    String result = postUrl(urlStr,"");
//                    //student = (Student) com.alibaba.fastjson.JSONArray.parseArray(result,Student.class);
//                    Log.e("sucess", result);
//                    Message msg = new Message();
//                    //msg.obj = student;
//                    msg.obj = result;
//                    msg.what = POST;
//                    handler.sendMessage(msg);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//
//    }


    //get请求
    private String getUrl(String url) throws IOException{
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


//    String postUrl(String url,String json) throws IOException{
//        RequestBody body = RequestBody.create(JSON,json);
//        Request request = new Request.Builder().url(urlStr).post(body).build();
//        Response response = client.newCall(request).execute();
//        return response.body().string();
//    }

}
