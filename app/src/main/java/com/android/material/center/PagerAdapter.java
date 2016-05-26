package com.android.material.center;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    public static final int NUM_ITEMS = 4;
    public static final int DYNAMIC = 0;
    public static final int ARTICLE = 1;
    public static final int LIVE = 2;
    public static final int VIDEO = 3;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case DYNAMIC:
                OneFragment oneFragment =new OneFragment();
                return oneFragment;
            case ARTICLE:
                TwoFragment twoFragment =new TwoFragment();
                return twoFragment;
            case LIVE:
                ThreeFragment threeFragment =new ThreeFragment();
                return threeFragment;
            case VIDEO:
                FourFragment fourFragment =new FourFragment();
                return fourFragment;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case DYNAMIC:
                return "Dynamic";
            case ARTICLE:
                return "Article";
            case LIVE:
                return "Live";
            case VIDEO:
                return "Video";
            default:
                return "";
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
