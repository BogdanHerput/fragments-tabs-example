package com.example.bogdanherput.viewpagerexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager pager = (ViewPager)findViewById(R.id.pager);
        final TitlePageIndicator pageIndicator = (TitlePageIndicator)findViewById(R.id.titles_indicator);

        pager.setAdapter(new ListPagerAdapter(getSupportFragmentManager()));
        pageIndicator.setTextColor(getResources().getColor(R.color.black));
        pageIndicator.setSelectedColor(getResources().getColor(R.color.blue));
        pageIndicator.setViewPager(pager, 2);
    }


    private static class ListPagerAdapter extends FragmentStatePagerAdapter {

        public ListPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            final List<String> items = new ArrayList<String>(20);
            for (int j = 0; j < 19; j++) {
                items.add("Tab " + (i+1) + " item " + (j+1));
            }
            return FragmentItem.getInstance(items);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Tab " + (position + 1);
        }
    }
}
