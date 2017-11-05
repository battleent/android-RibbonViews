
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
