package com.example.customview.dynamic_add;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.customview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态添加view
 */
public class DynamicAddView extends LinearLayout {

    private List<String> title = new ArrayList<>();

    private TextView[] tvArr;

    public DynamicAddView(Context context) {
        super(context);
        initView();
    }

    public DynamicAddView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DynamicAddView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        title.add("Recently");
        title.add("Join");
        title.add("Follow");
        tvArr = new TextView[title.size()];

        for(int i = 0; i < title.size(); i ++) {
            TextView tv = addLabelItem(title.get(i));
            tvArr[i] = tv;
        }
    }

    private TextView addLabelItem(String title) {
        final TextView tv = new TextView(getContext());
        tv.setSingleLine();
        tv.setLines(1);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 52);
        param.gravity = Gravity.CENTER_VERTICAL;
        param.leftMargin = 10;
        param.rightMargin = 10;
        tv.setGravity(Gravity.CENTER);
        tv.setLayoutParams(param);
        tv.setIncludeFontPadding(false);
        tv.setTextColor(ContextCompat.getColorStateList(getContext(), R.color.color_dynamic_add_textview));
        tv.setTextSize(11);
        tv.setPadding(25, 5, 25, 5);
        addView(tv);
        tv.setText(title);
        tv.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_dynamic_add_textview));
        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                tv.setSelected(true);
            }
        });
        return tv;
    }

    private void reset() {
        for(int i = 0; i < tvArr.length; i ++) {
            tvArr[i].setSelected(false);
        }
    }

}
