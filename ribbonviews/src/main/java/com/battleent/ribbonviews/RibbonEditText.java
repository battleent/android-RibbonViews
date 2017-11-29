package com.battleent.ribbonviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by skydoves on 2017. 11. 29.
 * Copyright (c) 2017 battleent rights reserved.
 */

public class RibbonEditText extends LinearLayout {

    private TextView ribbon;
    private EditText editText;

    private int paddingTop = 10;
    private int ribbonFocusColor = ContextCompat.getColor(getContext(), R.color.colorPrimary);

    private String ribbonText = "";
    private int ribbonSize = 12;
    private int ribbonColor = ContextCompat.getColor(getContext(), R.color.black_38);
    private int ribbonLeftPadding = 10;

    private String editHint = "";
    private int editSize = 16;
    private int editHintColor = ContextCompat.getColor(getContext(), R.color.black_54);
    private int editColor = ContextCompat.getColor(getContext(), R.color.black_87);

    public RibbonEditText(Context context) {
        super(context);
        onCreate();
    }

    public RibbonEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        onCreate();
        getAttrs(attrs);
    }

    public RibbonEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onCreate();
        getAttrs(attrs, defStyleAttr);
    }

    private void onCreate() {
        setOrientation(LinearLayout.VERTICAL);
        ribbon = new TextView(getContext());
        editText = new EditText(getContext());
    }

    private void getAttrs(AttributeSet attributeSet) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.RibbonEditText);
        try {
            setTypeArray(typedArray);
        } finally {
            typedArray.recycle();
        }
    }

    private void getAttrs(AttributeSet attributeSet, int defStyleAttr) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.RibbonEditText, defStyleAttr, 0);
        try {
            setTypeArray(typedArray);
        } finally {
            typedArray.recycle();
        }
    }

    private void setTypeArray(TypedArray typeArray) {
        paddingTop = typeArray.getInt(R.styleable.RibbonEditText_editText_paddingTop, paddingTop);
        ribbonFocusColor = typeArray.getColor(R.styleable.RibbonEditText_editText_ribbonFocusColor, ribbonFocusColor);
        ribbonText = typeArray.getString(R.styleable.RibbonEditText_editText_ribbonText);
        ribbonSize = typeArray.getInt(R.styleable.RibbonEditText_editText_editSize, ribbonSize);
        ribbonLeftPadding = typeArray.getInt(R.styleable.RibbonEditText_editText_ribbonLeftPadding, ribbonLeftPadding);
        ribbonColor = typeArray.getColor(R.styleable.RibbonEditText_editText_ribbonColor, ribbonColor);
        editHint = typeArray.getString(R.styleable.RibbonEditText_editText_editHint);
        editHintColor = typeArray.getInt(R.styleable.RibbonEditText_editText_editHintColor, editHintColor);
        editColor = typeArray.getColor(R.styleable.RibbonEditText_editText_editColor, editColor);
        editSize = typeArray.getInt(R.styleable.RibbonEditText_editText_editSize, editSize);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        updateRibbons();
    }

    private void updateRibbons() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 0, 0, paddingTop);
        ribbon.setLayoutParams(params);
        ribbon.setText(ribbonText);
        ribbon.setTextSize(TypedValue.COMPLEX_UNIT_SP, ribbonSize);
        ribbon.setTextColor(ribbonColor);
        addView(ribbon);

        LayoutParams params_editText = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        editText.setLayoutParams(params_editText);
        editText.setHint(editHint);
        editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, editSize);
        editText.setHintTextColor(editHintColor);
        editText.setTextColor(editColor);
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean onChange) {
                if(onChange) {
                    ribbon.setTextColor(ribbonFocusColor);
                } else {
                    ribbon.setTextColor(ribbonColor);
                }
            }
        });
        addView(editText);
    }

    public TextView getRibbon() {
        return ribbon;
    }

    public EditText getEditText() {
        return editText;
    }
}
