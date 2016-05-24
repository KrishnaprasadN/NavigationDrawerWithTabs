package com.kp.nitteapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TabFragment extends Fragment {

    public static TabLayout mTabLayout;
    public static ViewPager mViewPager;
    public static int ITEMS_COUNT = 3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_layout, null);

        Bundle bundle = this.getArguments();
        int currentItem = 0;
        if (bundle != null) {
            currentItem = bundle.getInt(Constants.FRAGMENT_TYPE);
        }


        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        mViewPager.setCurrentItem(currentItem);

        mTabLayout = (TabLayout) view.findViewById(R.id.tabs);
        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                mTabLayout.setupWithViewPager(mViewPager);
            }
        });

        return view;
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new LatestFragment();
                case 1:
                    return new ContactUsFragment();
                case 2:
                    return new MapFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return ITEMS_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return getResources().getString(R.string.latest);
                case 1:
                    return getResources().getString(R.string.contact_us);
                case 2:
                    return getResources().getString(R.string.map);
            }
            return null;
        }
    }

}
