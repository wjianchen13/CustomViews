package com.example.customview.audio2;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.customview.audio2.widget.AVLoadingIndicatorView;

/**
 * Created by Jack Wang on 2016/8/5.
 */

public class IndicatorActivity extends AppCompatActivity {

    private AVLoadingIndicatorView avi;
    private LinearLayout llytTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio2_indicator);

        String indicator=getIntent().getStringExtra("indicator");
        avi= (AVLoadingIndicatorView) findViewById(R.id.avi);
        avi.setIndicator(indicator);

//        String indicator = "LineScaleIndicator";
//        avi= (AVLoadingIndicatorView) findViewById(R.id.avi);
//        avi.setIndicator(indicator);
//        llytTest = (LinearLayout)findViewById(R.id.llyt_test);
//        llytTest.setOnClickListener(null);
    }

    public void hideClick(View view) {
        avi.hide();
        // or avi.smoothToHide();
    }

    public void showClick(View view) {
        avi.show();
        // or avi.smoothToShow();
    }
}
