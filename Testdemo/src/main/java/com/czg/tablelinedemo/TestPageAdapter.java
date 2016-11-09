package com.czg.tablelinedemo;


import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 类 名 称  ： TestPageAdapter.class
 * 作    者 ：  czg
 * 日    期 ：  2016/11/9.
 * 作    用 ： 在这里写一句话描述作用
 */
public class TestPageAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return "title"+position+position+position;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView textView = new TextView(container.getContext());
        textView.setText("page---"+position+"");
        textView.setTextSize(50);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);
        container.addView(textView);
        return textView;
    }
}
