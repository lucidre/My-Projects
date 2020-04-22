package com.oti.tablayout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewPager viewPager = findViewById(R.id.viewPager);
		PagerTabStrip pagerTabStrip = findViewById(R.id.tab);
		MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(), this);
		int color = getColor(R.color.colorAccent);
		pagerTabStrip.setBackgroundColor(color);
		pagerTabStrip.setTabIndicatorColor(getColor(android.R.color.holo_green_light));
		pagerTabStrip.setPadding(10, 10, 10, 10);
		viewPager.setAdapter(myAdapter);
	}
}
