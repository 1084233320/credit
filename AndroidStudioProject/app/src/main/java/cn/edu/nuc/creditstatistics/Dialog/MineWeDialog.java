package cn.edu.nuc.creditstatistics.Dialog;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

import cn.edu.nuc.creditstatistics.R;

public class MineWeDialog extends Dialog {
    public MineWeDialog(@NonNull Context context) {
        super(context, R.style.LoginDialog);
        setContentView(R.layout.dialog_mine);
        setCancelable(true);
    }
}
