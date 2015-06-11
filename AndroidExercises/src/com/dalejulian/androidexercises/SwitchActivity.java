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
	private static final String TAG = "com.dalejulian.androidexercises.SwitchActivity";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sample_switch_firstactivity);
		Log.d(TAG, "MainActivity: onCreate()");

		mButton = (Button) findViewById(R.id.switch_button);
		mButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(SwitchActivity.this,
						SwitchSecondActivity.class);
				startActivityForResult(i, 0);
			}
		});

		mTextView = (TextView) findViewById(R.id.switch_textView);

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (data == null)
			return;

		String text = data.getStringExtra(SwitchSecondActivity.EXTRA_TEXT);
		Log.i("MainAct", text);
		mTextView.setText(text);
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "MainActivity: onStart()");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "MainActivity: onResume()");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "MainActivity: onPause()");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "MainActivity: onStop()");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "MainActivity: onDestroy()");
	}
}
