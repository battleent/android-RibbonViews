
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
