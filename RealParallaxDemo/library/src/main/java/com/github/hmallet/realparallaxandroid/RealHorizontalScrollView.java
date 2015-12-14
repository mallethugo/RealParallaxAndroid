package com.github.hmallet.realparallaxandroid;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

/**
 * Created by hugo
 * on 08/12/2015.
 */
public class RealHorizontalScrollView extends HorizontalScrollView{

    public RealHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initRealHorizontalScrollView(context, attrs);
    }

    public RealHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initRealHorizontalScrollView(context, attrs);
    }

    private void initRealHorizontalScrollView(Context context, AttributeSet attrs) {
        TypedArray attributesArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RealHorizontalScrollView,
                0, 0);

        try {
            Drawable background = attributesArray.getDrawable(R.styleable.RealHorizontalScrollView_src);
            if (background != null) {
                // set background
                ImageView iv = new ImageView(context);
                iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                iv.setImageDrawable(background);
                iv.setScaleType(ImageView.ScaleType.CENTER);
                this.addView(iv);
            }
        } finally {
            attributesArray.recycle();
        }
    }

}
