package com.exampleapp.movies.fragments;

import com.exampleapp.movies.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListFragment extends Fragment {

    /**
     * The system calls this when creating the fragment. Within your
     * implementation, you should initialize essential components of the
     * fragment that you want to retain when the fragment is paused or stopped,
     * then resumed.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
    }

    /**
     * The system calls this when it's time for the fragment to draw its user
     * interface for the first time. To draw a UI for your fragment, you must
     * return a View from this method that is the root of your fragment's
     * layout. You can return null if the fragment does not provide a UI.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	    Bundle savedInstanceState) {

	return inflater.inflate(R.layout.list_fragment, null, false);

	// TODO: get views here

    }

    /**
     * The system calls this method as the first indication that the user is
     * leaving the fragment (though it does not always mean the fragment is
     * being destroyed). This is usually where you should commit any changes
     * that should be persisted beyond the current user session (because the
     * user might not come back).
     */
    @Override
    public void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
    }
}