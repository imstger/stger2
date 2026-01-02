package com.example.anonymity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
	ImageView iv;
	Button b1;
	Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        iv = (ImageView)findViewById(R.id.imageView1);
        b1 = (Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SecondActivity.this, FifthActivity.class);
				startActivityForResult(intent,200);
			}
		});
        
        
        b2 = (Button)findViewById(R.id.button2);
        CheckBox checkbox = (CheckBox)findViewById(R.id.cB);
        checkbox.setOnCheckedChangeListener(new OnCheckedChangeListener(){
        	@Override
        	public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
        		if(isChecked){
        			b2.setVisibility(View.VISIBLE);
        		}else{
        			b2.setVisibility(View.INVISIBLE);
        		}
        		b2.invalidate();
        	}
        });
        
        final EditText et3 = (EditText)findViewById(R.id.editText3);
        et3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new Builder(SecondActivity.this);
		        builder.setTitle("选择地点");
		        final String[] city = new String[]{"无人区","高速公路","冥王星","南极洲","摩尔庄园","北冰洋"};
		        builder.setSingleChoiceItems(city, 0, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						String str = city[arg1].toString();
						et3.setText(str);
					}
				});
		        builder.setNeutralButton("OK", null);
		        builder.create().show();
			}
		});
        
        final String username = "dachang";
        final String password = "1314";
        final EditText et1 = (EditText)findViewById(R.id.editText1);
        final EditText et2 = (EditText)findViewById(R.id.editText2);
        final String et1c = et1.getText().toString();
        final String et2c = et2.getText().toString();
        final String et3c = et3.getText().toString();
        b2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String et1c = et1.getText().toString();
	            String et2c = et2.getText().toString();
	            String et3c = et3.getText().toString();
				// TODO Auto-generated method stub
				if(et1c.equals(username)&&et2c.equals(password)){
					Bundle bundle = new Bundle();
					bundle.putString("username", et1c);
					bundle.putString("region", et3c);
					Toast.makeText(SecondActivity.this, "体验中...", Toast.LENGTH_SHORT).show();
					Intent intent =  new Intent(SecondActivity.this,ThirdActivity.class);
					intent.putExtras(bundle);
					startActivity(intent);
					finish();
				}else if(et1c == null || et2c == null || et1c.equals("") || et2c.equals("")){
					Builder builder = new Builder(SecondActivity.this);
					builder.setMessage("哼~你是不是没填");
					builder.setNeutralButton("好哦", new OnClickListener(){

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
						}
						
					});
					builder.create().show();
				}else if(!et1c.equals(username)&&et2c.equals(password)){
					Builder builder = new Builder(SecondActivity.this);
					builder.setMessage("用户名错了哦");
					builder.setNeutralButton("好哦", new OnClickListener(){

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
						}
						
					});
					builder.create().show();
				}
				else if(et1c.equals(username)&&!et2c.equals(password)){
					Builder builder = new Builder(SecondActivity.this);
					builder.setMessage("密码错了哦");
					builder.setNeutralButton("好哦", new OnClickListener(){

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
						}
						
					});
					builder.create().show();
				}else{
					Builder builder = new Builder(SecondActivity.this);
					builder.setMessage("哎呀哎呀，都错了呢,需要提示嘛~~");
					builder.setPositiveButton("好的呢", new OnClickListener(){

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Builder builder = new Builder(SecondActivity.this);
							builder.setMessage("和我就是一生一世");
							builder.setNeutralButton("okurrrr", new OnClickListener(){

								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									Toast.makeText(SecondActivity.this, "你真是个小聪明呢啊哈哈", Toast.LENGTH_SHORT).show();
								}
								
							});
							builder.create().show();
						}
						
					});
					builder.setNegativeButton("切切切", new OnClickListener(){

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Toast.makeText(SecondActivity.this, "我很抱歉。。。", Toast.LENGTH_SHORT).show();
						}
						
					});
					builder.create().show();
					
				}
				
			}
		});
        
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
   
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==200 && resultCode == 200)
        {
        	Bundle bundle = data.getExtras();
        	int imageId = bundle.getInt("imageId");
        	iv = (ImageView)findViewById(R.id.imageView1);
        	iv.setImageResource(imageId);
        }
    }
}

