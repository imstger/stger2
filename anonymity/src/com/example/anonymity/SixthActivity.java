package com.example.anonymity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class SixthActivity extends Activity{
	SQLiteOpenHelper helper;
	Button z,s,g,c;
	SQLiteDatabase db;
	EditText w;
	ListView l;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        helper = new DataBaseHelp(this);
        z = (Button)findViewById(R.id.z);
        z.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				w = (EditText)findViewById(R.id.w);
				String w1 = w.getText().toString();
				db = helper.getWritableDatabase();
				db.execSQL("insert into memo(words)"+"values('"+w1+"')");
				db.close();
				w.setText("");
			}
		});
        
        s = (Button)findViewById(R.id.s);
        s.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				db = helper.getWritableDatabase();
				db.execSQL("delete from memo");
				db.close();
			}
		});
        
        g = (Button)findViewById(R.id.g);
        g.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(SixthActivity.this, "nonono", 5);
			}
		});
        
        c = (Button)findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				db = helper.getReadableDatabase();
				List<String> list = new ArrayList<String>();
				Cursor rs = db.rawQuery("select * from memo", null);
				while(rs.moveToNext()){
					list.add(rs.getString(0));
				}
				l = (ListView)findViewById(R.id.l);
				ArrayAdapter<String> ad = new ArrayAdapter<String>(SixthActivity.this,android.R.layout.simple_list_item_1,list);
				l.setAdapter(ad);
				db.close();
			}
		});
 
}

	@Override
	protected void onDestroy(){
		super.onDestroy();
		helper.close();
	}

}
