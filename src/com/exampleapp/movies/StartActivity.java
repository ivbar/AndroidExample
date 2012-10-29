package com.exampleapp.movies;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.exampleapp.movies.fragments.ListFragment;

public class StartActivity extends SherlockFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.start_activity);
	
	if (savedInstanceState == null) {
	    ListFragment listFragment = new ListFragment();
		getSupportFragmentManager().beginTransaction()
				.add(R.id.listFragmentHolder, listFragment).commit();
	}
    }

}
