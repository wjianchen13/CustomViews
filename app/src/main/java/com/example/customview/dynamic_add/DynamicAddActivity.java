package com.example.customview.dynamic_add;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.customview.star.StarView;

public class DynamicAddActivity extends AppCompatActivity {

    private DynamicAddView dv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_add);
        dv = findViewById(R.id.dv);


    }



}
