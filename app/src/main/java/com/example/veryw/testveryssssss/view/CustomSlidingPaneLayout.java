package com.example.veryw.testveryssssss.view;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * des ：
 * created by ：wuchangbin
 * created on：2017/3/13 13:02
 */
public class CustomSlidingPaneLayout extends SlidingPaneLayout {


    private Context mContext;
    private float mInitialMotionX;
    private float mEdgeSlop;

    public CustomSlidingPaneLayout(Context context) {
        this(context, null);
    }

    public CustomSlidingPaneLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomSlidingPaneLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        ViewConfiguration config = ViewConfiguration.get(mContext);
        mEdgeSlop = config.getScaledEdgeSlop();
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            switch (MotionEventCompat.getActionMasked(ev)){
                case MotionEvent.ACTION_DOWN: {
                    mInitialMotionX = ev.getX();
                    break;
                }
                case MotionEvent.ACTION_MOVE:
                    //主要是为了解决视频全屏播放时,屏蔽侧滑退出的事件冲突
                    if(mContext.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                        return false;
                    }
                    //主要是为了解决和viewPager的冲突,主要是TouchEvent被SlidingPaneLayout消费了,viewPager接受不到,导致无法左右滑动,
                    float x = ev.getX();
                    float y = ev.getY();
                    if (mInitialMotionX > mEdgeSlop && !isOpen() && canScroll(this, false, Math.round(x - mInitialMotionX), Math.round(x), Math.round(y))) {
                        MotionEvent cancelEvent = MotionEvent.obtain(ev);
                        cancelEvent.setAction(MotionEvent.ACTION_CANCEL);
                        return super.onInterceptTouchEvent(cancelEvent);
                    }
            }
            return super.onInterceptTouchEvent(ev);
        } catch (Exception e) {
            e.printStackTrace();
            return  false;
        }
    }




}