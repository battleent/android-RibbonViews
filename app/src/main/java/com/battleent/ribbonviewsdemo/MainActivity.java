package com.battleent.ribbonviewsdemo;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.battleent.ribbonviews.RibbonTagItem;
import com.battleent.ribbonviews.RibbonTagListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RibbonTagListView ribbonTagListView = findViewById(R.id.ribbonTagListView);
        ribbonTagListView.addItem(new RibbonTagItem("new", ContextCompat.getColor(this, R.color.colorPrimary)));
        ribbonTagListView.addItem(new RibbonTagItem("free event", ContextCompat.getColor(this, R.color.free_event)));
        ribbonTagListView.addItem(new RibbonTagItem("owned", ContextCompat.getColor(this, R.color.md_light_blue_A700)));
    }
}
