package com.example.customview.progress2;

/**
 * Created by Administrator on 2018/9/20.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.customview.R;

public class TestView extends View {

    private SweepGradient mSweepGradient;
    private Paint mPaint;
    private int strokeWidth;
    private int mWidth, mHeight;
    private int[] colors = {0xfff9668c, 0xfffff4ac};
//private int[] colors = {0xffff4639, 0xffCDD513, 0xff3CDF5F};
    public TestView(Context context) {
        this(context, null);
    }

    public TestView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.TestView);
        strokeWidth = mTypedArray.getDimensionPixelOffset(R.styleable.TestView_tv_stroke_width, getDpValue(10));
        mWidth = mTypedArray.getLayoutDimension(R.styleable.TestView_android_layout_width, 0);
        mHeight = mTypedArray.getLayoutDimension(R.styleable.TestView_android_layout_height, 0);
        mTypedArray.recycle();


        initPaint();
        sweepGradientInit();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth((float) 40.0);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setColor(Color.RED);
    }

    /**
     * 渐变初始化
     */
    public void sweepGradientInit() {
        //渐变颜色
        mSweepGradient = new SweepGradient(this.mWidth / 2, this.mHeight / 2, colors, null);
        //旋转 不然是从0度开始渐变
        Matrix matrix = new Matrix();
        matrix.setRotate(110, this.mWidth / 2, this.mHeight / 2);
        mSweepGradient.setLocalMatrix(matrix);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthSpecMode == MeasureSpec.EXACTLY
                || widthSpecMode == MeasureSpec.AT_MOST) {
            mWidth = widthSpecSize;
        } else {
            mWidth = 0;
        }
        if (heightSpecMode == MeasureSpec.AT_MOST
                || heightSpecMode == MeasureSpec.UNSPECIFIED) {
            mHeight = getDpValue(15);
        } else {
            mHeight = heightSpecSize;
        }
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.save();// 保存当前画布
        RectF rectBlackBg = new RectF(strokeWidth, strokeWidth, mWidth - strokeWidth, mHeight - strokeWidth);
//        canvas.rotate(120, mWidth / 2, mHeight / 2);
        canvas.drawArc(rectBlackBg, -240, 300, false, mPaint);
//        canvas.restore();

        RectF oval = new RectF(strokeWidth, strokeWidth, mWidth - strokeWidth, mHeight - strokeWidth);
        //背景渐变颜色
        mPaint.setShader(mSweepGradient);
        canvas.drawArc(oval, 120, 300, false, mPaint);
        mPaint.setShader(null);

    }



    private int getDpValue(int w) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, w, getContext().getResources().getDisplayMetrics());
    }

}