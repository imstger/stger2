package com.example.anonymity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class FifthActivity extends Activity {
	public TextView ahh;
	public TextView ohh;
    public int i = 1;
    public int j = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        GridView gridView = (GridView)findViewById(R.id.gridView1);
        final int[] img = new int[]{R.drawable.tx1,R.drawable.tx2,R.drawable.tx3,R.drawable.tx4,R.drawable.tx5,R.drawable.tx6,R.drawable.tx7,R.drawable.tx8,R.drawable.tx9};
        String[] intro = new String[]{"头","头像","好头像","看好头像","看好的头像","看好看的头像","看特好看的头像","看特别好看的头像","你看特别好看的头像"};
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for(int i=0;i<img.length;i++){
        	Map<String,Object> map = new HashMap<String,Object>();
        	map.put("img", img[i]);
        	map.put("intro", intro[i]);
        	list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.items2, new String[]{"img","intro"}, new int[]{R.id.imgg,R.id.introo});
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	   @Override
        	   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        		   Intent intent = getIntent();
        		   Bundle bundle = new Bundle();
        		   bundle.putInt("imageId",img[position]);
        		   intent.putExtras(bundle);
        		   setResult(200,intent);
        		   finish();
        		   }
        	  });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
