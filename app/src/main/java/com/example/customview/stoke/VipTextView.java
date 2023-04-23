package com.example.customview.stoke;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.customview.R;

public class VipTextView extends androidx.appcompat.widget.AppCompatTextView {

    private Context mContext;
    private int startColor;
    private int endColor;
    private int strokeColor;
    private float strokeWidth;
    private boolean isStroke;
    private boolean isGradient;
    private boolean isVertical;
    private boolean useTypeface;
    private boolean isShadow;
    private int shadowX;
    private int shadowY;
    private int shadowRadius;
    private int shadowColor;
    private TextView backGroundText;
    private LinearGradient mLinearGradient;

    public VipTextView(Context context) {
        super(context);
        this.mContext = context;
        endColor= Color.WHITE;
        isGradient = true;
        isStroke = false;
        isVertical = true;
        isShadow = true;
        shadowColor = Color.BLUE;
        shadowRadius = 8;
        shadowX = 1;
        shadowY = 1;
        startColor = Color.RED;
        useTypeface = false;
        init1(context, null);

    }

    public VipTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initAttrs(context, attrs);
    }

    public VipTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initAttrs(context, attrs);
    }

    public void setLevel(int level) {
        isGradient = true;
        isStroke = false;
        isVertical = true;
        isShadow = true;
        shadowRadius = 8;
        shadowX = 1;
        shadowY = 1;
        useTypeface = false;
        if(level == 1) {
            startColor = ContextCompat.getColor(mContext, R.color.c51cc91);
            endColor= ContextCompat.getColor(mContext, R.color.cbef2f5);
            shadowColor = ContextCompat.getColor(mContext, R.color.c995affd7);
        } else if(level == 2) {
            startColor = ContextCompat.getColor(mContext, R.color.c165cc5);
            endColor= ContextCompat.getColor(mContext, R.color.cbfd5fb);
            shadowColor = ContextCompat.getColor(mContext, R.color.c995585FF);
        } else if(level == 3) {
            startColor = ContextCompat.getColor(mContext, R.color.cff6262);
            endColor= ContextCompat.getColor(mContext, R.color.cffa0b7);
            shadowColor = ContextCompat.getColor(mContext, R.color.c3964ff);
        } else if(level == 4) {
            startColor = ContextCompat.getColor(mContext, R.color.cffa318);
            endColor= ContextCompat.getColor(mContext, R.color.cffdcbc);
            shadowColor = ContextCompat.getColor(mContext, R.color.cffbe54);
        } else if(level == 5) {
            startColor = ContextCompat.getColor(mContext, R.color.c5278ff);
            endColor= ContextCompat.getColor(mContext, R.color.caa8afe);
            shadowColor = ContextCompat.getColor(mContext, R.color.cc854ff);
        } else if(level == 6) {
            startColor = ContextCompat.getColor(mContext, R.color.cff4040);
            endColor= ContextCompat.getColor(mContext, R.color.cffa740);
            shadowColor = ContextCompat.getColor(mContext, R.color.cff6838);
        }
        requestLayout();
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        this.mContext = context;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.GradientTextView);
        startColor = ta.getColor(R.styleable.GradientTextView_startColor, 0xfffff8);
        endColor = ta.getColor(R.styleable.GradientTextView_endColor, 0xffd007);
        strokeColor = ta.getColor(R.styleable.GradientTextView_strokeColor, 0x2a1505);
        strokeWidth = ta.getDimension(R.styleable.GradientTextView_strokeWidth, 0);
        isStroke = ta.getBoolean(R.styleable.GradientTextView_isStroke, false);
        isGradient = ta.getBoolean(R.styleable.GradientTextView_isGradient, false);
        isVertical = ta.getBoolean(R.styleable.GradientTextView_isVertical, true);
        useTypeface = ta.getBoolean(R.styleable.GradientTextView_useTypeface, false);
        isShadow = ta.getBoolean(R.styleable.GradientTextView_isShadow, false);
        shadowX = ta.getInt(R.styleable.GradientTextView_shadowX, 1);
        shadowY = ta.getInt(R.styleable.GradientTextView_shadowY, 1);
        shadowRadius = ta.getInt(R.styleable.GradientTextView_shadowRadius, 1);
        shadowColor = ta.getColor(R.styleable.GradientTextView_shadowColor, 0x0000ff);
        ta.recycle();
        init1(context, attrs);
    }

    private void init1(Context context, AttributeSet attrs) {
        if (isStroke) {
            backGroundText = new TextView(context);
            TextPaint tp1 = backGroundText.getPaint();
            tp1.setStrokeWidth(strokeWidth);
            tp1.setStyle(Paint.Style.STROKE);
            backGroundText.setTextColor(strokeColor);
            backGroundText.setGravity(getGravity());
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        init2();
    }

    private void init2() {

        if (isGradient) {
            if (isVertical) {
                mLinearGradient = new LinearGradient(0, 15, 0,
                        getMeasuredHeight() - 20,
                        startColor,
                        endColor,
                        Shader.TileMode.CLAMP);
            } else {
                mLinearGradient = new LinearGradient(0, 0, this.getWidth(),
                        0,
                        startColor,
                        endColor,
                        Shader.TileMode.CLAMP);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (isShadow) {
            getPaint().setShadowLayer(shadowRadius, shadowX, shadowY, shadowColor);
            getPaint().setShader(null);
            super.onDraw(canvas);

            getPaint().clearShadowLayer();
            getPaint().setShader(mLinearGradient);
            super.onDraw(canvas);
        } else {
            if (isStroke) {
                if (backGroundText != null) {
                    CharSequence tt = backGroundText.getText();
                    if (tt == null || !tt.equals(this.getText())) {
                        backGroundText.setText(getText());
                        this.postInvalidate();
                    }
                }
                backGroundText.draw(canvas);
            }
            if (isGradient) {
                this.getPaint().setShader(mLinearGradient);
            }
        }
        super.onDraw(canvas);
    }
}
