package com.example.xyzreader.ui;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.view.View;

/**
 * Created by sam on 3/12/18.
 */

public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior{

    @Override
    public boolean onStartNestedScroll(View child, View target, int axes){
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL ||
                super.onStartNestedScroll(child, target, axes);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed,
                               int dyUnconsumed){
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);

        if(dyConsumed > 0 && child.getVisibility() == View.VISIBLE){
            child.hide();
        }

    }
}
