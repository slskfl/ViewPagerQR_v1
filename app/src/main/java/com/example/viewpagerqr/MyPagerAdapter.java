package com.example.viewpagerqr;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
    int numTabs; //탭의 개수
    public MyPagerAdapter(@NonNull FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs=numTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                HomeMain hm=new HomeMain();
                return hm;
            case 1:
                DeliveryMain dm=new DeliveryMain();
                return dm;
            case 2:
                ReturnMain rm=new ReturnMain();
                return rm;
            case 3:
                ErrorMain em=new ErrorMain();
                return em;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
