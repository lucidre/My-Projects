package com.oti.tablayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {
	Context context;
	String[] pagerTitle = {"tab 1", "tab 2", "tab 3"};
	int[] images = {R.drawable.ic_tab1, R.drawable.ic_tab2, R.drawable.ic_tab3};


	public MyAdapter(@NonNull FragmentManager fm, Context context) {
		super(fm);
		this.context = context;
	}

	/**
	 * Return the Fragment associated with a specified position.
	 *
	 * @param position
	 */
	@NonNull
	@Override
	public Fragment getItem(int position) {

		return PagerManager.getInstance(position, context);
	}

	/**
	 * Return the number of views available.
	 */
	@Override
	public int getCount() {
		return 3;
	}

	public CharSequence getPageTitle(int position) {
		Drawable drawable = context.getDrawable(images[position]);

		drawable.setBounds(0, 0, 104, 104);
		ImageSpan imageSpan = new ImageSpan(drawable);
		SpannableString spannableString = new SpannableString(" ");
		spannableString.setSpan(imageSpan, 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return spannableString;
	}
}
