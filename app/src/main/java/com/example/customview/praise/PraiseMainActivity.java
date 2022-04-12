package com.example.customview.praise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

public class PraiseMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praise_main);
    }

    /**
     * 双击点赞动画
     * @param
     * @return
     */
    public void onDoublePraise(View v) {
        Intent it = new Intent();
        it.setClass(PraiseMainActivity.this, PraiseActivity.class);
        startActivity(it);
    }

    /**
     * 点赞按钮动画
     * @param
     * @return
     */
    public void onBtnPraise(View v) {
        Intent it = new Intent();
        it.setClass(PraiseMainActivity.this, PraiseBtnActivity.class);
        startActivity(it);
    }
}
