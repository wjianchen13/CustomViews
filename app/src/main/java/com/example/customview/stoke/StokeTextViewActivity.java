package com.example.customview.stoke;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;
import com.example.customview.textview.MyTextView;

/**
 * TextView描边、渐变、阴影效果
 * https://blog.csdn.net/qq_21154101/article/details/103043829
 * android textview外发光,android TextView描边
 * https://blog.csdn.net/weixin_39575007/article/details/117581340?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-5-117581340-blog-103043829.235^v28^pc_relevant_default&spm=1001.2101.3001.4242.4&utm_relevant_index=8
 * 外发光、内发光、描边、阴影的TextView
 * https://blog.csdn.net/iteye_563/article/details/82518328?spm=1001.2101.3001.6650.2&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-2-82518328-blog-117581340.235%5Ev28%5Epc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-2-82518328-blog-117581340.235%5Ev28%5Epc_relevant_default&utm_relevant_index=5
 *
 */
public class StokeTextViewActivity extends AppCompatActivity {
    
    private StokeTextView tvTest;
    private StrokeTextView1 tvTest1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stoke_textview);
        tvTest = findViewById(R.id.tv_test);
        tvTest1 = findViewById(R.id.tv_test1);
        tvTest1.setShadowLayer(8,0,0, Color.BLUE);
    }

    public void onTest1(View v) {
        
        
    }

    public void onTest2(View v) {


    }
    
}
