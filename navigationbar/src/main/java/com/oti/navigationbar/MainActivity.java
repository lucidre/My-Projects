package com.oti.navigationbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

	ActionBarDrawerToggle toggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
		NavigationView navigationView = findViewById(R.id.nav_view);


		toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.srn_drawer_open, R.string.srn_drawer_close);
		drawerLayout.addDrawerListener(toggle);
		toggle.syncState();
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {

				int itemId = item.getItemId();
				if (itemId == R.id.item1 || itemId == R.id.item2 || itemId == R.id.item3) {
					Toast.makeText(getApplicationContext(), "" + item, Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), "default", Toast.LENGTH_SHORT).show();
				}
				return true;
			}
		});
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		if (toggle.onOptionsItemSelected(item)) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
