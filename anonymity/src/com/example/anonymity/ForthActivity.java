package com.example.anonymity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ForthActivity extends Activity {
	
      //用三个数组装载数据
        private String[] names = new String[]{"曼奇", "杰西", "波比"};
        private String[] says = new String[]{"和而不同", "铮铮有词", "深入人心"};
        private int[] imgIds = new int[]{R.drawable.aaa, R.drawable.cat, R.drawable.ic_launcher};
     
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_forth);
     
            List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < names.length; i++) {
                Map<String, Object> showitem = new HashMap<String, Object>();
                showitem.put("touxiang", imgIds[i]);
                showitem.put("name", names[i]);
                showitem.put("says", says[i]);
                listitem.add(showitem);
            }
            //创建一个simpleAdapter
            SimpleAdapter myAdapter = new SimpleAdapter(getApplicationContext(),listitem,
                    R.layout.items,new String[]{"touxiang","name","says"},
                    new int[]{R.id.imgtou,R.id.name,R.id.says});
            ListView listView = (ListView)findViewById(R.id.list_test);
            listView.setAdapter(myAdapter);
            listView.setOnItemClickListener(new OnItemClickListener(){
            	 @Override
                 public void onItemClick(AdapterView<?> arg0, View arg1, 
                         int arg2, long arg3) {
            		 Intent i = null;
            	        switch (arg2){
            	            case 0:
            	                i = new Intent(ForthActivity.this,SixthActivity.class);
            	                break;
            	            case 1:
            	            	i = new Intent(ForthActivity.this,SixthActivity.class);
            	                break;
            	            case 2:
            	            	i = new Intent(ForthActivity.this,SixthActivity.class);
            	                break;
            	            case 3:
            	            	i = new Intent(ForthActivity.this,SixthActivity.class);
            	                break;
            	        }
            	        startActivity(i);
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
