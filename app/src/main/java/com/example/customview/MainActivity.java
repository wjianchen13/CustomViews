package com.example.customview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.audio.AudioActivity;
import com.example.customview.audio2.Audio2Activity;
import com.example.customview.check.CheckActivity;
import com.example.customview.praise.PraiseMainActivity;
import com.example.customview.progress.ProgressActivity;
import com.example.customview.progress2.Progress2Activity;
import com.example.customview.stroketextview.StrokeActivity;
import com.example.customview.swipe.SwipeActivity;
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

    public void onStroke(View v) {
        startActivity(new Intent(this, StrokeActivity.class));
    }

    public void onAudio(View v) {
        startActivity(new Intent(this, AudioActivity.class));
    }
    
    public void onAudio2(View v) {
        startActivity(new Intent(this, Audio2Activity.class));
    }

    public void onCircleProgress(View v) {
        startActivity(new Intent(this, ProgressActivity.class));
    }

    public void onCircleProgress2(View v) {
        startActivity(new Intent(this, Progress2Activity.class));
    }

    public void onPraise(View v) {
        startActivity(new Intent(this, PraiseMainActivity.class));
    }

    public void onSwipe(View v) {
        startActivity(new Intent(this, SwipeActivity.class));
    }
    
}