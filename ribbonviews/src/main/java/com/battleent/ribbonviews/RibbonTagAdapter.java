
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

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RibbonTagAdapter extends RecyclerView.Adapter<RibbonTagViewHolder> implements  IRibbonItem<RibbonTagItem> {

    private List<RibbonTagItem> ribbonTagList;

    public RibbonTagAdapter() {
        super();
        ribbonTagList = new ArrayList<>();
    }

    public RibbonTagAdapter(List<RibbonTagItem> ribbonTagList) {
        this.ribbonTagList = ribbonTagList;
    }

    @Override
    public RibbonTagViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ribbontaglistview, parent, false);
        return new RibbonTagViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return ribbonTagList.size();
    }

    @Override
    public long getItemId(int index) {
        return index;
    }

    @Override
    public void onBindViewHolder(RibbonTagViewHolder viewHolder, int index) {
        RibbonTagItem item = ribbonTagList.get(index);
        viewHolder.ribbonTag.setTagText(item.getTagText());
        viewHolder.ribbonTag.setTagTextColor(item.getTagTextColor());
        viewHolder.ribbonTag.setRibbonColor(item.getRibbonColor());
        viewHolder.ribbonTag.setPadding(item.getPadding_left(), item.getPadding_top(), item.getPadding_right(), item.getPadding_bottom());
    }

    @Override
    public void addItem(RibbonTagItem item) {
        ribbonTagList.add(item);
        notifyDataSetChanged();
    }

    @Override
    public void addItem(int position, RibbonTagItem item) {
        ribbonTagList.add(position, item);
        notifyDataSetChanged();
    }

    @Override
    public void addItemList(List<RibbonTagItem> itemList) {
        ribbonTagList.addAll(itemList);
        notifyDataSetChanged();
    }

    @Override
    public void removeItem(RibbonTagItem item) {
        ribbonTagList.remove(item);
        notifyDataSetChanged();
    }

    @Override
    public void removeItem(int position) {
        ribbonTagList.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public void clearItems() {
        ribbonTagList.clear();
        notifyDataSetChanged();
    }

    @Override
    public List<RibbonTagItem> getItemList() {
        return ribbonTagList;
    }
}
