package com.example.veryw.testveryssssss;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

import com.example.veryw.testveryssssss.base.BaseActivity;
import com.example.veryw.testveryssssss.fly.MainGame;
import com.example.veryw.testveryssssss.fly.touch;

public class FlyStartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Init();

    }
    public void Init() {
        WindowManager wm = this.getWindowManager();
        Display display = wm.getDefaultDisplay();
        MainGame gameView = new MainGame(this, display);
        gameView.setOnTouchListener(new touch());
        gameView.setBackgroundColor(Color.BLACK);
        this.setContentView(gameView);
    }
}
