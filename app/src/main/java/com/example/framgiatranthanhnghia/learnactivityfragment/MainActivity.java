package com.example.framgiatranthanhnghia.learnactivityfragment;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.framgiatranthanhnghia.learnactivityfragment.adapter.ViewPagerAdapter;

public class MainActivity extends ActionBarActivity {

    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "onCreate");

        mViewPager=(ViewPager)findViewById(R.id.view_pager);
        mAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(2);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart");
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

//    public void setPositionFragment(int positionFragment){
//        mViewPager.setCurrentItem(positionFragment);
//    }
//
//    public int getCurrentPosition(){
//        return mViewPager.getCurrentItem();
//    }

//    public void callChooseFragmentFromSecondFrag(){
//        Intent i=new Intent(Intent.ACTION_PICK);
//        i.setType("image/*");
//        startActivityForResult(i,mPhotoAction);
//    }
//
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("MainActivity", "requestCode="+requestCode+"--resultCode="+resultCode);

    }
}
