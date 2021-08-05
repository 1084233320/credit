package cn.edu.nuc.creditstatistics.tools;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {

    public static OkHttpClient client;
    private static final String domainName = "http://192.168.0.111:8080/";//域名
    static {//创建OkHttpClient实例
        client = new OkHttpClient();
    }

    //默认发送GET请求，若发送的为GET请求，则传递参数为"GET", null, null
    //若发送的为POST请求，则需要传递一个Map对象，将需要传递的数据放在其中
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String sendHttpRequest(String url, String method, Map<String, String> map){
        Request.Builder requestBuilder = new Request.Builder();//创建Request.Builder
        requestBuilder.url(domainName+url);//添加URL
        if(method.equals("POST")){//若请求类型为POST，则需要获取要发送的数据，并调用post方法
            FormBody.Builder requestBodyBuilder = new FormBody.Builder();
            for(Map.Entry<String, String> entry: map.entrySet()){
                requestBodyBuilder.add(entry.getKey(), entry.getValue());
            }
            requestBuilder.post(requestBodyBuilder.build());
        }
        // 添加请求类型
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(Objects.requireNonNull(MediaType.parse("multipart/form-data")));
        Request request = requestBuilder.build();//获取Request实例
        try {//获取服务器响应，将返回数据转换为字符串并返回
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;//若获取服务器响应数据失败，则
        }
    }

}
