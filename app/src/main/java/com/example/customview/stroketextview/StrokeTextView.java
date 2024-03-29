package com.example.customview.stroketextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

public class StrokeTextView extends androidx.appcompat.widget.AppCompatTextView {

	private TextView borderText = null;
	private int strokeColor;
	private float strokeWidth = 4;

	public StrokeTextView(Context context) {
		this(context, null);
	}

	public StrokeTextView(Context context, int defStyle) {
		this(context, null, defStyle);
	}

	public StrokeTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public StrokeTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		borderText = new TextView(context, attrs, defStyle);
		strokeColor = Color.parseColor("#f82dcf");
		init();
	}

	public void init() {
		TextPaint textPaint = borderText.getPaint();
		textPaint.setStrokeWidth(strokeWidth);
		textPaint.setStyle(Style.STROKE);
		borderText.setTextColor(strokeColor);
		borderText.setGravity(getGravity());
	}

	public void setStrokeColorAndWidth(int strokeColor, float strokeWidth) {
		this.strokeColor = strokeColor;
		this.strokeWidth = strokeWidth;
		init();
		invalidate();
	}

	public void setStrokeColor(int strokeColor) {
		this.strokeColor = strokeColor;
		init();
		invalidate();
	}

	@Override
	public void setTextSize(float size) {
		super.setTextSize(size);
		borderText.setTextSize(size);
	}

	@Override
	public void setGravity(int gravity) {
		if (borderText != null) {
			borderText.setGravity(gravity);
		}
		super.setGravity(gravity);
	}

	@Override
	public void setBackgroundResource(int resid) {
		super.setBackgroundResource(resid);
		borderText.setBackgroundResource(resid);
	}

	@Override
	public void setLayoutParams(ViewGroup.LayoutParams params) {
		super.setLayoutParams(params);
		borderText.setLayoutParams(params);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		CharSequence tt = borderText.getText();
		if (tt == null || !tt.equals(this.getText())) {
			borderText.setText(getText());
			this.postInvalidate();
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		borderText.measure(widthMeasureSpec, heightMeasureSpec);
	}

	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
		borderText.layout(left, top, right, bottom);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		borderText.draw(canvas);
		super.onDraw(canvas);
	}

}