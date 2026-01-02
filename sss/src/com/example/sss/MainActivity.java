package com.example.sss;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity {
	private TabHost tab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    tab = (TabHost)findViewById(android.R.id.tabhost);
	    tab.setup();
	    LayoutInflater inflater = LayoutInflater.from(this);
	    inflater.inflate(R.layout.item1, tab.getTabContentView());
	    inflater.inflate(R.layout.item2, tab.getTabContentView());
	    TabSpec tb1 = tab.newTabSpec("tab01");
	    tb1.setIndicator("small");
	    tb1.setContent(R.id.textView1);
	    tab.addTab(tb1);
	    tab.addTab(tab.newTabSpec("tab02").setIndicator("big").setContent(R.id.textView2));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
