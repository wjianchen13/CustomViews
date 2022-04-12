package com.example.customview.audio.base;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.customview.audio.widget.AudioView;

public class BaseActivity extends AppCompatActivity {

    private AudioView audioView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_base);
        audioView = (AudioView) findViewById(R.id.av_test);
    }

    /**
     * 开始动画
     * @param
     * @return
     */
    public void onStart(View v) {
//        if (!audioView.isStart()) {
            //开始跳动
            audioView.start();
//        }
//        audioView.setVisibility(View.VISIBLE);
    }

    /**
     * 停止动画
     * @param
     * @return
     */
    public void onEnd(View v) {
//        if (audioView.isStart()) {
//            //结束跳动
//            audioView.stop();
//        }
        if(audioView.getVisibility() == View.VISIBLE) {
            audioView.setVisibility(View.GONE);
        } else if(audioView.getVisibility() == View.GONE) {
            audioView.setVisibility(View.VISIBLE);
        }

    }
}
