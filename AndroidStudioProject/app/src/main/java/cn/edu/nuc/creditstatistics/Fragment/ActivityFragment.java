package cn.edu.nuc.creditstatistics.Fragment;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import cn.edu.nuc.creditstatistics.R;
import cn.edu.nuc.creditstatistics.po.Activity;

import static cn.edu.nuc.creditstatistics.tools.HttpUtil.sendHttpRequest;

public class ActivityFragment  extends BaseFragment{

    static boolean flag = false;
    private ListView mLv;
    private String urlStr = "findAllActivity";
    String result;



    private List<Activity> activityList = new ArrayList<>();
    private Button getInfo;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_activity,null);
        mLv = view.findViewById(R.id.list_item);

        new Thread(){
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                Map<String,String> map = new HashMap<String,String>();
                result = sendHttpRequest(urlStr,"POST",map);
                activityList = JSONObject.parseArray(result,Activity.class);
                ActivityFragment.callback();
                Log.d("ATW","activity" + activityList);

            }
        }.start();
        while(!flag);
        MyAdapter adapter = new MyAdapter(mContext,activityList);
        mLv.setAdapter(adapter);
        return view;
    }



//    private void getJsonData(){
//        OkHttpClient mOkHttpClient = new OkHttpClient();
//        final Request request = new Request.Builder().url(urlStr).build();
//        Call call = mOkHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.v("Fail",e.getMessage());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String responseStr = response.body().string();
////                List<Student> studentEntities = new ArrayList<>();
////                studentEntities = com.alibaba.fastjson.JSONArray.parseArray(responseStr,Student.class);
////                Message msg = mHandler.obtainMessage();
////                msg.obj = studentEntities;
//
//                List<Activity> activitiyEntities = new ArrayList<>();
//                activitiyEntities = com.alibaba.fastjson.JSONArray.parseArray(responseStr,Activity.class);
//                Message msg = mHandler.obtainMessage();
//                msg.obj = activitiyEntities;
//                mHandler.sendMessage(msg);
//            }
//        });
//    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
//            studentList = (List<Student>)msg.obj;
//            if(null != studentList){
//                mLv.setVisibility(View.VISIBLE);
//                MyAdapter adapter = new MyAdapter(mContext,studentList);
//                mLv.setAdapter(adapter);
//            }
            //等待子线程执行结束

            Log.d("ATW","子进程结束后activity" + activityList);
            activityList = (List<Activity>) msg.obj;
            if(activityList != null){
                MyAdapter adapter = new MyAdapter(mContext,activityList);
                mLv.setAdapter(adapter);
            }
        }
    };
    private class MyAdapter extends BaseAdapter {
        private List<Activity> activitiyEntitles = new ArrayList<>();
        private Context context;
        public MyAdapter(Context context,List<Activity> activitiyEntitles){
            this.context = context;
            this.activitiyEntitles = activitiyEntitles;
        }
        @Override
        public int getCount() {
            if(activitiyEntitles.size() != 0){
                return activitiyEntitles.size();
            }else{
                return 0;
            }
        }
        @Override
        public Object getItem(int i) {
            if(activitiyEntitles.size() != 0){
                return activitiyEntitles.get(i);
            }else{
                return null;
            }
        }
        @Override
        public long getItemId(int i) {
            return i;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder mViewHolder = null;
            if(null == view){
                mViewHolder = new ViewHolder();
                view = LayoutInflater.from(mContext).inflate(R.layout.test,null);
                mViewHolder.mTvName = (TextView) view.findViewById(R.id.name);
                mViewHolder.mTvHold = (TextView) view.findViewById(R.id.hold);
                mViewHolder.mTvCredit = (TextView) view.findViewById(R.id.credit);
                mViewHolder.mTvTime = (TextView) view.findViewById(R.id.time);
                mViewHolder.mTvLocation = (TextView) view.findViewById(R.id.location);
                mViewHolder.mTvContent = (TextView) view.findViewById(R.id.content);

                view.setTag(mViewHolder);
            }else{
                mViewHolder = (ViewHolder) view.getTag();
            }
            Activity stu = activitiyEntitles.get(i);
            mViewHolder.mTvName.setText(stu.getName());
            mViewHolder.mTvHold.setText(stu.getHold());
            mViewHolder.mTvCredit.setText(String.valueOf(stu.getCredit()));
            mViewHolder.mTvTime.setText(stu.getTime());
            mViewHolder.mTvLocation.setText(stu.getLocation());
            mViewHolder.mTvContent.setText(stu.getContent());

            return view;
        }
    }
    private class ViewHolder{
        private TextView mTvName,mTvHold,mTvCredit,mTvTime,mTvLocation,mTvContent;
    }

    public static void callback()
    {
        System.out.println("子线程执行结束");
        flag = true;
    }
    }




