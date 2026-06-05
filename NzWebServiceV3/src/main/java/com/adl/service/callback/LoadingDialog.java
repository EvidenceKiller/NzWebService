package com.adl.service.callback;

import android.app.Dialog;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.adl.web.service.R;

public class LoadingDialog extends Dialog {

    private TextView contentTv;
    private ImageView icon;

    public LoadingDialog(Context context) {
        super(context, R.style._NoTitleDialog);
        setContentView(R.layout.dialog_request);
        contentTv = findViewById(R.id.content_tv);
        icon = findViewById(R.id.icon);
    }

    public void showText(String text) {
        if (text != null) contentTv.setText(text);
        Animation animation = AnimationUtils.loadAnimation(getContext(),
                R.anim.rotate_1);
        icon.startAnimation(animation);
        show();
    }
}
