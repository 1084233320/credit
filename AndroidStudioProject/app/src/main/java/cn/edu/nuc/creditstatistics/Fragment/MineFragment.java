package cn.edu.nuc.creditstatistics.Fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.nuc.creditstatistics.Activity.ChangPsdActivity;
import cn.edu.nuc.creditstatistics.Dialog.MineWeDialog;
import cn.edu.nuc.creditstatistics.R;

public class MineFragment extends  BaseFragment{


    private TextView changePsd;
    private TextView suggest;
    private TextView we;




    @Override
    public View initView() {
        Log.d("ATW","mine");
        View view = View.inflate(mContext, R.layout.fragment_mine,null);
        changePsd = (TextView) view.findViewById(R.id.changePsd);
        suggest = (TextView) view.findViewById(R.id.suggest);
        we = (TextView) view.findViewById(R.id.we);

        changePsd.setOnClickListener(textListener);
        we.setOnClickListener(textListener);
        return view;
    }

    TextView.OnClickListener textListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.changePsd:
                    Intent intent = new Intent(MineFragment.this.getContext(), ChangPsdActivity.class);
                    Toast.makeText(MineFragment.this.getContext(),"startActivity之前",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    break;
                case R.id.we:
                    MineWeDialog mineWeDialog = new MineWeDialog(MineFragment.this.getContext());
                    mineWeDialog.show();
            }
        }
    };
}
