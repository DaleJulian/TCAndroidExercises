/*
 * EXERCISE F
 * ANDROID TRAINING MODULE
 * TRAINING CENTER
 */

package com.dalejulian.androidexercises;

import java.util.Date;

import com.dalejulian.androidexercises.DatePickerFragment.ReceiveDateDialogListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SimpleActivity extends FragmentActivity implements ReceiveDateDialogListener{

	private Button mButton;
	private Date mDate = new Date();
	private static final String DIALOG_DATE = "date";
	private static final int REQUEST_DATE = 0;

	private CheckBox mCheckBox;
	
	private EditText mEditText;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_layout);

		mButton = (Button) findViewById(R.id.btn1);
		mButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				FragmentManager fm = getSupportFragmentManager();
				DatePickerFragment dialog = new DatePickerFragment().newInstance(mDate);
				dialog.show(fm, DIALOG_DATE);
			
			}
		});
		
		mCheckBox = (CheckBox)findViewById(R.id.simple_checkBox);
		mCheckBox.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(((CheckBox)v).isChecked()){
					Toast.makeText(getApplicationContext(), "Toggled", Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(), "Untoggled", Toast.LENGTH_LONG).show();
				}
				
			}
		});
		mEditText = (EditText)findViewById(R.id.simple_edittext);
		mEditText.setOnFocusChangeListener(new OnFocusChangeListener(){

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(!hasFocus)
					Toast.makeText(getApplicationContext(), mEditText.getText().toString(), Toast.LENGTH_SHORT);
			}
			
		});
		
	}
	
	public void onCheckBoxClicked(View view){
		boolean isChecked = ((CheckBox)view).isChecked();
		
		if(view.getId() == R.id.simple_checkBox){
			if(isChecked){
				Log.i("CheckBox", "Toggled.");
			} else {
				Log.i("CheckBox", "Untoggled.");
			}
		}
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		if(resultCode == Activity.RESULT_OK) return;
		
		if(requestCode == REQUEST_DATE){
			Date date = (Date)data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
			mDate = date;
			Log.i("Date changed.", mDate.toString());
		}
	}

	@Override
	public void onFinishEditDialog(Date date) {
		mDate = date;
		Log.i("Date changed.", mDate.toString());
		
		Toast.makeText(getApplicationContext(), "Selected date: " + mDate.toString(),
				Toast.LENGTH_LONG).show();
	}
	
	
}
