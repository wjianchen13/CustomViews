package com.example.customview.viewdraghelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.customview.viewdraghelper.base.BaseActivity;
import com.example.customview.viewdraghelper.temp.TempActivity;


public class ViewDragHelperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdraghelper);
    }

    /**
     * 临时测试
     * @param
     * @return
     */
    public void onTemp(View v) {
        Intent it = new Intent();
        it.setClass(ViewDragHelperActivity.this, TempActivity.class);
        startActivity(it);
    }

    /**
     * 基础测试
     * @param
     * @return
     */
    public void onBase(View v) {
        Intent it = new Intent();
        it.setClass(ViewDragHelperActivity.this, BaseActivity.class);
        startActivity(it);
    }

}
