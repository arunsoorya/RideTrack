/*@(#)BaseActivity.java
 */
package com.myandroidkid.ridetrack.views;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

/**
 * @author arunkumar.s,arunkumar.s@experionglobal.com
 * <br>Apr 24, 2013
 * <br>Package:- <b>{com.amisafe.app.views</b>
 * <br>Project:- <b>{AmISafe</b>
 * <p>
 */
public abstract class BaseActivity extends FragmentActivity {

	/** The activity finish receiver. */
	private ActivityFinishReceiver activityFinishReceiver;
	/** This method is called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		registerActivityFinishReceiver();
	}
	/**
	 * This is the method that calls when the user navigates back to the
	 * activity.
	 */
	@Override
	protected void onStart() {
		super.onStart();
		ViewConstants.isToBackground = false;
		if (ViewConstants.previousContext != null
				&& ViewConstants.previousContext == this) {
			appComingFromBackground();
		}
	}

	/**
	 * This is the method that calls when this activity comes to foreground from
	 * the event caused by a phone call or the phone get locked
	 */
	@Override
	protected void onResume() {
		super.onResume();
	}

	/**
	 * This is the method that calls when user clicks home button. But will not
	 * call when activity automatically goes to background as a result of an
	 * incoming call.
	 */
	@Override
	protected void onUserLeaveHint() {
		super.onUserLeaveHint();
		/* The below two line can be also write in onPause() instead of here. 
		 * But if we right there, the 
		 * appComingFromBackground() will call after a call has come.*/

	}

	/**
	 * 
	 * <p>
	 * This is the method for .
	 * </p>
	 * @return
	 */
	protected Context getCurrentContext() {
		return this;
	}

	/**
	 * This is the method that calls when another activity comes foreground over
	 * this activity or a phone call occures or even when the phone get locked
	 */
	@Override
	protected void onPause() {
		super.onPause();
		ViewConstants.previousContext = this;
		ViewConstants.isToBackground = true;
	}

	/**
	 * This is the method that calls when this activity is no longer visible due
	 * to user navigates to another activity.
	 */
	@Override
	protected void onStop() {
		super.onStop();
		if (ViewConstants.isToBackground) {
			appGoingToBackground();
		}
	}

	/**
	 * This is the method that calls to destroy the activity when user
	 * explicitly calls the finish() method or presses back button.
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		unRegisterActivityFinishReceiver();
	}

	/** This method is called when the application going to background. */
	public abstract void appGoingToBackground();

	/** This method is called when the application coming from background. */
	public abstract void appComingFromBackground();

	/**
	 * 
	 * <p>
	 * This is the method for registerActivityFinishReceiver.
	 * </p>
	 */
	private void registerActivityFinishReceiver() {
		activityFinishReceiver = new ActivityFinishReceiver();
		try {
			registerReceiver(activityFinishReceiver, IntentFilter.create(
					ViewConstants.FINISH, ViewConstants.INTENT_TYPE_BROADCAST));
		} catch (Exception e) {
			Log.d("Exception BaseActivity", "registerActivityFinishReceiver() "
					+ e);
		}
	}

	/**
	 * 
	 * <p>
	 * This is the method for unRegisterActivityFinishReceiver.
	 * </p>
	 */
	private void unRegisterActivityFinishReceiver() {
		try {
			unregisterReceiver(activityFinishReceiver);
		} catch (Exception e) {
			Log.d("Exception BaseActivity",
					"unRegisterActivityFinishReceiver() " + e);
		}
	}

	/**
	 * 
	 * @author vipin.cb , vipin.cb@experionglobal.com <br>
	 *         Apr 2, 2013, 11:02:54 AM <br>
	 *         Package:- <b>com.topgolf.mobile.views</b> <br>
	 *         Project:- <b>TopGolfMobile</b>
	 *         <p>
	 */
	private final class ActivityFinishReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			try {
				finish();
			} catch (Exception e) {
				Log.d("Exception BaseActivity",
						"ActivityFinishReceiver onReceive" + e);
			}
		}
	}
}
