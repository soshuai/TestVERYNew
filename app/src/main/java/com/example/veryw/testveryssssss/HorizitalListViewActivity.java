package com.example.veryw.testveryssssss;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.veryw.testveryssssss.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class HorizitalListViewActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private HorizitalAdapter adapter;
    private List<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizital_list_view);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        data=new ArrayList<>();
        for (int i = 0;i <20; i++) {
            data.add("第"+i+"个");
        }
        adapter=new HorizitalAdapter();
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);//创建默认的线性LayoutManager
        recyclerView.setAdapter(adapter);
        recyclerView.smoothScrollToPosition(10);
        recyclerView.addOnItemTouchListener(new OnRecycleItemClickListener(this, new OnRecycleItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                androidToast("点击了第"+position+"个");
                recyclerView.smoothScrollToPosition(19);
            }

            @Override
            public void onLongClick(View view, int posotion) {

            }
        }));
    }

    class HorizitalAdapter extends RecyclerView.Adapter<HorizitalAdapter.HorizitalViewHolder>{


        @Override
        public HorizitalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            HorizitalViewHolder holder=new HorizitalViewHolder(LayoutInflater.from(HorizitalListViewActivity.this)
                    .inflate(R.layout.horizital_item,parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(HorizitalViewHolder holder, int position) {
            holder.tv.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class HorizitalViewHolder extends RecyclerView.ViewHolder{
            TextView tv;

            public HorizitalViewHolder(View itemView) {
                super(itemView);
                tv= (TextView) itemView.findViewById(R.id.tv);

            }

        }
    }

    static class OnRecycleItemClickListener implements RecyclerView.OnItemTouchListener {
        GestureDetector mGestureDetector;
        private View childView;
        private RecyclerView touchView;

        public OnRecycleItemClickListener(Context context, final OnRecycleItemClickListener.OnItemClickListener mListener) {
            mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent ev) {
                    if (childView != null && mListener != null) {
                        mListener.onItemClick(childView, touchView.getChildPosition(childView));
                    }
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent ev) {
                    if (childView != null && mListener != null) {
                        mListener.onLongClick(childView, touchView.getChildPosition(childView));
                    }
                }
            });
        }

        public interface OnItemClickListener {
            void onItemClick(View view, int position);

            void onLongClick(View view, int posotion);
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            mGestureDetector.onTouchEvent(e);
            childView = rv.findChildViewUnder(e.getX(), e.getY());
            touchView = rv;
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}
