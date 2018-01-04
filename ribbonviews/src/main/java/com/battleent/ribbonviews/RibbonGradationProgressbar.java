package com.battleent.ribbonviews;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.ProgressBar;

/**
 * Created by skydoves on 2017. 11. 24.
 * Copyright (c) 2017 battleent rights reserved.
 */

public class RibbonGradationProgressbar extends ProgressBar {

    private String label;
    private Paint labelPaint;

    public RibbonGradationProgressbar(Context context) {
        super(context);
        onCreate();
    }

    public RibbonGradationProgressbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        onCreate();
        getAttrs(attrs);
    }

    public RibbonGradationProgressbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onCreate();
        getAttrs(attrs, defStyleAttr);
    }

    private void onCreate() {
        label = "50%";
        labelPaint = new Paint();
        labelPaint.setColor(Color.WHITE);
        labelPaint.setTextSize(getSpTextSize(12));
    }

    private void getAttrs(AttributeSet attributeSet) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.RibbonCoverLayout);
        try {
            setTypeArray(typedArray);
        } finally {
            typedArray.recycle();
        }
    }

    private void getAttrs(AttributeSet attributeSet, int defStyleAttr) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.RibbonCoverLayout);
        try {
            setTypeArray(typedArray);
        } finally {
            typedArray.recycle();
        }
    }

    private void setTypeArray(TypedArray typeArray) {
    }

    private float getSpTextSize(int size) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, size, getResources().getDisplayMetrics());
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int threshHold = 10;

        Rect bound = new Rect();
        labelPaint.getTextBounds(label, 0, label.length(), bound);

        float progressWidth = (float)getProgress() * ((float)getWidth() / 100);
        if(bound.width() + dpToPx(threshHold)*2 < progressWidth) {
            labelPaint.setColor(Color.WHITE);
            labelPaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
            float x = progressWidth - bound.width() - dpToPx(threshHold);
            int y = getHeight() / 2 - bound.centerY();
            canvas.drawText(label, x, y, labelPaint);
        } else {
            labelPaint.setColor(Color.BLACK);
            float x = progressWidth + dpToPx(threshHold);
            int y = getHeight() / 2 - bound.centerY();
            canvas.drawText(label, x, y, labelPaint);
        }
    }

    public void setLabel(String label) {
        this.label = label;
        drawableStateChanged();
    }

    public static float dpToPx(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * (metrics.densityDpi / 160f);
    }
}
