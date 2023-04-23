package com.example.customview.stoke;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.customview.R;

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
    private ImageView imgvTest;
    private LinearLayout llytTest;
    private StokeTextView tvTest3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stoke_textview);
        tvTest = findViewById(R.id.tv_test);
        tvTest1 = findViewById(R.id.tv_test1);
        tvTest3 = findViewById(R.id.tv_test3);
        imgvTest = findViewById(R.id.imgv_test);
        llytTest = findViewById(R.id.llyt_test);
        tvTest1.setShadowLayer(8,0,0, Color.BLUE);
    }

    public void onTest1(View v) {
//        tvTest.setDrawingCacheEnabled(true);
//        tvTest.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
//        tvTest.layout(0, 0, tvTest.getMeasuredWidth(), tvTest.getMeasuredHeight());
//        Bitmap bitmap = tvTest.getDrawingCache();
//        imgvTest.setBackground(new BitmapDrawable(getResources(), bitmap));

    }

    /**
     * 从TextView生成一张bitmap并显示出来
     * @param v
     */
    public void onTest2(View v) {
        imgvTest.setBackground(createDefaultDrawable(this, "12:45"));
    }

    /**
     * 跳转到具体demo使用例子，可以查看效果
     * @param v
     */
    public void onTest3(View v) {
//        tvTest3.setLevel();
//        tvTest3.setText("HELLO");
        startActivity(new Intent(this, StokeTextDemoActivity.class));
    }

    private @NonNull
    Drawable createDefaultDrawable(Context context, String name){
        StokeTextView_bak emTextView = new StokeTextView_bak(context);
        emTextView.setDrawingCacheEnabled(true);
        int textSize = 28;
        emTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);

        emTextView.setGravity(Gravity.CENTER);
        emTextView.setIncludeFontPadding(false);
        emTextView.setText(name);

        emTextView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
                , View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

        emTextView.layout(0, 0, emTextView.getMeasuredWidth(), emTextView.getMeasuredHeight());
        Bitmap levelCache = Bitmap.createBitmap(emTextView.getDrawingCache(), 0, 0, emTextView.getMeasuredWidth(), emTextView.getMeasuredHeight());
        emTextView.setDrawingCacheEnabled(false);
        emTextView.destroyDrawingCache();

        return new BitmapDrawable(context.getResources(), levelCache);
    }
    
}
