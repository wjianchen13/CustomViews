package com.example.customview.textview;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

public class TextViewActivity extends AppCompatActivity {
    
    private MyTextView tvTest;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        tvTest = findViewById(R.id.tv_test);
        TextLine tl;
    }

    public void onTest1(View v) {
        
        
    }

    public void onTest2(View v) {


    }
    
}
