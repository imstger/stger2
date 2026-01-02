package com.example.anonymity;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends TabActivity {
	private TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        tabHost = (TabHost)findViewById(android.R.id.tabhost);
//        tabHost.setup();
//        LayoutInflater inflater = LayoutInflater.from(this);
//        inflater.inflate(R.layout.tab1, tabHost.getTabContentView());
//        inflater.inflate(R.layout.tab2, tabHost.getTabContentView());
//        inflater.inflate(R.layout.tab3, tabHost.getTabContentView());
//        TabSpec tb1 = tabHost.newTabSpec("tab01");
//        tb1.setIndicator("small");
//        tb1.setContent(R.id.LinearLayout01);
//        tabHost.addTab(tb1);
//        
//        tabHost.addTab(tabHost.newTabSpec("tab02").setIndicator("medium").setContent(R.id.LinearLayout02));
//        tabHost.addTab(tabHost.newTabSpec("tab03").setIndicator("large").setContent(R.id.LinearLayout03));
        
        tabHost = getTabHost();
        TabSpec tb1 = tabHost.newTabSpec("index");
        tb1.setIndicator("home");
        tb1.setContent(new Intent(this, SeventhActivity.class));
        tabHost.addTab(tb1);
        tabHost.addTab(tabHost.newTabSpec("self").setIndicator("search").setContent(new Intent(this, Search.class)));
        tabHost.setCurrentTab(0);
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}