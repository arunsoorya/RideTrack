/*@(#)NavigationControllerImpl.java
 */
package com.myandroidkid.ridetrack.navigationController;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.inject.Inject;

/**
 * @author arunkumar.s,arunkumar.s@experionglobal.com
 * <br>Apr 26, 2013
 * <br>Package:- <b>{com.amisafe.app.navigationController</b>
 * <br>Project:- <b>{AmISafe</b>
 * <p>
 */
public class NavigationControllerImpl implements NavigationController {
	/** The navigation configuration. */
	private NavigationConfigBase config;

	/**
	 * Instantiates a new navigation controller implementation.
	 * @param config
	 *        the configuration
	 */
	@Inject
	public NavigationControllerImpl(final NavigationConfigBase config) {
		this.config = config;
		init();
	}

	/**
	 * Initiates the controller. It reads the xml and configures it.
	 */
	private void init() {
		config.configure();
	}

	@Override
	public boolean navigate(Context context, String id,
			Map<String, Serializable> values) {
		Class<?> classObj = config.getClassObject(id);

		Intent intent = new Intent(context, classObj);
		putExtras(values, intent);
		context.startActivity(intent);
		return false;
	}

	@Override
	public boolean navigateFragment(Activity context, String id, Bundle bundle) {
		return false;
	}

	@Override
	public boolean navigateForResult(Activity activity, String id,
			int requestCode, Map<String, Serializable> values) {
		return false;
	}

	/**
	 * Put extras.
	 * @param values
	 *        the values to hand over to the next activity
	 * @param intent
	 *        the intent
	 */
	private void putExtras(final Map<String, Serializable> values, final Intent intent) {
		if (values != null) {
			Set<String> keys = values.keySet();
			for (String key : keys) {
				Serializable value = values.get(key);
				intent.putExtra(key, value);
			}
		}
	}
}

