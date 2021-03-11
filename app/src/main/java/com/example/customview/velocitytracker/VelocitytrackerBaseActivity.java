package com.example.customview.velocitytracker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;


public class VelocitytrackerBaseActivity extends AppCompatActivity {

    private TestVelocityView tvvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocitytracker_base);
        tvvTest = (TestVelocityView) findViewById(R.id.tvv_test);
        tvvTest.setListener(new TestVelocityView.GetVelocityListener(){
            @Override
            public void get(int x, int y) {
                System.out.println("======================> x: " + x + "   y: " + y);
            }
        });
    }



}
