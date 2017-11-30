package com.example.veryw.testveryssssss;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.example.veryw.testveryssssss.view.CustomSlidingPaneLayout;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * des ：
 * created by ：wuchangbin
 * created on：2017/3/10 18:02
 */
public class SwipeBackBySystemActivity extends AppCompatActivity implements SlidingPaneLayout.PanelSlideListener {

    private boolean whiteBack=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initSwipeBackFinish();
        super.onCreate(savedInstanceState);
    }

    /**
     * 初始化滑动返回
     */
    private void initSwipeBackFinish() {
        if (supportSlideBack()) {
            CustomSlidingPaneLayout slidingPaneLayout = new CustomSlidingPaneLayout(this);

            try {
                //通过反射改变mOverhangSize的值为0，这个mOverhangSize值为菜单到右边屏幕的最短距离，默认是32dp，现在给它改成0
                Field f_overhangSize = SlidingPaneLayout.class.getDeclaredField("mOverhangSize");
                f_overhangSize.setAccessible(true);
                f_overhangSize.set(slidingPaneLayout, 0);

            } catch (Exception e) {
                e.printStackTrace();
            }

            slidingPaneLayout.setPanelSlideListener(this);
            slidingPaneLayout.setSliderFadeColor(getResources().getColor(android.R.color.transparent));

            View leftView = new View(this);
            leftView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            slidingPaneLayout.addView(leftView, 0);

            ViewGroup decor = (ViewGroup) getWindow().getDecorView();
            ViewGroup decorChild = (ViewGroup) decor.getChildAt(0);
            if(whiteBack){
                decorChild.setBackgroundColor(getResources().getColor(android.R.color.white));
            }else {
                decorChild.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            }
            decor.removeView(decorChild);
            decor.addView(slidingPaneLayout);
            slidingPaneLayout.addView(decorChild, 1);
        }
    }



    /**
     * 图集上滑需要动态改变视图背景，所以需要设置透明背景
     * @param whiteBack
     */
    public void setWhiteBack(boolean whiteBack) {
        this.whiteBack = whiteBack;
    }



    /**
     * 是否支持滑动返回
     */
    protected boolean supportSlideBack() {
        return true;
    }


    @Override
    public void onPanelClosed(View view) {

    }

    @Override
    public void onPanelOpened(View view) {
        finish();
        this.overridePendingTransition(0, R.anim.slide_out_right);
    }

    @Override
    public void onPanelSlide(View view, float  slideOffset) {
        //项目要求滑动距离超过屏幕1/3时就finish,经过测试发现slideOffset在[0,1]之间,这边暂时通过这种方式实现,
        if(slideOffset > (float)1/3){
            onPanelOpened(view);
        }
    }

}