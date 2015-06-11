package com.dalejulian.androidexercises;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SwitchSecondActivity extends Activity {

	public static final String EXTRA_TEXT = "SwitchSecondActivity.EXTRA_TEXT";
	private EditText mEditText;
	private Button mButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.switch_second_activity);
		
		mEditText = (EditText)findViewById(R.id.secondactivity_editText);
		mButton = (Button)findViewById(R.id.secondactivity_back);
		mButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent();
				i.putExtra(EXTRA_TEXT, mEditText.getText().toString());
				setResult(RESULT_OK, i);
				finish();
				
			}
		});
	}
	
	@Override
	public void onBackPressed(){
		Intent i = new Intent();
		i.putExtra(EXTRA_TEXT, mEditText.getText().toString());
		setResult(RESULT_OK, i);
		finish();
		
	}
}
