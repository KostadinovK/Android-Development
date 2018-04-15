package com.kosta.hotornot;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int mTabsNum;

    public PagerAdapter(FragmentManager fragmentManager, int mTabsNum) {
        super(fragmentManager);
        this.mTabsNum = mTabsNum;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                OverallFragment tab1 = new OverallFragment();
                return tab1;
            case 1:
                DetailsFragment tab2 = new DetailsFragment();
                return tab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabsNum;
    }
}
