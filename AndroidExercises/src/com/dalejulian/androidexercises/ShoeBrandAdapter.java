package com.dalejulian.androidexercises;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ShoeBrandAdapter extends ArrayAdapter<ShoeBrand>{

	
	Context context;
	int layoutResourceId;
	ShoeBrand[] data = null;
	
	static class BrandHolder{
		TextView textView;
	}
	
	public ShoeBrandAdapter(Context context, int layoutResourceId, ShoeBrand[] data){
		super(context, layoutResourceId, data);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.data = data;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		View row = convertView;
		BrandHolder holder = null;
		
		if(row == null){
			LayoutInflater inflater = ((Activity)context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);
			
			holder = new BrandHolder();
			holder.textView = (TextView)row.findViewById(R.id.textview_shoe_brand);
			
			row.setTag(holder);
		} else {
			holder = (BrandHolder)row.getTag();
		}
		
		ShoeBrand brand = data[position];
		holder.textView.setText(brand.shoeBrand);
		
		return row;
	}
}

