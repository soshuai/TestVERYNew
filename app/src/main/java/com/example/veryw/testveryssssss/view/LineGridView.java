package com.example.veryw.testveryssssss.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.example.veryw.testveryssssss.R;


public class LineGridView extends GridView {
    public LineGridView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
 
    public LineGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
 
    public LineGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
 
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        View localView1 = getChildAt(0);
        int column = getWidth() / localView1.getWidth();//计算出一共有多少列
//        Log.i("uuuu","column="+column);
//        Log.i("uuuu","getNumColumns()="+getNumColumns());
        int childCount = getChildCount();//子view的总数
        System.out.println("子view的总数childCount==" + childCount);
        Paint localPaint;//画笔
        localPaint = new Paint();
        localPaint.setStyle(Paint.Style.STROKE);
        localPaint.setColor(getContext().getResources().getColor(R.color.lanmu_read));//设置画笔的颜色
        for (int i = 0; i < childCount; i++) {//遍历子view
            //TODO 注意 从零开始
            View cellView = getChildAt(i);//获取子view
            if (i < column) {//第一行
                canvas.drawLine(cellView.getLeft(), cellView.getTop(), cellView.getRight(), cellView.getTop(), localPaint);
            }
            if (i % column == 0) {//第一列
                canvas.drawLine(cellView.getLeft(), cellView.getTop(), cellView.getLeft(), cellView.getBottom(), localPaint);
            }
            if ((i + 1) % column == 0) {//第三列
                //画子view底部横线
                canvas.drawLine(cellView.getLeft(), cellView.getBottom(), cellView.getRight(), cellView.getBottom(), localPaint);
                canvas.drawLine(cellView.getRight(), cellView.getTop(), cellView.getRight(), cellView.getBottom(), localPaint);
            } else if ((i + 1) > (childCount - (childCount % column))) {//如果view是最后一行
                //画子view的右边竖线
                canvas.drawLine(cellView.getRight(), cellView.getTop(), cellView.getRight(), cellView.getBottom(), localPaint);
                canvas.drawLine(cellView.getLeft(), cellView.getBottom(), cellView.getRight(), cellView.getBottom(), localPaint);
            } else {//如果view不是最后一行
                //画子view的右边竖线
                canvas.drawLine(cellView.getRight(), cellView.getTop(), cellView.getRight(), cellView.getBottom(), localPaint);
                //画子view的底部横线
                canvas.drawLine(cellView.getLeft(), cellView.getBottom(), cellView.getRight(), cellView.getBottom(), localPaint);
            }


        }
    }
}
