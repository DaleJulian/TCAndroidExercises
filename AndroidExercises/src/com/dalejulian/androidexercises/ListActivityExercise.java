package com.dalejulian.androidexercises;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ListActivityExercise extends Activity{

	
	private ListView mListview;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_activity);
		
		ShoeBrand shoeBrand_data[] = new ShoeBrand[]{
				new ShoeBrand("Nike"),
				new ShoeBrand("Adidas"),
				new ShoeBrand("New Balance"),
				new ShoeBrand("Saucony"),
				new ShoeBrand("Asics"),
				new ShoeBrand("Vans"),
				new ShoeBrand("Chuck Taylors"),
				new ShoeBrand("Jordan Brand"),
				new ShoeBrand("Buscemi"),
				new ShoeBrand("Y3"),
				new ShoeBrand("Saint Laurent"),
				new ShoeBrand("Balenciaga")
		};
		
		ShoeBrandAdapter adapter = new ShoeBrandAdapter(this, R.layout.fragment_shoe_brand, shoeBrand_data);
		
		mListview = (ListView)findViewById(R.id.listView1);
		mListview.setAdapter(adapter);
		
		
	}
	
}
