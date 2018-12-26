package com.salmin.onboardingdemo;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ViewPager mViewPager;
    private IntroAdapter introAdapter;
    private ArgbEvaluator argbEvaluator;
    private Integer[] colors = {R.color.page1, R.color.page2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        introAdapter = new IntroAdapter(getSupportFragmentManager());
        argbEvaluator = new ArgbEvaluator();
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        // Set an Adapter on the ViewPager
        mViewPager.setAdapter(introAdapter);

        // Set a PageTransformer
        mViewPager.setPageTransformer(false, new IntroPageTransformer());
    }
}
