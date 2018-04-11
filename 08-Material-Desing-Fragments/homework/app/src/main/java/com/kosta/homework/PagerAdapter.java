package com.kosta.homework;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Kostadin Kostadinov on 10/04/2018.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    int mTabsNum;

    public PagerAdapter(FragmentManager fragmentManager,int mTabsNum){
        super(fragmentManager);
        this.mTabsNum = mTabsNum;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                StoriesFragment tab1 = new StoriesFragment();
                return tab1;
            case 1:
                NotAvailableFragment tab2 = new NotAvailableFragment();
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
