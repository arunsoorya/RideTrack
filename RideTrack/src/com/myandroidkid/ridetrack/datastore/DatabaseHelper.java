/*@(#)DatabaseHelper.java
 */
package com.myandroidkid.ridetrack.datastore;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.inject.Inject;
import com.myandroidkid.ridetrack.appconstants.Appconstants;

/**
 * @author arunkumar.s,arunkumar.s@experionglobal.com <br>
 *         Apr 19, 2013 <br>
 *         Package:- <b>{com.amisafe.app.datastore</b> <br>
 *         Project:- <b>{AmISafe</b>
 *         <p>
 */
public class DatabaseHelper extends SQLiteOpenHelper {

	private Context context;
	/** The Constant DATABASE_NAME. */
	private static final String DATABASE_NAME = Appconstants.DATABASE_NAME;

	/** The Constant DATABASE_VERSION. */
	private static final int DATABASE_VERSION = Appconstants.DATABASE_VERSION;

	/**
	 * 
	 * Constructor for DatabaseHelper.
	 * @param context the context
	 * @param userTable the userTable
	 */
	@Inject
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}

	/**
	 * On create.
	 * @param database the database
	 */
	@Override
	public void onCreate(SQLiteDatabase database) {
	}

	/**
	 * On upgrade.
	 * @param database the database
	 * @param oldVersion the old version
	 * @param newVersion the new version
	 */
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
	}

}
