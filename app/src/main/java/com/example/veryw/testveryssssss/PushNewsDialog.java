package com.example.veryw.testveryssssss;

import com.example.veryw.testveryssssss.base.BaseActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class PushNewsDialog extends BaseActivity implements OnClickListener {
    private TextView tvContent;
    private TextView tvCancel;
    private TextView tvLook;
    
    private int id;
    private String contentUrl;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_show_news);

        String title="title";

        /**
         * 设置界面的大小
         */
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay(); // 为获取屏幕宽、高
        android.view.WindowManager.LayoutParams p = getWindow().getAttributes();

        p.width = (int) (d.getWidth() * 0.7); // 宽度设置为屏幕
        p.height = (int) (d.getHeight() * 0.3);
        p.alpha = 1.0f;

        getWindow().setAttributes(p);
        getWindow().setBackgroundDrawable(getDrawable(R.drawable.push_shape));
        
        tvContent=(TextView) findViewById(R.id.tv_content);
        tvCancel=(TextView) findViewById(R.id.tv_cancel);
        tvLook=(TextView) findViewById(R.id.tv_look);
        LinearLayout  llBottom=(LinearLayout) findViewById(R.id.ll_dialog);
//        llBottom.getBackground().setAlpha(0);
//        llBottom.setBackground(getDrawable(R.drawable.push_news_dialog));
        
        tvContent.setText(title);
        tvCancel.setOnClickListener(this);
        tvLook.setOnClickListener(this);
        
    }
    @Override
    public void onClick(View v) {
    }
   

}
