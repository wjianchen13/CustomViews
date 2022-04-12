package com.example.customview.star;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

public class StarActivity extends AppCompatActivity {
    private StarView mStartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);
        mStartView = (StarView) findViewById(R.id.startview);
        //贝塞尔曲线星星
        mStartView.setStartNum(65);
        mStartView.setDuration(3000);

        mStartView.startAnim();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStartView.cancelAnim();
    }
}
