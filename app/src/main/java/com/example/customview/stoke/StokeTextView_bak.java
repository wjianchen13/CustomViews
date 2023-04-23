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

import com.example.customview.R;

public class StokeTextView_bak extends androidx.appcompat.widget.AppCompatTextView {

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

    public StokeTextView_bak(Context context) {
        super(context);
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

    public StokeTextView_bak(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
    }

    public StokeTextView_bak(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
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
                mLinearGradient = new LinearGradient(0, 0, 0,
                        getMeasuredHeight() ,
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
