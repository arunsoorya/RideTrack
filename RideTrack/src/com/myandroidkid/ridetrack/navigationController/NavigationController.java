/*@(#)NavigationController.java
 */
package com.myandroidkid.ridetrack.navigationController;

import java.io.Serializable;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/**
 * @author arunkumar.s,arunkumar.s@experionglobal.com
 * <br>Apr 26, 2013
 * <br>Package:- <b>{com.amisafe.app.navigationController</b>
 * <br>Project:- <b>{AmISafe</b>
 * <p>
 */
public interface NavigationController {
	/**
	 * Navigate to the screen,which is specified with the id. The implementation
	 * should check the id and navigate to appropriate screen.
	 * @param context
	 *            the context object - the calling activity
	 * @param id
	 *            the id - maps to the to load screen.
	 * @param values
	 *            the values that to be passed to the new screen
	 * @return true for success
	 */

	boolean navigate(Context context, String id, Map<String, Serializable> values);

	/**
	 * Navigate to the screen,which is specified with the id. The implementation
	 * should check the id and navigate to appropriate screen.
	 * @param context
	 *            the context object - the calling activity
	 * @param id
	 *            the id - maps to the to load screen.
	 * @param bundle
	 *            tab information bundle
	 * @return true for success
	 */

	boolean navigateFragment(Activity context, String id, final Bundle bundle);

	/**
	 * Navigate to the screen,which is specified with the id. The implementation
	 * should check the id and navigate to appropriate screen.
	 * @param context
	 *        the activity object - the calling activity
	 * @param id
	 *        the id - maps to the to load screen.
	 * @param requestCode
	 *        the requestCode
	 * @param values
	 *        the values that to be passed to the new screen
	 * @return true for success
	 */
	boolean navigateForResult(Activity activity, String id, int requestCode, Map<String, Serializable> values);

}
