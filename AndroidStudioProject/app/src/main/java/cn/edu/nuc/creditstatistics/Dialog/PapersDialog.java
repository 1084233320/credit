package cn.edu.nuc.creditstatistics.Dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import cn.edu.nuc.creditstatistics.R;
import cn.edu.nuc.creditstatistics.po.Credit;



public class PapersDialog extends Dialog {


    private EditText etPractiveName;
    private EditText etPractiveTime;
    private EditText et_rank;
    private EditText etRank;
    private EditText etPracticeCredit;
    private Button btnUp;
    private Button btnCancel;
    private Button up_picture;

    String result;




    public PapersDialog(@NonNull Context context, final Credit credit) {
        super(context,R.style.LoginDialog);
        setContentView(R.layout.dialog_papers);
        setTitle("学术论文");
        setCancelable(true);

        etPractiveName = (EditText) findViewById(R.id.et_game_name);
        etPractiveTime = (EditText) findViewById(R.id.et_game_program);
        etPracticeCredit = (EditText) findViewById(R.id.et_practice_credit);
        btnUp = (Button) findViewById(R.id.btn_up);
        btnCancel = (Button) findViewById(R.id.btn_Cancel);
        Button.OnClickListener buttonLisenter = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_up:
                        String name = etPractiveName.getText().toString();
                        String time = etPractiveTime.getText().toString();
                        double addCredit = Double.parseDouble(etPracticeCredit.getText().toString().trim());
                        credit.papers.setName(name);
                        credit.papers.setNewspapers(time);
                        credit.papers.setGrade(addCredit);
                        Log.d("AAA","dialog里头的"+credit.papers.toString());
                        break;
                    case R.id.btn_Cancel:
                        dismiss();
                        break;

                }
                dismiss();
            }
        };
        btnUp.setOnClickListener(buttonLisenter);
        btnCancel.setOnClickListener(buttonLisenter);
    }


}
