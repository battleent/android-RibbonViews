
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

import android.graphics.Color;

public class RibbonTagItem {

    private String ribbonText;

    private int tagTextColor = Color.WHITE;
    private int ribbonColor = R.color.pale_magenta_90;

    private int padding_left = 16;
    private int padding_top = 2;
    private int padding_right = 16;
    private int padding_bottom = 2;

    public RibbonTagItem(String text) {
        this.ribbonText = text;
    }

    public RibbonTagItem(String text, int ribbonColor) {
        this.ribbonText = text;
        this.ribbonColor = ribbonColor;
    }

    public RibbonTagItem(String text, int tagTextColor, int ribbonColor) {
        this.ribbonText = text;
        this.tagTextColor = tagTextColor;
        this.ribbonColor = ribbonColor;
    }

    public void setTagText(String text) {
        this.ribbonText = text;
    }

    public void setTagTextColor(int color) {
        this.tagTextColor = color;
    }

    public void setRibbonColor(int color) {
        this.ribbonColor = color;
    }

    public void setPaddings(int left, int top, int right, int bottom) {
        this.padding_left = left;
        this.padding_top = top;
        this.padding_right = right;
        this.padding_bottom = bottom;
    }

    public String getTagText() {
        return this.ribbonText;
    }

    public int getTagTextColor() {
        return this.tagTextColor;
    }

    public int getRibbonColor() {
        return this.ribbonColor;
    }

    public int getPadding_left() {
        return this.padding_left;
    }

    public int getPadding_top() {
        return this.padding_top;
    }

    public int getPadding_right() {
        return this.padding_right;
    }

    public int getPadding_bottom() {
        return this.padding_bottom;
    }
}
