
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
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.List;

public class RibbonTagListView extends RecyclerView implements IRibbonItem<RibbonTagItem> {

    private RibbonTagAdapter adapter;

    private int space = 5;

    public RibbonTagListView(Context context) {
        super(context);
        onCreate();
    }

    public RibbonTagListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getAttrs(attrs);
        onCreate();
    }

    public RibbonTagListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrs(attrs, defStyleAttr);
        onCreate();
    }

    private void getAttrs(AttributeSet attributeSet) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.RibbonTagListView);
        try {
            setTypeArray(typedArray);
        } finally {
            typedArray.recycle();
        }
    }

    private void getAttrs(AttributeSet attributeSet, int defStyleAttr) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.RibbonTagListView, defStyleAttr, 0);

        try {
            setTypeArray(typedArray);
        } finally {
            typedArray.recycle();
        }
    }

    private void setTypeArray(TypedArray typeArray) {
        space =  typeArray.getInt(R.styleable.RibbonTagListView_item_space, space);
    }

    private void onCreate() {
        adapter = new RibbonTagAdapter();
        setAdapter(adapter);

        LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        setLayoutManager(layoutManager);

        RibbonTagItemDecoration decoration = new RibbonTagItemDecoration(space);
        addItemDecoration(decoration);
    }

    @Override
    public void addItem(RibbonTagItem item) {
        adapter.addItem(item);
    }

    @Override
    public void addItem(int position, RibbonTagItem item) {
        adapter.addItem(position, item);
    }

    @Override
    public void addItemList(List<RibbonTagItem> itemList) {
        adapter.addItemList(itemList);
    }

    @Override
    public void removeItem(RibbonTagItem item) {
        adapter.removeItem(item);
    }

    @Override
    public void removeItem(int position) {
        adapter.removeItem(position);
    }

    @Override
    public void clearItems() {
        adapter.clearItems();
    }

    @Override
    public List<RibbonTagItem> getItemList() {
        return adapter.getItemList();
    }
}
