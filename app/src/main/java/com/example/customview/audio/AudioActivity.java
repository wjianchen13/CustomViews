package com.example.customview.audio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.customview.audio.base.BaseActivity;
import com.example.customview.audio.drawabletest.DrawableActivity;
import com.example.customview.audio.test.TestActivity;

import java.util.Random;

public class AudioActivity extends AppCompatActivity {

    private Random mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
    }

    /**
     * 基础使用
     * @param
     * @return
     */
    public void onBase(View v) {
        Intent it1 = new Intent();
        it1.setClass(AudioActivity.this, BaseActivity.class);
        startActivity(it1);
    }

    /**
     * 性能测试
     * @param
     * @return
     */
    public void onTest(View v) {
        Intent it1 = new Intent();
        it1.setClass(AudioActivity.this, TestActivity.class);
        startActivity(it1);
    }

    /**
     * drawable性能测试，和上面实现方式不一样
     * @param
     * @return
     */
    public void onBtn(View v) {
        Intent it1 = new Intent();
        it1.setClass(AudioActivity.this, DrawableActivity.class);
        startActivity(it1);
    }

}
