package com.example.customview.velocitytracker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

/**
 * Created by Administrator on 2018/8/19.
 */

public class TestVelocityView extends View {

    //用于回调的接口
    GetVelocityListener listener;
    //追踪速度关键的类。没有这个这篇文章将毫无意义
    VelocityTracker velocityTracker;
    //要画文字或者任何东西都需要的paint
    Paint paint = new Paint();

    public GetVelocityListener getListener() {
        return listener;
    }

    public void setListener(GetVelocityListener listener) {
        this.listener = listener;
    }

    public TestVelocityView(Context context) {
        this(context,null);
    }

    public TestVelocityView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestVelocityView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint.setTextSize(50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //画文字的代码。
        canvas.save();
        paint.setColor(Color.BLACK);
        canvas.drawText("x = "+xVelocity+"y ="+yVelocity,getLeft(),getTop() + 50,paint);
        //画完之后回收一下
        canvas.restore();
    }

    int xVelocity = 0;
    int yVelocity = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //初始化
                velocityTracker = VelocityTracker.obtain();
                break;
            case MotionEvent.ACTION_MOVE:
                //追踪
                velocityTracker.addMovement(event);
                velocityTracker.computeCurrentVelocity(1000);
                xVelocity = (int) velocityTracker.getXVelocity();
                yVelocity = (int) velocityTracker.getYVelocity();

                if (listener != null) {
                    listener.get(xVelocity, yVelocity);
                    //强制刷新一下view，否则不会一直掉onDraw。
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                //回收
                velocityTracker.clear();
                velocityTracker.recycle();
                break;
        }
        return true;
    }

    public interface GetVelocityListener {
        public void get(int x, int y);
    }
}