package com.example.anonymity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends Activity {
	TextView tv1;
	TextView tv2;
	TextView tv3;
	TextView tv4;
    RadioButton rb1;
    RadioButton rb2;
    RadioGroup rg;
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        TextView[] tv = new TextView[]{tv1,tv2,tv3,tv4};
        for(int i=0;i<tv.length;i++){
        	registerForContextMenu(tv[i]);       	
        }
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        tv2.setText(bundle.getString("region"));
        tv4.setText(bundle.getString("username"));
        rb1 = (RadioButton)findViewById(R.id.radio0);
        rb2 = (RadioButton)findViewById(R.id.radio1);
        rg = (RadioGroup)findViewById(R.id.radioGroup1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if(arg1 == rb1.getId()){
					Toast.makeText(ThirdActivity.this, "唱歌呀", 5).show();
				}
				if(arg1 == rb2.getId()){
					Toast.makeText(ThirdActivity.this, "摄影呀", 5).show();
				}
			}
		});
        
        cb1 = (CheckBox)findViewById(R.id.checkBox1);
        cb2 = (CheckBox)findViewById(R.id.checkBox2);
        cb3 = (CheckBox)findViewById(R.id.checkBox3);
        cb4 = (CheckBox)findViewById(R.id.checkBox4);
        b1 = (Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String r = "原来你还喜欢";
				if(cb1.isChecked()){
					r = r + " " + cb1.getText();
				}
				if(cb2.isChecked()){
					r = r + " " + cb2.getText();
				}
				if(cb3.isChecked()){
					r = r + " " + cb3.getText();
				}
				if(cb4.isChecked()){
					r = r + " " + cb4.getText();
				}
				Toast.makeText(ThirdActivity.this, r, 5).show();
				Intent intent = new Intent(ThirdActivity.this, ForthActivity.class);
				intent.putExtra("r", r);
				startActivity(intent);
				finish();
			}
		});
        
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        String[] shaya = new String[]{"请选择","书法","吉他"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, shaya);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, 
                    int pos, long id) {
           
            	String shaya = parent.getItemAtPosition(pos).toString();
            	if(shaya == "请选择"){
            		
            	}else{
            		Toast.makeText(ThirdActivity.this, "哇哦~原来你喜欢"+shaya, 200).show();
            	}
                
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.op, menu);
        return true;
    }
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
    	switch(item.getItemId()){
    	case R.id.wo1:
    		tv1.setTextSize(13);
    		tv2.setTextSize(13);
    		tv3.setTextSize(13);
    		tv4.setTextSize(13);
    		break;
    	case R.id.wo2:
    		tv1.setTextSize(22);
    		tv2.setTextSize(22);
    		tv3.setTextSize(22);
    		tv4.setTextSize(22);
    		break;
    	case R.id.wo3:
    		tv1.setTextSize(35);
    		tv2.setTextSize(35);
    		tv3.setTextSize(35);
    		tv4.setTextSize(35);
    		break;
    	default:
    		tv1.setTextSize(28);
    		tv2.setTextSize(28);
    		tv3.setTextSize(28);
    		tv4.setTextSize(28);
		}
		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.cont, menu);
        menu.setHeaderIcon(R.drawable.ic_launcher);
        menu.setHeaderTitle("有啥颜色");
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
    	case R.id.owo1:
    		tv1.setTextColor(Color.parseColor("#ed556a"));
    		tv2.setTextColor(Color.parseColor("#ed556a"));
    		tv3.setTextColor(Color.parseColor("#ed556a"));
    		tv4.setTextColor(Color.parseColor("#ed556a"));
    		break;
    	case R.id.owo2:
    		tv1.setTextColor(Color.parseColor("#12aa9c"));
    		tv2.setTextColor(Color.parseColor("#12aa9c"));
    		tv3.setTextColor(Color.parseColor("#12aa9c"));
    		tv4.setTextColor(Color.parseColor("#12aa9c"));
    		break;
    	case R.id.owo3:
    		tv1.setTextColor(Color.parseColor("#2f90b9"));
    		tv2.setTextColor(Color.parseColor("#2f90b9"));
    		tv3.setTextColor(Color.parseColor("#2f90b9"));
    		tv4.setTextColor(Color.parseColor("#2f90b9"));
    		break;
    	default:
    		tv1.setTextColor(Color.parseColor("#fff"));
    		tv2.setTextColor(Color.parseColor("#fff"));
    		tv3.setTextColor(Color.parseColor("#fff"));
    		tv4.setTextColor(Color.parseColor("#fff"));
		}
    	return true;
	}
    
}



