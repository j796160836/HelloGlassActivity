package com.example.helloglassactivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class HelloActivity extends Activity {

	public static String MY_MESSAGE = "change_text";
	private TextView sampleTextview;
	private int num;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.card_main);

		sampleTextview = (TextView) findViewById(R.id.sample_txt);
	}

	@Override
	protected void onResume() {
		super.onResume();
		registerReceiver(mBroadcast, new IntentFilter(MY_MESSAGE));
	}

	@Override
	protected void onPause() {
		super.onPause();
		unregisterReceiver(mBroadcast);
	}

	private BroadcastReceiver mBroadcast = new BroadcastReceiver() {

		@Override
		public void onReceive(Context mContext, Intent mIntent) {
			// TODO Auto-generated method stub
			if (MY_MESSAGE.equals(mIntent.getAction())) {
				num++;
				if (num % 3 == 0) {
					sampleTextview.setText("I'm lovin' it.");
				} else if (num % 3 == 1) {
					sampleTextview.setText("Oh yeah!");
				} else {
					sampleTextview.setText("Hello, World!");
				}
			}
		}
	};
}
