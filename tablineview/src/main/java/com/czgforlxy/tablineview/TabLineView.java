package com.czgforlxy.tablineview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;


public class TabLineView extends View implements ViewPager.OnPageChangeListener {
    private Paint paint;
    private Paint point;
    private PagerAdapter adapter;
    private int selectColor;
    private int itemColor;
    private int position;
    private int width;
    private int height;
    private int itemsize;
    private int textsize;
    private Paint textpaint;
    private int itemMargin;
    private int textcolor;

    public TabLineView(Context context) {
        super(context);
        initview();
    }
    public TabLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TabLineView);
        selectColor = a.getColor(R.styleable.TabLineView_selectcolor, Color.RED);
        itemColor = a.getColor(R.styleable.TabLineView_itemcolor, Color.WHITE);
        textcolor = a.getColor(R.styleable.TabLineView_textcolor, Color.BLACK);
        itemsize = a.getDimensionPixelSize(R.styleable.TabLineView_itemHight, 15);
        textsize = a.getDimensionPixelSize(R.styleable.TabLineView_textsize, 30);
        itemMargin = a.getDimensionPixelSize(R.styleable.TabLineView_itemMargin, 0);

        a.recycle();
        initview();


    }
    private void initview() {
        paint=new Paint();
        point=new Paint();
        textpaint =new Paint();
        paint.setColor(itemColor);
        point.setColor(selectColor);
        paint.setAntiAlias(true);
        textpaint.setAntiAlias(true);
        point.setAntiAlias(true);
        paint.setStrokeWidth(itemsize);
        point.setStrokeWidth(itemsize);
        textpaint.setTextSize(textsize);
        textpaint.setColor(textcolor);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(adapter!=null) {
            int count = adapter.getCount();
            int itemWidth = (width-(count-1)*itemMargin) / count;
            for (int i=0;i<count;i++){
                Paint paint=this.paint;
                if(i==position) {
                    paint=this.point;
                }


                canvas.drawLine((itemWidth+itemMargin)*i,height/2,(itemWidth)*(i+1)+itemMargin*i,height/2,paint);
            }
            CharSequence title = adapter.getPageTitle(position);
            if(title!=null) {
                Rect targetRect = new Rect(0, height/4*3, width, height);
                Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
                // 转载请注明出处：http://blog.csdn.net/hursing
                int baseline = (targetRect.bottom + targetRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
                // 下面这行是实现水平居中，drawText对应改为传入targetRect.centerX()
                textpaint.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(title.toString(), targetRect.centerX(), baseline, textpaint);
            }
        }

    }




    public void  setupWithViewPager(ViewPager viewPager){
        if(viewPager==null) {
            throw new NullPointerException("viewPager 不能为null");
        }
        viewPager.setOnPageChangeListener(this);
        adapter = viewPager.getAdapter();
        if(adapter ==null) {
            throw new RuntimeException("必须要先设置ViewPager适配器");
        }
        invalidate();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        this.position = position;
        invalidate();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
