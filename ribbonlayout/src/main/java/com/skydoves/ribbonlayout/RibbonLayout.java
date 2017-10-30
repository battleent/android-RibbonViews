package com.skydoves.ribbonlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/*
 * Copyright (C) 2017 battleent
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class RibbonLayout extends RelativeLayout {

    private TextView ribbon_bottom;
    private TextView ribbon_header;

    private String header_text = "";
    private int header_textColor = Color.WHITE;
    private int header_textSize = 9;
    private int header_ribbonColor = getContext().getResources().getColor(R.color.pale_magenta_90);
    private int header_ribbonRadius= 10;
    private int header_padding = 4;
    private boolean show_header = true;

    private String bottom_text = "";
    private int bottom_textColor = Color.WHITE;
    private int bottom_textSize = 9;
    private int bottom_height = -1;
    private int bottom_ribbonColor = getContext().getResources().getColor(R.color.pale_magenta_90);
    private int bottom_padding = 3;
    private boolean show_bottom = true;

    public RibbonLayout(Context context) {
        super(context);
        onCreate();
    }

    public RibbonLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        onCreate();
        getAttrs(attrs);
    }

    public RibbonLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onCreate();
        getAttrs(attrs, defStyleAttr);
    }

    private void onCreate() {
        ribbon_header = new TextView(getContext());
        ribbon_header.setBackgroundResource(R.drawable.rectangle_layout);
        ribbon_bottom = new TextView(getContext());
    }

    private void getAttrs(AttributeSet attributeSet) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.RibbonLayout);
        try {
            setTypeArray(typedArray);
        } finally {
            typedArray.recycle();
        }
    }

    private void getAttrs(AttributeSet attributeSet, int defStyleAttr) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.RibbonLayout, defStyleAttr, 0);
        try {
            setTypeArray(typedArray);
        } finally {
            typedArray.recycle();
        }
    }

    private void setTypeArray(TypedArray typeArray) {
        header_text = typeArray.getString(R.styleable.RibbonLayout_header_text);
        header_textSize = typeArray.getInt(R.styleable.RibbonLayout_header_textSize, header_textSize);
        header_textColor = typeArray.getColor(R.styleable.RibbonLayout_header_textColor, header_textColor);
        header_ribbonColor = typeArray.getColor(R.styleable.RibbonLayout_header_ribbonColor, header_ribbonColor);
        header_ribbonRadius = typeArray.getInt(R.styleable.RibbonLayout_header_ribbonRadius, header_ribbonRadius);
        header_padding = typeArray.getInt(R.styleable.RibbonLayout_header_padding, header_padding);
        show_header = typeArray.getBoolean(R.styleable.RibbonLayout_show_header, show_header);

        bottom_text = typeArray.getString(R.styleable.RibbonLayout_bottom_text);
        bottom_textSize = typeArray.getInt(R.styleable.RibbonLayout_bottom_textSize, bottom_textSize);
        bottom_textColor = typeArray.getColor(R.styleable.RibbonLayout_bottom_textColor, bottom_textColor);
        bottom_ribbonColor = typeArray.getColor(R.styleable.RibbonLayout_bottom_ribbonColor, bottom_ribbonColor);
        bottom_height = typeArray.getInt(R.styleable.RibbonLayout_bottom_height, bottom_height);
        bottom_padding = typeArray.getInt(R.styleable.RibbonLayout_bottom_padding, bottom_padding);
        show_bottom = typeArray.getBoolean(R.styleable.RibbonLayout_show_bottom, show_bottom);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        updateRibbons();
    }

    private void updateRibbons() {
        removeRibbons();

        if(show_header) {
            ribbon_header.setText(header_text);
            ribbon_header.setTextSize(header_textSize);
            ribbon_header.setTextColor(header_textColor);
            ribbon_header.setPadding(header_padding, header_padding, header_padding, header_padding);
            GradientDrawable bgShape = (GradientDrawable)ribbon_header.getBackground();
            bgShape.setCornerRadius(header_ribbonRadius);
            bgShape.setColor(header_ribbonColor);
            addView(ribbon_header);
        }

        if(show_bottom) {
            ribbon_bottom.setText(bottom_text);
            ribbon_bottom.setTextSize(bottom_textSize);
            ribbon_bottom.setTextColor(bottom_textColor);
            ribbon_bottom.setBackgroundColor(bottom_ribbonColor);
            if(bottom_height != -1) ribbon_bottom.setHeight(bottom_height);
            ribbon_bottom.setPadding(bottom_padding, bottom_padding, bottom_padding, bottom_padding);
            final LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            ribbon_bottom.setGravity(Gravity.CENTER);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            ribbon_bottom.setLayoutParams(layoutParams);
            addView(ribbon_bottom);
        }
    }

    private void removeRibbons() {
        if(ribbon_header != null)
            removeView(ribbon_header);
        if(ribbon_bottom != null)
            removeView(ribbon_bottom);
    }

    public void setHeaderText(String text) {
        this.header_text = text;
        this.ribbon_header.setText(text);
    }

    public void setHeaderTextColor(int color) {
        this.header_textColor = color;
        this.ribbon_header.setTextColor(color);
    }

    public void setHeaderRibbonColor(int color) {
        this.header_ribbonColor = color;
        GradientDrawable bgShape = (GradientDrawable)ribbon_header.getBackground();
        bgShape.setColor(header_ribbonColor);
    }

    public void setBottomText(String text) {
        this.bottom_text = text;
        this.ribbon_bottom.setText(text);
    }

    public void setBottomTextColor(int color) {
        this.bottom_textColor = color;
        this.ribbon_bottom.setTextColor(color);
    }

    public void setBottomRibbonColor(int color) {
        this.bottom_ribbonColor = color;
        this.ribbon_bottom.setBackgroundColor(color);
    }

    public void setShowHeader(boolean show) {
        this.show_header = show;
        updateRibbons();
    }

    public void setShow_bottom(boolean show) {
        this.show_bottom = show;
        updateRibbons();
    }
}