package com.dalejulian.androidexercises;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SampleFragment1 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
		
		View v = inflater.inflate(R.layout.sample_fragment1, parent, false);
		
		return v;
	}
}
