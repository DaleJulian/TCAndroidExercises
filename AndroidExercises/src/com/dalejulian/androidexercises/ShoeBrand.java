package com.dalejulian.androidexercises;

import android.widget.ImageView;



public class ShoeBrand {

	public String shoeBrand;
	public int thumbnailId;
	
	public ShoeBrand(){
		super();
	}
	
	public ShoeBrand(String shoeBrand, int thumbnailId){
		this.shoeBrand = shoeBrand;
		this.thumbnailId = thumbnailId;
	}
	
	public ShoeBrand(String brand){
		shoeBrand = brand;
	}
	
}
