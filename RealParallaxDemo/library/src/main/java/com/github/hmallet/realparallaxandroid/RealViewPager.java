package com.github.hmallet.realparallaxandroid;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hugo
 * on 08/12/2015.
 */
public class RealViewPager extends ViewPager {

    private RealHorizontalScrollView mRealHorizontalScrollView;
    private float mParallaxVelocity;
    private int mRealHorizontalScrollViewWidth;

    public RealViewPager(Context context) {
        super(context);
    }

    public RealViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initRealViewPagerAttributes(context, attrs);
    }

    public void configure(RealHorizontalScrollView realHorizontalScrollView) {
        this.mRealHorizontalScrollView = realHorizontalScrollView;

        mRealHorizontalScrollViewWidth = this.mRealHorizontalScrollView.getWidth();

        overrideScrollListener();
    }

    public void configureWithMyListener(RealHorizontalScrollView realHorizontalScrollView) {
        this.mRealHorizontalScrollView = realHorizontalScrollView;
        mRealHorizontalScrollViewWidth = this.mRealHorizontalScrollView.getWidth();
    }

    public void setRealHorizontalScrollViewPosition(int scrollX, int widthScreenSize, int position) {
        int realScrollX = scrollX;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            realScrollX = scrollX + (widthScreenSize * position);
        }
        mRealHorizontalScrollView.scrollTo(Math.round(realScrollX * mParallaxVelocity), 0);
    }

    /**
     *  Override scroll listener
     *
     *  @param scrollX scroll X
     *  @param position current item position
     */
    public void manageScrollWithMyListeners(int scrollX, int position) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setRealHorizontalScrollViewPosition(scrollX, mRealHorizontalScrollViewWidth, 0);
        } else {
            setRealHorizontalScrollViewPosition(scrollX, mRealHorizontalScrollViewWidth, position);
        }
    }

    private void overrideScrollListener() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            this.setOnScrollChangeListener(new OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    setRealHorizontalScrollViewPosition(scrollX, mRealHorizontalScrollViewWidth, 0);
                }
            });
        } else {
            this.setOnPageChangeListener(new OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    setRealHorizontalScrollViewPosition(positionOffsetPixels, mRealHorizontalScrollViewWidth, position);
                }

                @Override
                public void onPageSelected(int position) {
                    // nothing to do
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    // nothing to do
                }
            });
        }
    }

    private void initRealViewPagerAttributes(Context context, AttributeSet attrs) {

        TypedArray attributesArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RealViewPager,
                0, 0);

        try {
            mParallaxVelocity = attributesArray.getFloat(R.styleable.RealViewPager_parallaxVelocity, 0.3f);
        } finally {
            attributesArray.recycle();
        }
    }
}
