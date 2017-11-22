package com.example.veryw.testveryssssss.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.veryw.testveryssssss.R;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener{

    public String[] datas = null;
    private RecyclerviewOnItemClickListenr onItemClickListenr;

    public MyAdapter(String[] datas,RecyclerviewOnItemClickListenr onItemClickListenr) {
        this.datas = datas;
        this.onItemClickListenr=onItemClickListenr;
    }

    public static interface RecyclerviewOnItemClickListenr{
            void onclickHaha(View view,int position);
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);

        view.setOnClickListener(this);
        return vh;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mTextView.setText(datas[position]);
        viewHolder.itemView.setTag(position);
    }

    //获取数据的数量
    @Override
    public int getItemCount() {

        return datas.length;

    }

    @Override
    public void onClick(View v) {

        if (onItemClickListenr!=null){
            onItemClickListenr.onclickHaha(v, (Integer) v.getTag());
        }
    }

//自定义的ViewHolder，持有每个Item的的所有界面元素

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public TextView ss;

        public ViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.text);
            ss= (TextView) view.findViewById(R.id.ss);
        }
    }

}
