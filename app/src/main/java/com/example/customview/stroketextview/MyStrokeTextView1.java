package com.example.customview.stroketextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.example.customview.R;

public class MyStrokeTextView1 extends AppCompatTextView {

    private int mStrokeColor =  Color.BLACK;       //描边颜色
    private int mStrokeWidth = 0;       //描边宽度
    private int mFontType=-1;
    private Paint mPaint ;      //画笔

    public MyStrokeTextView1(Context context) {
        super(context);
        init(context, null);
    }

    public MyStrokeTextView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MyStrokeTextView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }
    private void init(Context context, AttributeSet attrs) {
        mPaint = getPaint();
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CenterStrokeTextView);
            mStrokeColor = a.getColor(R.styleable.CenterStrokeTextView_stroke_color, Color.BLACK);
            mStrokeWidth = a.getDimensionPixelSize(R.styleable.CenterStrokeTextView_stroke_width, 0);
            mFontType = a.getInt(R.styleable.CenterStrokeTextView_font_type, -1);
            switch (mFontType){
                case 1:
                    mPaint.setTypeface(FontUtils.getTypeFace(getContext(), FontUtils.FontType.DIN_MITTELSCHRIFT_ALTERNATE));
                    break;
                case 2:
                    mPaint.setTypeface(FontUtils.getTypeFace(getContext(), FontUtils.FontType.REFRIGERATOR_DELUXE_HEAVY));
                    break;
                default:
            }
            a.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

//        setMeasuredDimension(getMeasuredWidth() + mStrokeWidth,getMeasuredHeight() + mStrokeWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
