package com.example.framgiatranthanhnghia.learnactivityfragment.fragment;

import android.app.Activity;
import android.content.Context;
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
public class SecondFragment extends Fragment  {
    private final String TAG="SecondFragment";

    private View mRootView;

    private MainActivity mMainActivity;

    private ImageView mImg;

    private int mPhotoAction=10;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG,"onAttach context");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i(TAG, "onAttach activity");
        mMainActivity=(MainActivity)activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView=inflater.inflate(R.layout.fragment_second,container,false);
        mImg=(ImageView)mRootView.findViewById(R.id.img);

        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach");
    }


    public void loadImageFrom(Uri imageUri){
        InputStream imageStream = null;
        try {
            imageStream = getActivity().getContentResolver().openInputStream(imageUri);
            Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
            yourSelectedImage=Bitmap.createScaledBitmap(yourSelectedImage,250,250,false);
            mImg.setImageBitmap(yourSelectedImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Log.i(TAG, "requestCode=" + requestCode + "--resultCode=" + resultCode);
//        if(requestCode==mPhotoAction){
//            if(resultCode==Activity.RESULT_OK){
//                Log.i(TAG, "onActivityResult RESULT_OK");
//                try {
//                    Uri selectedImage = data.getData();
//                    InputStream imageStream = null;
//                    imageStream = getActivity().getContentResolver().openInputStream(selectedImage);
//                    Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
//                    yourSelectedImage=Bitmap.createScaledBitmap(yourSelectedImage,100,100,false);
//                    mImg.setImageBitmap(yourSelectedImage);
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//            }else if(resultCode==Activity.RESULT_CANCELED){
//                // 0: firstFragment
////                if (mMainActivity!=null && mMainActivity.getCurrentPosition()!=0){
////                    mMainActivity.setPositionFragment(0);
////                }
//                Log.i(TAG, "onActivityResult RESULT_CANCELED");
//            }
//        }
//    }


}
