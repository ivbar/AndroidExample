package com.exampleapp.movies.util;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {

    private List<MovieModel> mMovieModels;
    private LayoutInflater inflater;

    public CustomAdapter(Activity activity, List<MovieModel> mMovieModels) {
	this.mMovieModels = mMovieModels;
	this.inflater = activity.getLayoutInflater();
    }

    public int getCount() {
	return this.mMovieModels.size();
    }

    public MovieModel getItem(int position) {
	return this.mMovieModels.get(position);
    }

    public long getItemId(int position) {
	// TODO Auto-generated method stub
	return 0;
    }

    public static class ViewHolder {
	ImageView imageFav;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
	ViewHolder holder;
	final MovieModel movieModel = getItem(position);

	if (convertView == null) {
//	    convertView = inflater.inflate(R.layout.list_item, null);

	    holder = new ViewHolder();

//	    holder.imageFav = (ImageView) convertView
//		    .findViewById(R.id.imageFav);
	    convertView.setTag(holder);

	} else {
	    holder = (ViewHolder) convertView.getTag();
	}

	// Hiding all setting default
	holder.imageFav.setVisibility(View.GONE);
	return convertView;
    }

    /**
     * Updating results
     * @param movieModels
     */
    public void notifyDataSetChanged(List<MovieModel> movieModels) {
	this.mMovieModels = movieModels;
	this.notifyDataSetChanged();
    }

}
