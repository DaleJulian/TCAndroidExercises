package com.dalejulian.androidexercises;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ShoeBrandAdapter extends ArrayAdapter<ShoeBrand> {

	Context context;
	int layoutResourceId;
	ShoeBrand[] data = null;

	static class BrandHolder {
		TextView textView;
		ImageView thumbnail;
	}

	public ShoeBrandAdapter(Context context, int layoutResourceId,
			ShoeBrand[] data) {
		super(context, layoutResourceId, data);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.data = data;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		BrandHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);

			holder = new BrandHolder();
			holder.textView = (TextView) row
					.findViewById(R.id.textview_shoe_brand);
			holder.thumbnail = (ImageView) row.findViewById(R.id.imgIcon);

			row.setTag(holder);
		} else {
			holder = (BrandHolder) row.getTag();
		}

		ShoeBrand brand = data[position];
		holder.textView.setText(brand.shoeBrand);
		// holder.thumbnail.setImageResource(brand.thumbnailId);

		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		int imageHeight = options.outHeight;
		int imageWidth = options.outWidth;

		Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
				brand.thumbnailId, options);

		// holder.thumbnail.setImageBitmap(bitmap);
		holder.thumbnail.setImageBitmap(decodeSampledBitmapFromResource(
				context.getResources(), brand.thumbnailId, 25, 25));
		return row;
	}

	public static int calculateInSampleSize(BitmapFactory.Options options,
			int reqWidth, int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			final int halfHeight = height / 2;
			final int halfWidth = width / 2;

			// Calculate the largest inSampleSize value that is a power of 2 and
			// keeps both
			// height and width larger than the requested height and width.
			while ((halfHeight / inSampleSize) > reqHeight
					&& (halfWidth / inSampleSize) > reqWidth) {
				inSampleSize *= 2;
			}
		}

		return inSampleSize;
	}

	public static Bitmap decodeSampledBitmapFromResource(Resources res,
			int resId, int reqWidth, int reqHeight) {

		// First decode with inJustDecodeBounds=true to check dimensions
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, resId, options);

		// Calculate inSampleSize
		options.inSampleSize = calculateInSampleSize(options, reqWidth,
				reqHeight);

		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(res, resId, options);
	}
}
