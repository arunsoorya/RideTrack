package com.myandroidkid.ridetrack.views;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.myandroidkid.ridetrack.R;

public class ContactActivity extends RoboActivity {

	static final int PICK_CONTACT_REQUEST = 1;

	@InjectView(R.id.button_getcontacts)
	private Button getContacts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts);

		getContacts.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				pickContact();

			}
		});
	}

	/**
	 * 
	 * <p>
	 * This is the method for .
	 * </p>
	 */
	private void pickContact() {
		Intent pickContactIntent = new Intent(Intent.ACTION_PICK,
				ContactsContract.Contacts.CONTENT_URI);
		pickContactIntent.setType(ContactsContract.Contacts.CONTENT_TYPE); // Show user only
														// contacts w/ phone
														// numbers
		startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// Check which request we're responding to
		if (requestCode == PICK_CONTACT_REQUEST) {
			// Make sure the request was successful
			if (resultCode == RESULT_OK) {
				Uri contactUri = data.getData();
				// We only need the NUMBER column, because there will be only
				// one row in the result
				String[] projection = {Phone.TYPE};

				Cursor cursor = getContentResolver().query(contactUri, null, null, null, null);
				
				cursor.moveToFirst();
				Log.d("contacts c", ""+cursor.getCount());
				Log.d("contacts col", ""+cursor.getColumnCount());
				while (cursor.moveToNext()) {
					Log.d("contacts", ""+cursor.getColumnName(0));
				}
				
				DatabaseUtils.dumpCursor(cursor);
				
				// Retrieve the phone number from the NUMBER column
//				int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
//				String number = cursor.getString(column);
//Toast.makeText(this, "number " +number, Toast.LENGTH_SHORT).show();
				// Do something with the phone number...
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contacts, menu);
		return true;
	}

}
