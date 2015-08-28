package com.example.framgiatranthanhnghia.learnactivityfragment;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.framgiatranthanhnghia.learnactivityfragment.adapter.ViewPagerAdapter;

public class MainActivity extends ActionBarActivity {

    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    private Button mBtnCallSubActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "onCreate");

        String data=getIntent().getStringExtra(SubActivity.EXTRA_NAME);
        if(data!=null){
            Toast.makeText(this,data,Toast.LENGTH_LONG).show();
        }


        mViewPager=(ViewPager)findViewById(R.id.view_pager);
        mAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mBtnCallSubActivity=(Button)findViewById(R.id.btn_other_activity);
        mBtnCallSubActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,SubActivity.class);
                startActivity(i);
            }
        });

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

    public void setPositionFragment(int positionFragment){
        mViewPager.setCurrentItem(positionFragment);
    }

    public int getCurrentPosition(){
        return mViewPager.getCurrentItem();
    }

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
