/*
 * EXERCISE F
 * ANDROID TRAINING MODULE
 * TRAINING CENTER
 */

package com.dalejulian.androidexercises;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class SimpleActivity extends Activity {

	
	private Button mCenterButton;
	private Button mControlButtons[] = new Button[4];
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_layout);
		
		mControlButtons[0] = (Button)findViewById(R.id.btn1);
		mControlButtons[1] = (Button)findViewById(R.id.btn2);
		mControlButtons[2] = (Button)findViewById(R.id.btn3);
		mControlButtons[3] = (Button)findViewById(R.id.btn4);
		mCenterButton = (Button)findViewById(R.id.btn5);
		
		mControlButtons[0].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCenterButton.setText("Clone of Button 1");
			}
		});
		
		mControlButtons[1].setOnClickListener(new View.OnClickListener() {
					
			@Override
			public void onClick(View v) {
				mCenterButton.setText("Clone of Button 2");
			}
		});
		
		mControlButtons[2].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCenterButton.setText("Clone of Button 3");
			}
		});
		
		mControlButtons[3].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCenterButton.setText("Clone of Button 4");
			}
		});
	}
}
