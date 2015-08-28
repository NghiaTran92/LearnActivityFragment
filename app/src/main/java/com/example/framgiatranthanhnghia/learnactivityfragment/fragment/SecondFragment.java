package com.example.framgiatranthanhnghia.learnactivityfragment.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.framgiatranthanhnghia.learnactivityfragment.MainActivity;
import com.example.framgiatranthanhnghia.learnactivityfragment.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by FRAMGIA\tran.thanh.nghia on 28/08/2015.
 */
public class SecondFragment extends Fragment   {
    private View mRootView;

    private MainActivity mMainActivity;

    private ImageView mImg;
    private Button mBtnChooseImg;
    private int mPhotoAction=10;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView=inflater.inflate(R.layout.fragment_second,container,false);
        mImg=(ImageView)mRootView.findViewById(R.id.img);
        mBtnChooseImg=(Button)mRootView.findViewById(R.id.btn_choose_image);
        mBtnChooseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(Intent.ACTION_PICK);
                i.setType("image/*");
                startActivityForResult(i, mPhotoAction);
            }
        });
        return mRootView;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mMainActivity=(MainActivity)activity;

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("SecondFragment", "requestCode=" + requestCode + "--resultCode=" + resultCode);
        if(requestCode==mPhotoAction){
            if(resultCode==Activity.RESULT_OK){

                try {
                    Uri selectedImage = data.getData();
                    InputStream imageStream = null;
                    imageStream = getActivity().getContentResolver().openInputStream(selectedImage);
                    Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
                    yourSelectedImage=Bitmap.createScaledBitmap(yourSelectedImage,100,100,false);
                    mImg.setImageBitmap(yourSelectedImage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }



            }else if(resultCode==Activity.RESULT_CANCELED){
                // 0: firstFragment
                if (mMainActivity!=null && mMainActivity.getCurrentPosition()!=0){
                    mMainActivity.setPositionFragment(0);
                }
            }
        }
    }
}
