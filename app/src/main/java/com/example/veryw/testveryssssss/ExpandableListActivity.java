package com.example.veryw.testveryssssss;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.veryw.testveryssssss.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpandableListActivity extends BaseActivity {

    //组视图数据
    String[] parents={"三国人物","水浒人物","西游人物"};
    //子视图数据
    String[][] children={
            {"曹操","孙权","刘备"},{"宋江","吴用","高俅","林冲"},{"孙悟空","红孩儿","哪吒"}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);
        ButterKnife.bind(this);
        ExpandableListView listView= (ExpandableListView) findViewById(R.id.mylistview);
        listView.setAdapter(new Myadapter());
    }


    //自定义adapter
    class Myadapter extends BaseExpandableListAdapter {

        @Override
        //组数
        public int getGroupCount() {

            return parents.length;
        }

        @Override
        //每组的子数
        public int getChildrenCount(int groupPosition) {

            return children[groupPosition].length;
        }

        @Override
        //返回对应的组
        public Object getGroup(int groupPosition) {

            return parents[groupPosition];
        }

        @Override
        //返回对应的子
        public Object getChild(int groupPosition, int childPosition) {

            return children[groupPosition][childPosition];
        }

        @Override
        //返回组id
        public long getGroupId(int groupPosition) {

            return groupPosition;
        }

        @Override
        //返回子id
        public long getChildId(int groupPosition, int childPosition) {

            return childPosition;
        }

        @Override
        public boolean hasStableIds() {

            return true;
        }

        @Override
        //返回组试图
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            TextView view;
            if(convertView!=null){
                view=(TextView) convertView;
            }else{
                view =new TextView(ExpandableListActivity.this);
            }
            view.setText(parents[groupPosition]);
            view.setBackgroundColor(Color.RED);
            return view;
        }

        @Override
        //返回子试图
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {

            TextView view;
            if(convertView!=null){
                view=(TextView) convertView;
            }
            else{
                view =new TextView(ExpandableListActivity.this);
            }
            view.setText(children[groupPosition][childPosition]);
            return view;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {

            return true;
        }

    }
}
