
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
