package com.example.xyzreader.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sam on 3/12/18.
 */

public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior{





    public ScrollAwareFABBehavior(Context context, AttributeSet attributeSet){
        super();
    }


    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout,
                                       FloatingActionButton child, View directTargetChild,
                                       View target, int axes, int type){
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL||
               super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target,
                        axes, type);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child,
                               View target, int dxConsumed, int dyConsumed, int dxUnconsumed,
                               int dyUnconsumed, int type){
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed,
                dxUnconsumed, dyUnconsumed, type);



        //dyConsumed is the Y axis of pixel consumed when scrolling down
        if(dyConsumed > 0 && child.getVisibility() == View.VISIBLE){
            //Was having problem child.hide(), but it will we need overide the on hidden to make
            //the android know that hide() = INVISIBLE
           child.hide(new FloatingActionButton.OnVisibilityChangedListener() {
               @Override
               public void onHidden(FloatingActionButton fab) {
                   super.onShown(fab);
                   fab.setVisibility(View.INVISIBLE);
               }
           });

        } else if (dyConsumed < 0 && child.getVisibility() == View.INVISIBLE){
           child.show();
        }

    }
}
