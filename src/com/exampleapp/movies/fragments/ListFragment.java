package com.exampleapp.movies.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.exampleapp.movies.R;

public class ListFragment extends SherlockFragment {

    private ListView mListView;
    private LinearLayout mLoadingLayout;

    public ListFragment() {
    }

    /**
     * The system calls this when creating the fragment. Within your
     * implementation, you should initialize essential components of the
     * fragment that you want to retain when the fragment is paused or stopped,
     * then resumed.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	// /3/movie/popular
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
	ViewGroup root = (ViewGroup) inflater.inflate(R.layout.list_fragment,
		null);

	root.setLayoutParams(new ViewGroup.LayoutParams(
		ViewGroup.LayoutParams.MATCH_PARENT,
		ViewGroup.LayoutParams.MATCH_PARENT));

	mListView = (ListView) root.findViewById(R.id.listView);
	mLoadingLayout = (LinearLayout) root.findViewById(R.id.loadingLayout);

	return root;
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
