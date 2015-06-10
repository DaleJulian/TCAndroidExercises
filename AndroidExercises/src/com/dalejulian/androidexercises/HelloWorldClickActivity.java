package com.dalejulian.androidexercises;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HelloWorldClickActivity extends Activity {

	private Button mHelloWorldButton;
	private TextView mTextView;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hello_world_activity);
		
		mTextView = (TextView)findViewById(R.id.hello_world_textview);
		
		mHelloWorldButton = (Button)findViewById(R.id.hello_world_button);
		mHelloWorldButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Hello world!", Toast.LENGTH_LONG).show();
				mTextView.setText("Hello World!");
			}
		});
		
		
		
	}
}
