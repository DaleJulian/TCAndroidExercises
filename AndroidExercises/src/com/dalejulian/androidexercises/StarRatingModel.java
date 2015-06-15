package com.dalejulian.androidexercises;

import java.util.ArrayList;
import java.util.List;

public class StarRatingModel {

	public static final int MAX_STARS = 5;

	public interface StarRatingChangedListener {
		void handleStarRatingChanged(StarRatingModel sender);
	}

	private int stars = 1;

	private List<StarRatingChangedListener> listeners = new ArrayList<StarRatingChangedListener>();

	public StarRatingModel() {

	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		if (stars > MAX_STARS) {
			stars = MAX_STARS;
		} else if (stars < 0) {
			stars = 0;
		}
		if (stars != this.stars) {
			this.stars = stars;

			for (StarRatingChangedListener listener : listeners) {
				listener.handleStarRatingChanged(this);
			}
		}
	}

	public void addListener(StarRatingChangedListener listener) {
		this.listeners.add(listener);
	}

	public void removeListener(StarRatingChangedListener listener) {
		this.listeners.remove(listener);
	}

}
