//package com.example.framgiatranthanhnghia.learnactivityfragment;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.ActionBarActivity;
//import android.view.View;
//import android.widget.Button;
//
//import com.example.framgiatranthanhnghia.learnactivityfragment.adapter.ViewPagerAdapter;
//
///**
// * Created by FRAMGIA\tran.thanh.nghia on 28/08/2015.
// */
//public class SubActivity extends ActionBarActivity {
//    public static final String EXTRA_NAME="FromSubActivity";
//
//    private Button mBtnMainActivity;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sub);
//        mBtnMainActivity=(Button)findViewById(R.id.btn_send_extra);
//        mBtnMainActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(SubActivity.this,MainActivity.class);
//                i.putExtra(EXTRA_NAME,"data from SubActivity");
//                startActivity(i);
//            }
//        });
//    }
//
//}
