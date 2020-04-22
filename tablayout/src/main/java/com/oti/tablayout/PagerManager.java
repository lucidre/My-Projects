package com.oti.tablayout;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PagerManager extends Fragment {
	Context context;

	public PagerManager(Context context) {

		this.context = context;
	}

	public static Fragment getInstance(int position, Context context) {
		PagerManager pagerManager = new PagerManager(context);
		Bundle bundle = new Bundle();
		bundle.putInt("position", position);
		pagerManager.setArguments(bundle);
		return pagerManager;
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		LayoutInflater layoutInflater = LayoutInflater.from(context);
		View view = layoutInflater.inflate(R.layout.viewpage, container, false);
		setRetainInstance(true);
		return view;
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		TextView textView = view.findViewById(R.id.textView);
		int position = getArguments().getInt("position", 0);
		String s = textView.getText().toString() + position + "";
		textView.setText(s);

	}
}
