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
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

public class RibbonFickleCoverLayout extends RelativeLayout {

    private View cover = null;
    private View cover_second = null;

    private int cover_id = -1;
    private int cover_second_id = -1;

    private boolean isAnimatied = false;

    private int duration = 1000;

    public RibbonFickleCoverLayout(Context context) {
        super(context);
    }

    public RibbonFickleCoverLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        getAttrs(attrs);
    }

    public RibbonFickleCoverLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrs(attrs, defStyleAttr);
    }

    private void getAttrs(AttributeSet attributeSet) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.RibbonFickleCoverLayout);
        try {
            setTypeArray(typedArray);
        } finally {
            typedArray.recycle();
        }
    }

    private void getAttrs(AttributeSet attributeSet, int defStyleAttr) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.RibbonFickleCoverLayout);
        try {
            setTypeArray(typedArray);
        } finally {
            typedArray.recycle();
        }
    }

    private void setTypeArray(TypedArray typeArray) {
        cover_id = typeArray.getResourceId(R.styleable.RibbonFickleCoverLayout_fickle_cover, cover_id);
        cover_second_id = typeArray.getResourceId(R.styleable.RibbonFickleCoverLayout_fickle_cover_second, cover_second_id);
        duration = typeArray.getInteger(R.styleable.RibbonFickleCoverLayout_fickle_delay, duration);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        if(getChildCount() > 0) {
            if(getChildAt(0) instanceof ViewGroup) {
                ViewGroup childLayout = (ViewGroup) getChildAt(0);
                childLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        updateCover();
                    }
                });

                if(childLayout.getChildCount() > 0) {
                    childLayout.getChildAt(0).post(new Runnable() {
                        @Override
                        public void run() {
                            updateCover();
                        }
                    });
                }
            }
        }
        updateCover();
    }

    private void updateCover() {
        removeCover();

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(inflater != null) {
            if(cover_id != -1) {
                cover = inflater.inflate(cover_id, null);
                cover.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                cover.setOnClickListener(cover_Listener);
                addView(cover);
            }

            if(cover_second_id != -1) {
                cover_second = inflater.inflate(cover_second_id, null);
                cover_second.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                addView(cover_second);
                cover_second.post(new Runnable() {
                    @Override
                    public void run() {
                        cover_second.setX(-getWidth());
                    }
                });
            }
        }
    }

    private OnClickListener cover_Listener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            cover.post(new Runnable() {
                @Override
                public void run() {
                    if(!isAnimatied) {
                        cover_second.post(new Runnable() {
                            @Override
                            public void run() {
                                TranslateAnimation animation_cover_second = new TranslateAnimation(0, cover.getWidth(), 0, 0);
                                animation_cover_second.setDuration(duration);
                                animation_cover_second.setFillEnabled(true);
                                animation_cover_second.setFillAfter(true);
                                cover_second.setAnimation(animation_cover_second);

                                isAnimatied = true;
                                TranslateAnimation animation_cover = new TranslateAnimation(0, cover.getWidth(), 0, 0);
                                animation_cover.setDuration(duration);
                                animation_cover.setFillEnabled(true);
                                animation_cover.setFillAfter(true);
                                cover.startAnimation(animation_cover);
                            }
                        });
                    }
                }
            });
        }
    };

    private void removeCover() {
        if(cover != null) {
            removeView(cover);
            cover = null;
            cover_id = -1;
        }
        if(cover_second != null) {
            removeView(cover_second);
            cover_second = null;
            cover_id = -1;
        }
    }

    public void setCoverLayout(int id) {
        this.cover_id = id;
        updateCover();
    }

    public void setCoverSecondLayout(int id) {
        this.cover_second_id = id;
        updateCover();
    }

    public void setCoverSecondClickListener(OnClickListener onClickListener) {
        if(cover_second != null ) {
            this.cover_second.setOnClickListener(onClickListener);
        }
    }
}
