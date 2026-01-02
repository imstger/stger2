package com.example.anonymity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SeventhActivity extends Activity {
	public TextView ahh;
	public TextView ohh;
    public int i = 1;
    public int j = 1;
    TextView textView1;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);
        ahh = (TextView)findViewById(R.id.ahh);
        ohh = (TextView)findViewById(R.id.ohh);
        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        registerForContextMenu(textView2);
        ImageButton ib1 = (ImageButton)findViewById(R.id.imageButton1);
        ib1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ahh.setText("µ„‘ﬁ +"+(i++));
			}
		});
        
        ImageButton ib2 = (ImageButton)findViewById(R.id.imageButton2);
        ib2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ohh.setText("Õ¬≤€ +"+(j++));
			}
		});
        
        ImageButton iB = (ImageButton)findViewById(R.id.iB);
        iB.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast tt = new Toast(SeventhActivity.this);
				LinearLayout ll = new LinearLayout(SeventhActivity.this);
				ll.setOrientation(1);
				ImageView iv = new ImageView(SeventhActivity.this);
				iv.setImageResource(R.drawable.ic_launcher);
				ll.addView(iv);
				TextView tv = new TextView(SeventhActivity.this);
				tv.setText("Õ€Õ€Õ€£¨ƒ„÷’”⁄’“µΩŒ“¡À£¨∞°π˛π˛π˛π˛~");
				tv.setTextColor(Color.argb(147, 181, 207, 255));
				ll.addView(tv);
				tt.setDuration(15);
				tt.setGravity(Gravity.TOP, 0, 55);
				tt.setView(ll);
				tt.show();
				Intent intent = new Intent(SeventhActivity.this,SecondActivity.class);
				startActivity(intent);
				finish();
			}
		});
        
        final int[] im = new int[]{R.drawable.o1,R.drawable.o2,R.drawable.o3,R.drawable.o4,R.drawable.o5};
        BaseAdapter adapter = new BaseAdapter(){

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return im.length;
			}

			@Override
			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return arg0;
			}

			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return arg0;
			}

			@Override
			public View getView(int arg0, View arg1, ViewGroup arg2) {
				// TODO Auto-generated method stub
				ImageView imageView;
				if(arg1 == null){
					imageView = new ImageView(SeventhActivity.this);
					imageView.setScaleType(ImageView.ScaleType.FIT_XY);
					imageView.setLayoutParams(new Gallery.LayoutParams(220, 180));
					imageView.setPadding(5, 10, 5, 0);
				}else{
					imageView = (ImageView)arg1;
				}
				imageView.setImageResource(im[arg0]);
				return imageView;
			}
        	
        };
        Gallery gallery = (Gallery)findViewById(R.id.gallery1);
        gallery.setAdapter(adapter);
        gallery.setSelection(im.length/2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.op, menu);
        return true;
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
    	case R.id.wo1:
    		textView1.setTextSize(13);
    		break;
    	case R.id.wo2:
    		textView1.setTextSize(22);
    		break;
    	case R.id.wo3:
    		textView1.setTextSize(35);
    		break;
    	default:
    		textView1.setTextSize(28);
		}
		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.cont, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
    	case R.id.owo1:
    		textView2.setTextColor(Color.parseColor("#ed556a"));
    		break;
    	case R.id.owo2:
    		textView2.setTextColor(Color.parseColor("#12aa9c"));
    		break;
    	case R.id.owo3:
    		textView2.setTextColor(Color.parseColor("#2f90b9"));
    		break;
    	default:
    		textView2.setTextColor(Color.parseColor("#fff"));
		}
    	return true;
	}
    
}
