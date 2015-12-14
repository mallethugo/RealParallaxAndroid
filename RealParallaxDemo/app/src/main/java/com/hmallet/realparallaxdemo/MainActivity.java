package com.hmallet.realparallaxdemo;

import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.github.hmallet.realparallaxandroid.RealViewPager;
import com.github.hmallet.realparallaxandroid.RealHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RealHorizontalScrollView realHorizontalScrollView = (RealHorizontalScrollView) findViewById(R.id.main_horizontal_scrollview);
        final RealViewPager realViewPager = (RealViewPager) findViewById(R.id.main_view_pager);

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(Fragment.instantiate(this, Fragment1.class.getName()));
        fragments.add(Fragment.instantiate(this, Fragment2.class.getName()));
        fragments.add(Fragment.instantiate(this, Fragment3.class.getName()));

        Display display = getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);

        PagerAdapter realViewPagerAdapter = new MyPagerAdapter(super.getSupportFragmentManager(), fragments);

        // If you don't need to override ScrollListener you can replace this above code by calling `realViewPager.configure(realViewPagerAdapter)`
        realViewPager.setAdapter(realViewPagerAdapter);

        // You must set your RealHorizontalScrollView to your RealViewPager
        realViewPager.configureWithMyListener(realHorizontalScrollView);

        // If you need to override ScrollListener don't forget to add `manageScrollWithMyListeners`
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            realViewPager.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    realViewPager.manageScrollWithMyListeners(scrollX, 0);
                    // place your code here
                }
            });
        } else {
            realViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    realViewPager.manageScrollWithMyListeners(positionOffsetPixels, position);
                    // place your code here
                }

                @Override
                public void onPageSelected(int position) {
                    // nothing to do from lib
                    // place your code heremes
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    // nothing to do from lib
                    // place your code here
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
