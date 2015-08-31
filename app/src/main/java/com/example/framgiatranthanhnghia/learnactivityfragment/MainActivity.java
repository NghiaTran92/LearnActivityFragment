package com.example.framgiatranthanhnghia.learnactivityfragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.example.framgiatranthanhnghia.learnactivityfragment.adapter.ViewPagerAdapter;
import com.example.framgiatranthanhnghia.learnactivityfragment.fragment.FirstFragment;
import com.example.framgiatranthanhnghia.learnactivityfragment.fragment.SecondFragment;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    private final String TAG = "MainActivity";
    private final int mPhotoAction = 10;

    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    private List<Fragment> mListFragment;
    private GestureDetector tapGestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "onCreate");

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mListFragment = new ArrayList<>();
        mListFragment.add(new FirstFragment());
        mListFragment.add(new SecondFragment());

        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mListFragment);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(2);

        tapGestureDetector = new GestureDetector(this, new TapGestureListener());
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                tapGestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });

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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("MainActivity", "requestCode=" + requestCode + "--resultCode=" + resultCode);
        if (requestCode == mPhotoAction) {
            if (resultCode == Activity.RESULT_OK) {
                Log.i(TAG, "onActivityResult RESULT_OK");
                Uri selectedImage = data.getData();
                SecondFragment secondFragment=(SecondFragment) mListFragment.get(1); // 1: second fragment
                if(secondFragment!=null){
                    secondFragment.loadImageFrom(selectedImage);
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.i(TAG, "onActivityResult RESULT_CANCELED");
                // 0: first fragment
                mViewPager.setCurrentItem(0);
            }
        }
    }


    public class TapGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            // Your Code here

            Fragment fragment = null;
            for (int i = 0; i < mListFragment.size(); i++) {
                fragment = mListFragment.get(i);
                // check fragment
                //  isVisible() not working
                if (fragment.isMenuVisible()) {
                    Log.i("Check Fragemt", "position=" + i + "-- isMenuVisible");
                    // 1: second fragment
                    if (i == 1) {
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(intent, mPhotoAction);
                    }
                }
            }
            return true;
        }
    }


}
