package com.dalejulian.androidexercises;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SwitchActivity extends Activity {

	private Button mButton;
	private TextView mTextView;
	
	@Override 
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sample_switch_firstactivity);
	
		mButton = (Button)findViewById(R.id.switch_button);
		mButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(SwitchActivity.this, SwitchSecondActivity.class);
				startActivityForResult(i, 0);
			}
		});
		
		mTextView = (TextView)findViewById(R.id.switch_textView);
	
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		if(data == null) return;
		
		String text = data.getStringExtra(SwitchSecondActivity.EXTRA_TEXT);
		Log.i("MainAct", text);
		mTextView.setText(text);
	}
}
