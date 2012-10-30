package com.exampleapp.movies.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.exampleapp.movies.R;

public class DownloadHelper extends
	AsyncTask<String, Integer, List<MovieModel>> {

    private Activity mActivity;
    private String mUrl;
    private LinearLayout mLoadingLayout;
    private boolean isDownloading = false;
    private boolean isFinished = false;
    private ListView mListView;
    private List<MovieModel> mMovieModels;
    private CustomAdapter mAdapter;

    /**
     * Creating download helper
     * 
     * @param activity
     */
    public DownloadHelper(Activity activity) {
	this.mActivity = activity;
    }

    @Override
    protected void onPreExecute() {
	this.isDownloading = true;
	this.showLoading(true);
    }

    @Override
    protected List<MovieModel> doInBackground(String... params) {
	String page = "[" + executeHttpGet(params[0]) + "]";

	try {
	    JSONArray jsonArray = new JSONArray(page);
	    for (int i = 0; i < jsonArray.length(); i++) {
		JSONObject entry = (JSONObject) jsonArray.get(i);
		// now get the data from each entry
	    }
	} catch (JSONException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    protected void onPostExecute(List<MovieModel> result) {
	this.showLoading(false);

	//
    }

    /**
     * Starting new download Canceling old
     * 
     * @param string
     */
    public void startDownload(String url) {
	this.mUrl = url;
	this.execute(url);
    }

    /**
     * Setting loading layout Showing if currently downloading
     * 
     * @param mLoadingLayout
     */
    public void setLoadingUi(LinearLayout mLoadingLayout) {
	this.mLoadingLayout = mLoadingLayout;

	showLoading(isDownloading);
    }

    /**
     * Showing or hiding loading layout
     * 
     * @param isShow
     */
    private void showLoading(boolean isShow) {
	if (this.mLoadingLayout != null) {
	    this.mLoadingLayout.setVisibility(View.VISIBLE);
	}
    }

    /**
     * Setting list ui Showing if some thing is ready to be shown
     * 
     * @param mListView
     */
    public void setListUi(ListView mListView) {
	this.mListView = mListView;

	if (isFinished) {
	    showResults();
	}
    }

    /**
     * Setting all downloading content to list view
     */
    private void showResults() {
	if (mAdapter == null) {
	    mAdapter = new CustomAdapter(mActivity, mMovieModels);
	    mListView.setAdapter(mAdapter);
	} else {
	    mAdapter.notifyDataSetChanged(mMovieModels);
	}

    }

//    /**
//     * Stopping all downloads
//     */
//    public void pause() {
//	this.cancel(false);
//    }

//    /**
//     * Relaunching old download
//     */
//    public void resume() {
//	// TODO check that url is fine
//	this.execute(this.mUrl);
//    }

    private String executeHttpGet(String URL) {
	BufferedReader in = null;
	try {
	    HttpClient client = new DefaultHttpClient();
	    HttpGet request = new HttpGet();
//	    request.setHeader("Content-Type", "text/html;");
	    
	    request.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	    
	    List<NameValuePair> params = new LinkedList<NameValuePair>();
	    params.add(new BasicNameValuePair("api_key", mActivity.getString(R.string.apiKey)));
	    String paramString = URLEncodedUtils.format(params, "utf-8");
	    String urlWithParams = URL + "?" + paramString;
	    
	    request.setURI(new URI(urlWithParams));
	    
	    HttpResponse response = client.execute(request);
	    in = new BufferedReader(new InputStreamReader(response.getEntity()
		    .getContent()));

	    StringBuffer sb = new StringBuffer("");
	    String line = "";

	    String NL = System.getProperty("line.separator");
	    while ((line = in.readLine()) != null) {
		sb.append(line + NL);
	    }
	    in.close();
	    String page = sb.toString();
	    return page;
	} catch (URISyntaxException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IllegalStateException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    if (in != null) {
		try {
		    in.close();
		} catch (IOException e) {
		    // TODO: log error
		}
	    }
	}
	return null;
    }
    
}
