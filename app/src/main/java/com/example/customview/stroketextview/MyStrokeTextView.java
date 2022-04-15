package com.example.customview.stroketextview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;

import androidx.appcompat.widget.AppCompatTextView;

import com.example.customview.R;

public class MyStrokeTextView extends AppCompatTextView {

    private int mStrokeColor =  Color.BLACK;       //描边颜色
    private int mStrokeWidth = 0;       //描边宽度
    private int mFontType=-1;
    private Paint mPaint ;      //画笔
    private boolean isBold; // 是否粗体

    public MyStrokeTextView(Context context) {
        super(context);
        init(context, null);
    }

    public MyStrokeTextView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MyStrokeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
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
            isBold = a.getBoolean(R.styleable.CenterStrokeTextView_stroke_bold, false);
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

        setMeasuredDimension(getMeasuredWidth() + mStrokeWidth,getMeasuredHeight() + mStrokeWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final ColorStateList currentColor = getTextColors();
        mPaint.setFakeBoldText(isBold);   //设置粗体
        mPaint.setStyle(Paint.Style.STROKE);
        //设置结合处
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(mStrokeWidth);
        setTextColor(mStrokeColor);
        setGravity(Gravity.CENTER);
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL);
        setTextColor(currentColor);
        setGravity(Gravity.CENTER);     //Gravity.CENTER主要是避免该字体下移导致左右部分被截断
        super.onDraw(canvas);
    }
}
