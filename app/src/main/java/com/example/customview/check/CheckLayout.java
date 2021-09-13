package com.example.customview.check;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 选择某个item
 */
public class CheckLayout extends LinearLayout {
    
    private CallBack mCallBack;
    
    public CheckLayout(Context context) {
        super(context);
    }

    public CheckLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CheckLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setmCallBack(CallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    private void setSelected(int id) {
        for(int i = 0; i < getChildCount(); i ++) {
            getChildAt(i).setSelected(getChildAt(i).getId() == id);
            if(getChildAt(i).getId() == id && mCallBack != null) {
                mCallBack.onSelect(id);
            }
        }
    }
    
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        int count = getChildCount();
        for(int i = 0; i < count; i ++) {
            getChildAt(i).setSelected(i == 0);
            getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setSelected(v.getId());
                }
            });
        }
        
    }
    
    public interface CallBack {
        void onSelect(int id);
    }
    
}
