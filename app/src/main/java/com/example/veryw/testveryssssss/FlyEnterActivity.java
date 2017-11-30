package com.example.veryw.testveryssssss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.veryw.testveryssssss.base.BaseActivity;

public class FlyEnterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fly_enter);
        Button button=(Button)findViewById(R.id.button);
//        Log.i("ttt","||||"+String.format("%tF %tT",new Date(),new Date()));
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent=new Intent(FlyEnterActivity.this,FlyStartActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}
