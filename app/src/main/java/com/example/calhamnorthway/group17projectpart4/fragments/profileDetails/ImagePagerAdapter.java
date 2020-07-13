package com.example.calhamnorthway.group17projectpart4.fragments.profileDetails;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ImagePagerAdapter extends FragmentPagerAdapter {

    private int[] imageIdArray;

    public ImagePagerAdapter(FragmentManager fm, int[] imageIdArray) {
        super(fm);
        this.imageIdArray = imageIdArray;
    }

    @Override
    public int getCount() {
        return imageIdArray.length;
    }

    @Override
    public Fragment getItem(int i) {
        return ImageFragment.newInstance(imageIdArray[i], ImageFragment.SMALL_VIEW);
    }

    @Override
    public long getItemId(int position) {
        return imageIdArray[position];
    }
}