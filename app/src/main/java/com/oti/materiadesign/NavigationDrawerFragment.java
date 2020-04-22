package com.oti.materiadesign;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class NavigationDrawerFragment extends Fragment implements MyViewHolder.ClickListener {


	public static final String PREF_FILE_NAME = "testpre";
	public static final String KEY_USER_LEARNED_DRAWABLE = "learned_drawable";
	List<String> list;
	private ActionBarDrawerToggle mDrawerToggle;
	private DrawerLayout mDrawerLayout;
	private boolean userKnows;
	private boolean mFromSavedInstanceState;
	private View containerView;
	private RecyclerView recyclerView;

	public NavigationDrawerFragment() {
		// Required empty public constructor
	}

	public static void saveToPreference(Context context, String preferenceName, String defaultValue) {
		SharedPreferences sharedPreferences =
				context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor edit = sharedPreferences.edit();
		edit.putString(preferenceName, defaultValue);
		edit.apply();

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// reading from the saved preference with false as default value
		userKnows = Boolean.parseBoolean(readFromPreference(getActivity(), KEY_USER_LEARNED_DRAWABLE, "false"));


		//if the bundle has been created and screen is rotated do this
		if (savedInstanceState != null) {
			// meamimg activity was recreated
			mFromSavedInstanceState = true;
		}


	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
		recyclerView = view.findViewById(R.id.rv);
		list = new ArrayList<>();
		list.add("Item 1");
		list.add("Item 2");
		list.add("Item 3");
		list.add("Item 4");
		list.add("Item 5");
		list.add("Item 6");
		list.add("Item 7");
		list.add("Item 8");
		list.add("Item 9");
		list.add("Item 10");
		list.add("Item 11");
		list.add("Item 12");
		list.add("Item 13");
		list.add("Item 14");
		list.add("Item 15");
		RecyclerViewAdapter adapter = new RecyclerViewAdapter(getLayoutInflater(), list, getContext());
		recyclerView.setAdapter(adapter);

		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

		return view;
	}

	public void setUp(int fragmentID, DrawerLayout drawerLayout, final Toolbar toolbar) {
		// getting the menu fragment
		containerView = getView().findViewById(fragmentID);

		//getting the parent drawer layout
		mDrawerLayout = drawerLayout;
		// setting the drawer animation
		mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.open,
				R.string.close) {
			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				// if this is the first time opening the app
				if (!userKnows) {
					userKnows = true;// user already knows
					//then save the userknows to preferences
					saveToPreference(getActivity(), KEY_USER_LEARNED_DRAWABLE, userKnows + "");

				}
				getActivity().invalidateOptionsMenu();// must be called

			}

			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);

				getActivity().invalidateOptionsMenu();

			}

			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				super.onDrawerSlide(drawerView, slideOffset);

				if (slideOffset < 0.5) {
					toolbar.setAlpha(1 - slideOffset);

				}


			}
		};

		//if the user doesnt and the activity was.t recreated due to rotation
		if (!userKnows && !mFromSavedInstanceState) {
			mDrawerLayout.openDrawer(containerView);// open the drawer layout
		}
		mDrawerLayout.addDrawerListener(mDrawerToggle);
		mDrawerLayout.post(new Runnable() {
			@Override
			public void run() {
				mDrawerToggle.syncState();
			}
		});// so the menu button can respond

	}

	// getting the saved preferences
	public String readFromPreference(Context context, String preferenceName, String defaultValue) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
		return sharedPreferences.getString(preferenceName, defaultValue);
	}

	@Override
	public void itemClick(View view, int position) {

	}
}
