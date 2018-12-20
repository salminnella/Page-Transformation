package com.salmin.onboardingdemo;

import android.animation.ArgbEvaluator;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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

		mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {
				if(position < (introAdapter.getCount() -1) && position < (colors.length - 1)) {

					Log.d(TAG, "onPageScrolled: setBackgroundColor ");
					Log.d(TAG, "----------------------------------------------");
					mViewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position], colors[position + 1]));

				} else {
					Log.d(TAG, "onPageScrolled: else color *********************");
					mViewPager.setBackgroundColor(colors[colors.length - 1]);

				}
			}

			@Override
			public void onPageSelected(int position) {

			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});

	}
}
