package com.dalejulian.androidexercises;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

public class DatePickerFragment extends DialogFragment {
	
	public static final String EXTRA_DATE = "DatePickerFragment.DATE";
	Date mDate;
	
	public interface ReceiveDateDialogListener{
		void onFinishEditDialog(Date date);
	}
	
	
	public static DatePickerFragment newInstance(Date date) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_DATE, date);
        
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);

        return fragment;
    }
	
	private void sendResult(int resultCode) {
        if (getTargetFragment() == null) 
            return;

        Intent i = new Intent();
        i.putExtra(EXTRA_DATE, mDate);
        this.dismiss();
       
//        getTargetFragment()
//            .onActivityResult(getTargetRequestCode(), resultCode, i);
    }
	
	ReceiveDateDialogListener activity;
	
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mDate = (Date)getArguments().getSerializable(EXTRA_DATE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        View v = getActivity().getLayoutInflater()
            .inflate(R.layout.dialog_date, null);

        DatePicker datePicker = (DatePicker)v.findViewById(R.id.dialog_date_datePicker);
        datePicker.init(year, month, day, new OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year, int month, int day) {
                mDate = new GregorianCalendar(year, month, day).getTime();

                // update argument to preserve selected value on rotation
                getArguments().putSerializable(EXTRA_DATE, mDate);
            }
        });

        activity = 	(ReceiveDateDialogListener) getActivity();
        
        return new AlertDialog.Builder(getActivity())
            .setView(v)
            .setTitle("Pick date")
            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    activity.onFinishEditDialog(mDate);
                	sendResult(Activity.RESULT_OK);
                }
            }).create();
    }
}
