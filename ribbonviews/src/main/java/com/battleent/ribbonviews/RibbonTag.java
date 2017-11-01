
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

package com.battleent.ribbonviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class RibbonTag extends TextView {

    private int tag_textColor = Color.WHITE;
    private int tag_textSize = 11;
    private int ribbonColor = getContext().getResources().getColor(R.color.bright_lavender);
    private int ribbonRadius= 10;
    private float padding_left = 6;
    private float padding_top = 2;
    private float padding_right = 6;
    private float padding_bottom = 2;

    public RibbonTag(Context context) {
        super(context);
        onCreate();
    }

    public RibbonTag(Context context, AttributeSet attrs) {
        super(context, attrs);
        onCreate();
        getAttrs(attrs);
    }

    public RibbonTag(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onCreate();
        getAttrs(attrs, defStyleAttr);
    }

    private void onCreate() {
        setBackgroundResource(R.drawable.rectangle_layout);
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
        tag_textSize = typeArray.getInt(R.styleable.RibbonTag_tag_textSize, tag_textSize);
        tag_textColor = typeArray.getColor(R.styleable.RibbonTag_tag_textColor, tag_textColor);
        ribbonColor = typeArray.getColor(R.styleable.RibbonTag_tag_ribbonColor, ribbonColor);
        ribbonRadius = typeArray.getInt(R.styleable.RibbonTag_tag_ribbonRadius, ribbonRadius);
        padding_left = typeArray.getDimension(R.styleable.RibbonTag_tag_padding_left, padding_left);
        padding_top = typeArray.getDimension(R.styleable.RibbonTag_tag_padding_top, padding_top);
        padding_right = typeArray.getDimension(R.styleable.RibbonTag_tag_padding_right, padding_right);
        padding_bottom = typeArray.getDimension(R.styleable.RibbonTag_tag_padding_bottom, padding_bottom);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        updateRibbonTag();
    }

    private void updateRibbonTag() {
        setTextSize(tag_textSize);
        setTextColor(tag_textColor);
        setPadding((int)padding_left, (int)padding_top, (int)padding_right, (int)padding_bottom);
        GradientDrawable bgShape = (GradientDrawable)getBackground();
        bgShape.setCornerRadius(ribbonRadius);
        bgShape.setColor(ribbonColor);
    }

    public void setTagText(String text) {
        setText(text);
    }

    public void setTagTextColor(int color) {
        setTextColor(color);
    }

    public void setRibbonColor(int color) {
        this.ribbonColor = color;
        GradientDrawable bgShape = (GradientDrawable)getBackground();
        bgShape.setColor(color);
    }
}