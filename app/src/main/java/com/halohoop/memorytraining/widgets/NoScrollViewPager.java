package com.halohoop.memorytraining.widgets;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Pooholah on 2017/3/31.
 */

public class NoScrollViewPager extends ViewPager{
    private boolean mCanScroll = false;

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (!mCanScroll) {
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (!mCanScroll) {
            return false;
        }
        return super.onTouchEvent(ev);
    }

    public void setCanScroll(boolean canScroll) {
        this.mCanScroll = canScroll;
    }
}
