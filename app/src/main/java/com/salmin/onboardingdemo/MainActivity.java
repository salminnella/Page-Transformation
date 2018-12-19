package com.salmin.onboardingdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mViewPager = (ViewPager) findViewById(R.id.viewpager);

		// Set an Adapter on the ViewPager
		mViewPager.setAdapter(new IntroAdapter(getSupportFragmentManager()));

		// Set a PageTransformer
		mViewPager.setPageTransformer(false, new IntroPageTransformer());

	}
}
