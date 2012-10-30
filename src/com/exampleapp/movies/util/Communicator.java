package com.exampleapp.movies.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Communicator {
    public String executeHttpGet(String URL) {
	BufferedReader in = null;
	try {
	    HttpClient client = new DefaultHttpClient();
	    HttpGet request = new HttpGet();
	    // request.setHeader("Content-Type", "text/plain; charset=utf-8");
	    request.setURI(new URI(URL));
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