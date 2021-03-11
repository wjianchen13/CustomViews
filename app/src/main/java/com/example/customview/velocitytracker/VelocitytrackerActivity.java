package com.example.customview.velocitytracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

public class VelocitytrackerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocitytracker);
    }

    /**
     * 临时测试
     * @param
     * @return
     */
    public void onTemp(View v) {

    }

    /**
     * 基础测试
     * @param
     * @return
     */
    public void onBase(View v) {
        Intent it = new Intent();
        it.setClass(VelocitytrackerActivity.this, VelocitytrackerBaseActivity.class);
        startActivity(it);
    }
}
