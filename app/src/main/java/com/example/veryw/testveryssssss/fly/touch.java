package com.example.veryw.testveryssssss.fly;

import android.view.MotionEvent;
import android.view.View;

public class touch implements View.OnTouchListener {//触摸监听事件

    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            MainGame.isdown = true;
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            MainGame.isdown = false;
        }
        MainGame.Point_x = (int) event.getRawX();
        MainGame.Point_y = (int) event.getRawY();
        return true;
    }
}