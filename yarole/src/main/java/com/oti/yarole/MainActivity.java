package com.oti.yarole;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = findViewById(R.id.toolbar);
		toolbar.setTitle("sliding Menu");
		setSupportActionBar(toolbar);

		new SlidingRootNavBuilder(this).withToolbarMenuToggle(toolbar).withMenuOpened(false).withMenuLayout(R.layout.menu).inject();
	}
}
