package cn.edu.nuc.creditstatistics.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

import cn.edu.nuc.creditstatistics.R;
import cn.edu.nuc.creditstatistics.po.Credit;

public class TotalFragment extends FragmentActivity {

    String id;


    protected Context mContext;
    FrameLayout frameLayout;
    RadioGroup rgMain;
    //装多个Fragment的实例
    private ArrayList<BaseFragment> fragments;


    private int position = 0;
    //缓存的Fragemnt或者上次显示的Fragment
    private Fragment tempFragemnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        frameLayout = findViewById(R.id.frameLayout);
        rgMain = findViewById(R.id.rg_main);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        //初始化Fragment
        initFragment();
        //设置RadioGroupd的监听
        initListener();



    }

    private  void initListener(){
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton_home:
                        position = 0;
                        break;
                    case R.id.radioButton_activity:
                        position = 1;
                        break;
                    case R.id.radioButton_credit:
                        position = 2;
                        break;
                    case R.id.radioButton_mine:
                        position = 3;
                        break;
                    default:
                        position = 0;
                        break;
                }
                //根据位置取不同的Fragment
                BaseFragment baseFragment = getFragment(position);

                /**
                 * 第一参数：上次显示的Fragment
                 * 第二参数：当前正要显示的Fragment
                 */
                switchFragment(tempFragemnt, baseFragment);

            }
        });
        rgMain.check(R.id.radioButton_home);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment(id));
        fragments.add(new ActivityFragment());
        fragments.add(new CreditFragment());
        fragments.add(new MineFragment());
    }

    private BaseFragment getFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }
    /**
     * 切换Fragment
     * @param fromFragment
     * @param nextFragment
     */
    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
        if (tempFragemnt != nextFragment) {
            tempFragemnt = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    //添加Fragment
                    transaction.add(R.id.frameLayout, nextFragment).commit();
                } else {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }



}