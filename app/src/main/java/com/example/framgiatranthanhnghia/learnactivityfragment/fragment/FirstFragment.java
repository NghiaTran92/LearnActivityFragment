package com.example.framgiatranthanhnghia.learnactivityfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.framgiatranthanhnghia.learnactivityfragment.R;

/**
 * Created by FRAMGIA\tran.thanh.nghia on 28/08/2015.
 */
public class FirstFragment extends Fragment {

    private View mRootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView=inflater.inflate(R.layout.fragment_first,container,false);

        return mRootView;
    }

}
