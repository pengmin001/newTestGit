package com.example;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import itlanbao.com.R;
@SuppressLint("NewApi")
public class WebActivity extends Activity {
	private WebView mWebView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		mWebView = (WebView) findViewById(R.id.webView);
		Intent i = getIntent();
		String url = i.getStringExtra("url");
		mWebView.loadUrl(url);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
		this.finish();
		default:
		return super.onOptionsItemSelected(item);
		}
		}
}
