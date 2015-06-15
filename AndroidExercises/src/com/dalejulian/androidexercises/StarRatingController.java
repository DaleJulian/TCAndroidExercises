package com.dalejulian.androidexercises;

import android.view.MotionEvent;

public final class StarRatingController {
	
	private StarRatingModel model;
	
	public StarRatingController(StarRatingModel model){
		this.model = model;
	}

	public void handleTap(MotionEvent event){
		model.setStars((model.getStars() + 1) % (StarRatingModel.MAX_STARS + 1));
	}
}
