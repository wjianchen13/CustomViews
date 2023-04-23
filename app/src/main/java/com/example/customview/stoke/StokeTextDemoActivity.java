package com.example.customview.stoke;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

/**
 * VIP字体例子
 */
public class StokeTextDemoActivity extends AppCompatActivity {
    
    private VipTextView tvTest1;
    private VipTextView tvTest2;
    private VipTextView tvTest3;
    private VipTextView tvTest4;
    private VipTextView tvTest5;
    private VipTextView tvTest6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stoke_text_demo);
        tvTest1 = findViewById(R.id.tv_test1);
        tvTest2 = findViewById(R.id.tv_test2);
        tvTest3 = findViewById(R.id.tv_test3);
        tvTest4 = findViewById(R.id.tv_test4);
        tvTest5 = findViewById(R.id.tv_test5);
        tvTest6 = findViewById(R.id.tv_test6);
        tvTest1.setLevel(1);
        tvTest2.setLevel(2);
        tvTest3.setLevel(3);
        tvTest4.setLevel(4);
        tvTest5.setLevel(5);
        tvTest6.setLevel(6);
    }

    
}
