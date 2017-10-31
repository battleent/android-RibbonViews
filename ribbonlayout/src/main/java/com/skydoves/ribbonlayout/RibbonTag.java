package com.skydoves.ribbonlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by skydoves on 2017. 10. 31.
 * Copyright (c) 2017 battleent rights reserved.
 */

public class RibbonTag extends RelativeLayout {

    private TextView ribbonTag;

    private String tag_text = "";
    private int tag_textColor = Color.WHITE;
    private int tag_textSize = 11;
    private int ribbonColor = getContext().getResources().getColor(R.color.bright_lavender);
    private int ribbonRadius= 10;
    private int padding_left = 6;
    private int padding_top = 4;
    private int padding_right = 6;
    private int padding_bottom = 4;

    public RibbonTag(Context context) {
        super(context);
        onCreate();
    }

    public RibbonTag(Context context, AttributeSet attrs) {
        super(context, attrs);
        onCreate();
    }

    public RibbonTag(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onCreate();
    }

    private void onCreate() {
        ribbonTag = new TextView(getContext());
        ribbonTag.setBackgroundResource(R.drawable.rectangle_layout);
    }

    private void getAttrs(AttributeSet attributeSet) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.RibbonTag);
        try {
            setTypeArray(typedArray);
        } finally {
            typedArray.recycle();
        }
    }

    private void getAttrs(AttributeSet attributeSet, int defStyleAttr) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.RibbonTag, defStyleAttr, 0);
        try {
            setTypeArray(typedArray);
        } finally {
            typedArray.recycle();
        }
    }

    private void setTypeArray(TypedArray typeArray) {
        tag_text = typeArray.getString(R.styleable.RibbonTag_tag_text);
        tag_textSize = typeArray.getInt(R.styleable.RibbonTag_tag_textSize, tag_textSize);
        tag_textColor = typeArray.getColor(R.styleable.RibbonTag_tag_textColor, tag_textColor);
        ribbonColor = typeArray.getColor(R.styleable.RibbonTag_tag_ribbonColor, ribbonColor);
        ribbonRadius = typeArray.getInt(R.styleable.RibbonTag_tag_ribbonRadius, ribbonRadius);
        padding_left = typeArray.getInt(R.styleable.RibbonTag_tag_padding_left, padding_left);
        padding_top = typeArray.getInt(R.styleable.RibbonTag_tag_padding_top, padding_top);
        padding_right = typeArray.getInt(R.styleable.RibbonTag_tag_padding_right, padding_right);
        padding_bottom = typeArray.getInt(R.styleable.RibbonTag_tag_padding_bottom, padding_bottom);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        createRibbonTag();
    }

    private void createRibbonTag() {
        ribbonTag.setText(tag_text);
        ribbonTag.setTextSize(tag_textSize);
        ribbonTag.setTextColor(tag_textColor);
        ribbonTag.setPadding(padding_left, padding_top, padding_right, padding_bottom);
        GradientDrawable bgShape = (GradientDrawable)ribbonTag.getBackground();
        bgShape.setCornerRadius(ribbonRadius);
        bgShape.setColor(ribbonColor);
        addView(ribbonTag);
    }

    public void setTagText(String text) {
        this.tag_text = text;
    }

    public void setTagTextColor(int color) {
        this.ribbonTag.setTextColor(color);
    }

    public void setRibbonColor(int color) {
        this.ribbonColor = color;
        GradientDrawable bgShape = (GradientDrawable)ribbonTag.getBackground();
        bgShape.setColor(color);
    }
}
