package com.czg.tablelinedemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.czgforlxy.tablineview.TabLineView;

public class MainActivity extends AppCompatActivity {
TabLineView tabLineView;
    ViewPager viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = (ViewPager)findViewById(R.id.viewpager);
        tabLineView = (TabLineView)findViewById(R.id.tablineview);
        viewpager.setAdapter(new TestPageAdapter());
        tabLineView.setupWithViewPager(viewpager);
    }
}
