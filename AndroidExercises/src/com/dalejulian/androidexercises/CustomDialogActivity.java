package com.dalejulian.androidexercises;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

public class CustomDialogActivity extends FragmentActivity{

	private Button mButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_dialog_fragment);

		mButton = (Button) findViewById(R.id.customdialog_showButton);
		mButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
//				FragmentManager fm = getSupportFragmentManager();
//				DatePickerFragment dialog = new DatePickerFragment().newInstance(mDate);
//				dialog.show(fm, DIALOG_DATE);
				
				FragmentManager fm = getSupportFragmentManager();
				SimpleAlertDialogFragment dialog = new SimpleAlertDialogFragment().newInstance();
				dialog.show(fm, "Missile Dialog");
				
			}
		});
	}
}
