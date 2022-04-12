package com.example.customview.swipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.customview.swipe.customviewpager.CustomViewPagerActivity;
import com.example.customview.swipe.recyclerview.RecyclerViewActivity;
import com.example.customview.swipe.refresh.RefreshActivity;
import com.example.customview.swipe.viewpager.ViewpagerActivity;

public class SwipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_main);
    }

    /**
     * Recyclerview
     * @param
     * @return
     */
    public void onRecyclerView(View v) {
        Intent it = new Intent();
        it.setClass(SwipeActivity.this, RecyclerViewActivity.class);
        startActivity(it);
    }

    /**
     * Refresh
     * @param
     * @return
     */
    public void onRefresh(View v) {
        Intent it = new Intent();
        it.setClass(SwipeActivity.this, RefreshActivity.class);
        startActivity(it);
    }

    /**
     * Viewpager
     * @param
     * @return
     */
    public void onViewpager(View v) {
        Intent it = new Intent();
        it.setClass(SwipeActivity.this, ViewpagerActivity.class);
        startActivity(it);
    }

    /**
     * 自定义Viewpager，分析viewpager实现原理
     * @param
     * @return
     */
    public void onCustomViewpager(View v) {
        Intent it = new Intent();
        it.setClass(SwipeActivity.this, CustomViewPagerActivity.class);
        startActivity(it);
    }

}
