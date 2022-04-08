package com.example.customview.stroketextview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

/**
 * 描边TextView，主要解决描边字体靠边被截取描边颜色的问题
 */
public class StrokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroke);
    }
}
