package com.myandroidkid.ridetrack.views;

import java.util.HashMap;
import java.util.Map;

import roboguice.RoboGuice;
import roboguice.util.RoboContext;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.google.inject.Inject;
import com.google.inject.Key;
import com.myandroidkid.ridetrack.R;
import com.myandroidkid.ridetrack.navigationController.NavigationConstants;
import com.myandroidkid.ridetrack.navigationController.NavigationController;

public class HomeScreen extends BaseActivity implements RoboContext {

	@Inject
	private NavigationController  navigationController;
	/** The scopedObjects. */
	protected HashMap<Key<?>, Object> scopedObjects = new HashMap<Key<?>, Object>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_screen);
		RoboGuice.getInjector(this).injectMembersWithoutViews(this);
		RoboGuice.getInjector(this).injectViewMembers(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_screen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == R.id.action_settings) {
			navigationController.navigate(this, NavigationConstants.SETTINGS_SCREEN, null);
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void appGoingToBackground() {
		// TODO Auto-generated method stub

	}

	@Override
	public void appComingFromBackground() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<Key<?>, Object> getScopedObjectMap() {
		// TODO Auto-generated method stub
		return scopedObjects;
	}

}
