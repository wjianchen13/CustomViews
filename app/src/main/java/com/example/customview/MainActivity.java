package com.example.customview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.check.CheckActivity;
import com.example.customview.textview.TextViewActivity;
import com.example.customview.velocitytracker.VelocitytrackerActivity;
import com.example.customview.viewdraghelper.ViewDragHelperActivity;
import com.example.customview.viewpager.ViewPagerActivity;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onViewPager(View v) {
        startActivity(new Intent(this, ViewPagerActivity.class));
    }

    public void onViewDragHelper(View v) {
        startActivity(new Intent(this, ViewDragHelperActivity.class));
    }

    public void onVelocitytracker(View v) {
        startActivity(new Intent(this, VelocitytrackerActivity.class));
    }
    
    public void onCheck(View v) {
        startActivity(new Intent(this, CheckActivity.class));
    }

    public void onText(View v) {
        startActivity(new Intent(this, TextViewActivity.class));
    }
    
}