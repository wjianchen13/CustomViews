package com.example.customview.progress2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

public class Progress2Activity extends AppCompatActivity {

    private ProgressView mProgressView;
    private Button test;
    private int value;
    CircularRingPercentageView progressCircle;
//    private Random random = new Random(System.currentTimeMillis());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress2);

        mProgressView = (ProgressView)findViewById(R.id.my_progress);
        test = (Button)findViewById(R.id.btn_add);
        mProgressView.setMaxCount(100.0f);
        value = 1;
        mProgressView.setCurrentCount(value);
        mProgressView.setScore(value);
        test.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                value ++;
                mProgressView.setCurrentCount(value);
                mProgressView.setScore(value);
            }
        });

        progressCircle = findViewById(R.id.progress);


        progressCircle.setProgress(100, new CircularRingPercentageView.OnProgressScore() {
            @Override
            public void setProgressScore(float score) {
                Log.e("12", score + "");
            }
        });
    }



    public void ondec(View v) {
        progressCircle.setProgress(10);
    }

}
