package com.dalejulian.androidexercises;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SampleContextMenuActivity extends Activity {

	private TextView textColor, textSize;

	final int MENU_COLOR_RED = 1;
	final int MENU_COLOR_GREEN = 2;
	final int MENU_COLOR_BLUE = 3;

	final int MENU_SIZE_22 = 4;
	final int MENU_SIZE_26 = 5;
	final int MENU_SIZE_30 = 6;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.context_menu_activity);

		textColor = (TextView) findViewById(R.id.context_textColor);
		textSize = (TextView) findViewById(R.id.context_textViewSize);

		registerForContextMenu(textColor);
		registerForContextMenu(textSize);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo info) {

		switch (v.getId()) {
		case R.id.context_textColor:
			menu.add(0, MENU_COLOR_RED, 0, "Red");
			menu.add(0, MENU_COLOR_GREEN, 0, "Green");
			menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
			break;
		case R.id.context_textViewSize:
			menu.add(0, MENU_SIZE_22, 0, "22");
			menu.add(0, MENU_SIZE_26, 0, "26");
			menu.add(0, MENU_SIZE_30, 0, "30");
			break;
		}
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		// menu items for textColor
		case MENU_COLOR_RED:
			textColor.setTextColor(Color.RED);
			textColor.setText("Text color = red");
			break;
		case MENU_COLOR_GREEN:
			textColor.setTextColor(Color.GREEN);
			textColor.setText("Text color = green");
			break;
		case MENU_COLOR_BLUE:
			textColor.setTextColor(Color.BLUE);
			textColor.setText("Text color = blue");
			break;
		// menu items for textSize
		case MENU_SIZE_22:
			textSize.setTextSize(22);
			textSize.setText("Text size = 22");
			break;
		case MENU_SIZE_26:
			textSize.setTextSize(26);
			textSize.setText("Text size = 26");
			break;
		case MENU_SIZE_30:
			textSize.setTextSize(30);
			textSize.setText("Text size = 30");
			break;
		}
		return super.onContextItemSelected(item);
	}
}
