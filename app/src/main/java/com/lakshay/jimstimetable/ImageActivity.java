package com.lakshay.jimstimetable;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.polites.android.GestureImageView;

/**
 * Created by saurabh on 17-02-2015.
 */
public class ImageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = getLayoutInflater();
        View v= inflater.inflate(R.layout.image, null);
        GestureImageView imageView = (GestureImageView) v.findViewById(R.id.image);
        int a =getIntent().getIntExtra("image",0);
        switch(a)
        {
            case R.id.bba_monday: imageView.setImageResource(R.drawable.bba_monday);
                break;
            case R.id.bba_tuesday: imageView.setImageResource(R.drawable.bba_tuesday);
                break;
            case R.id.bba_wednesday: imageView.setImageResource(R.drawable.bba_wednesday);
                break;
            case R.id.bba_thursday: imageView.setImageResource(R.drawable.bba_thursday);
                break;
            case R.id.bba_friday: imageView.setImageResource(R.drawable.bba_friday);
                break;
            case R.id.bca_monday: imageView.setImageResource(R.drawable.bca_monday);
                break;
            case R.id.bca_tuesday: imageView.setImageResource(R.drawable.bca_tuesday);
                break;
            case R.id.bca_wednesday: imageView.setImageResource(R.drawable.bca_wednesday);
                break;
            case R.id.bca_thursday: imageView.setImageResource(R.drawable.bca_thursday);
                break;
            case R.id.bca_friday: imageView.setImageResource(R.drawable.bca_friday);
                break;
            case R.id.bjmc_monday: imageView.setImageResource(R.drawable.bjmc_monday);
                break;
            case R.id.bjmc_tuesday: imageView.setImageResource(R.drawable.bjmc_tuesday);
                break;
            case R.id.bjmc_wednesday: imageView.setImageResource(R.drawable.bjmc_wednesday);
                break;
            case R.id.bjmc_thursday: imageView.setImageResource(R.drawable.bjmc_thursday);
                break;
            case R.id.bjmc_friday: imageView.setImageResource(R.drawable.bjmc_friday);
                break;
        }
        setContentView(v);
    }
}
