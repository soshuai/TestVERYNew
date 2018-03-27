package com.example.veryw.testveryssssss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;


public class SearchFileActivity extends AppCompatActivity implements View.OnClickListener{

    private File file;
    private String path;
    private String info;
    private String key; //关键字
    private TextView result; // 显示结果
    private EditText et; // 编辑view
    private Button search_btn; // button view
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_file);
        result = (TextView)findViewById(R.id.TextView_Result);
        et = (EditText)findViewById(R.id.key);
        search_btn = (Button)findViewById(R.id.button_search);
        // file = new File(Environment.getExternalStorageDirectory().getPath());
        file = new File("/sdcard/");
        info = getString(R.string.info);
        search_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        path = "";
        result.setText("");
        key = et.getText().toString();
        BrowserFile(file);
    }

    public void BrowserFile(File fileold) {
        if (key.equals("")) {
            Toast.makeText(this, getString(R.string.pleaseInput), Toast.LENGTH_LONG).show();
        } else {
            search(fileold);
            if (result.getText().equals("")) {
                Toast.makeText(this, getString(R.string.notFound), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void search(File fileold) {
        try{
            File[] files=fileold.listFiles();
            if(files.length>0) {
                for(int j=0;j<files.length;j++) {
                    if(!files[j].isDirectory()) {
                        if(files[j].getName().indexOf(key)> -1) {
                            path += "\n" + files[j].getPath();
                            result.setText(info+path);
                        }
                    } else{
                        this.search(files[j]);
                    }
                }
            }
        } catch(Exception e) {}

    }
}
