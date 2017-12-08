package com.example.veryw.testveryssssss;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.veryw.testveryssssss.base.BaseActivity;
import com.hiar.sdk.ARFragment;


public class ARActivity extends BaseActivity {

    private ARFragment mARFragment;
//    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);

        mARFragment = new ARFragment();
        mARFragment.showBottomMuenu(false);
        mARFragment.setDefaultVideoLooping(true);
        getFragmentManager().beginTransaction().add(R.id.container,mARFragment).commit();
    }

    @Override
    public void onBackPressed() {
        if(!mARFragment.handleBack()){
            super.onBackPressed();
        }
    }
}
