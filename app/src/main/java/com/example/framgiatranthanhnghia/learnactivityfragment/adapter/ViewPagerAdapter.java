package com.example.framgiatranthanhnghia.learnactivityfragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.framgiatranthanhnghia.learnactivityfragment.fragment.FirstFragment;
import com.example.framgiatranthanhnghia.learnactivityfragment.fragment.SecondFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FRAMGIA\tran.thanh.nghia on 28/08/2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mListFragment;

    public ViewPagerAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        mListFragment=list;

    }

    @Override
    public Fragment getItem(int position) {
        return mListFragment.get(position);
    }

    @Override
    public int getCount() {
        return mListFragment.size();
    }
}
