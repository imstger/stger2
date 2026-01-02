package com.example.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
	Button one;
	Button two;
	Button three;
	Button four;
	Button five;
	Button six;
	Button seven;
	Button eight;
	Button nine;
	Button zero;
	Button add;
	Button sub;
	Button mul;
	Button div;
	Button equ;
	Button clear;
	EditText ed;
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed = (EditText)findViewById(R.id.editText1);
		one = (Button)findViewById(R.id.one);
		two = (Button)findViewById(R.id.two);
		three = (Button)findViewById(R.id.three);
		four = (Button)findViewById(R.id.four);
		five = (Button)findViewById(R.id.five);
		six = (Button)findViewById(R.id.six);
		seven = (Button)findViewById(R.id.seven);
		eight = (Button)findViewById(R.id.eight);
		nine = (Button)findViewById(R.id.nine);
		zero = (Button)findViewById(R.id.zero);
		add = (Button)findViewById(R.id.add);
		sub = (Button)findViewById(R.id.sub);
		mul = (Button)findViewById(R.id.mul);
		div = (Button)findViewById(R.id.div);
		equ = (Button)findViewById(R.id.equ);
		clear = (Button)findViewById(R.id.clear);
		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		four.setOnClickListener(this);
		five.setOnClickListener(this);
		six.setOnClickListener(this);
		seven.setOnClickListener(this);
		eight.setOnClickListener(this);
		nine.setOnClickListener(this);
		zero.setOnClickListener(this);
		add.setOnClickListener(this);
		sub.setOnClickListener(this);
		mul.setOnClickListener(this);
		div.setOnClickListener(this);
		equ.setOnClickListener(this);
		clear.setOnClickListener(this);
		tv = (TextView)findViewById(R.id.textView1);
	}
	

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String ed1 = ed.getText().toString();
		switch(arg0.getId()){
		case R.id.one:
		case R.id.two:
		case R.id.three:
		case R.id.four:
		case R.id.five:
		case R.id.six:
		case R.id.seven:
		case R.id.eight:
		case R.id.nine:
		case R.id.zero:
			 ed.append(((Button) arg0).getText());
			 ed1 = ed.getText().toString();
			 break;
		case R.id.add:
		case R.id.sub:
		case R.id.mul:
		case R.id.div:
			ed.append(((Button)arg0).getText());
			ed1 = ed.getText().toString();
			break;
		case R.id.equ:
			ed.append(((Button)arg0).getText());
			ed1 = ed.getText().toString();
			ed.setText(getResult(ed1));
			break;
		case R.id.clear:
			ed.setText("");
			break;
		}
		tv.setText(ed1);
		
	}

	private String getResult(String ed1) {
		// TODO Auto-generated method stub
		String num = ed1;
		String num1,num2;
		double a,b;
		if(ed1.contains("+")){
			num1 = ed1.substring(0,ed1.indexOf("+"));
			num2 = ed1.substring(ed1.indexOf("+")+1,ed1.indexOf("="));
			a = Double.parseDouble(num1);
			b = Double.parseDouble(num2);
			ed1 = String.valueOf(a+b);
			return num + ed1;
		}else if(ed1.contains("-")){
			num1 = ed1.substring(0,ed1.indexOf("-"));
			num2 = ed1.substring(ed1.indexOf("-")+1,ed1.indexOf("="));
			a = Double.parseDouble(num1);
			b = Double.parseDouble(num2);
			ed1 = String.valueOf(a-b);
			return num + ed1;
		}else if(ed1.contains("*")){
			num1 = ed1.substring(0,ed1.indexOf("*"));
			num2 = ed1.substring(ed1.indexOf("*")+1,ed1.indexOf("="));
			a = Double.parseDouble(num1);
			b = Double.parseDouble(num2);
			ed1 = String.valueOf(a*b);
			return num + ed1;
		}else if(ed1.contains("/")){
			num1 = ed1.substring(0,ed1.indexOf("/"));
			num2 = ed1.substring(ed1.indexOf("/")+1,ed1.indexOf("="));
			a = Double.parseDouble(num1);
			b = Double.parseDouble(num2);
			ed1 = String.valueOf(a/b);
			return num + ed1;
		}
		return ed1;
		
//		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
