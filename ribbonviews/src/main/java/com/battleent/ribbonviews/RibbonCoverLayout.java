/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 battleent
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.battleent.ribbonviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RibbonCoverLayout extends RelativeLayout {

    private RelativeLayout cover;
    private TextView cover_text;

    private int cover_color = ContextCompat.getColor(getContext(), R.color.cover);
    private float cover_alpha = 1.0f;

    private String cover_textContent = "";
    private int cover_textSize = 9;
    private int cover_textColor = Color.WHITE;

    public RibbonCoverLayout(Context context) {
        super(context);
        onCreate();
    }

    public RibbonCoverLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        onCreate();
        getAttrs(attrs);
    }

    public RibbonCoverLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onCreate();
        getAttrs(attrs, defStyleAttr);
    }

    private void onCreate() {
        this.cover = new RelativeLayout(getContext());
        this.cover_text = new TextView(getContext());
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
        cover_color = typeArray.getColor(R.styleable.RibbonCoverLayout_cover_color, cover_color);
        cover_alpha = typeArray.getFloat(R.styleable.RibbonCoverLayout_cover_alpha, cover_alpha);

        cover_textContent = typeArray.getString(R.styleable.RibbonCoverLayout_cover_text);
        cover_textSize = typeArray.getInt(R.styleable.RibbonCoverLayout_cover_textSize, cover_textSize);
        cover_textColor = typeArray.getColor(R.styleable.RibbonCoverLayout_cover_textColor, cover_textColor);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        updateCover();
    }

    private void updateCover() {
        removeCover();

        cover.setBackgroundColor(cover_color);
        cover.setAlpha(cover_alpha);
        cover.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        cover_text.setText(cover_textContent);
        cover_text.setTextSize(cover_textSize);
        cover_text.setTextColor(cover_textColor);
        cover.addView(cover_text);
        RelativeLayout.LayoutParams layoutParams_text = (RelativeLayout.LayoutParams)cover_text.getLayoutParams();
        layoutParams_text.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        cover_text.setLayoutParams(layoutParams_text);
        addView(cover);
    }

    private void removeCover() {
        if(cover != null)
            removeView(cover);
        if(cover_text != null)
            removeView(cover_text);
    }

    public void setCoverText(String text) {
        this.cover_text.setText(text);
    }
}
