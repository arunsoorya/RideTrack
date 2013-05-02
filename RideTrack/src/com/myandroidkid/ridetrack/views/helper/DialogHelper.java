/*@(#)DialogHelper.java
 */
package com.myandroidkid.ridetrack.views.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.google.inject.Inject;

/**
 * @author arunkumar.s,arunkumar.s@experionglobal.com
 * <br>Apr 19, 2013
 * <br>Package:- <b>{com.amisafe.app.views.helper</b>
 * <br>Project:- <b>{AmISafe</b>
 * <p>
 */
public class DialogHelper  {
	/** The context. */
	private Context context;

	/**
	 * Constructor for DialogHelper.
	 */
	@Inject
	public DialogHelper(Context context) {
		this.context = context;
	}

	/**
	 * <p>
	 * This is the method for showing alert.
	 * </p>
	 * @param title title
	 * @param message message
	 * @param buttonText buttonText
	 */
	public AlertDialog getAlertDialog(String title, String message,
			String buttonText) {
		AlertDialog.Builder builer = new AlertDialog.Builder(context);
		builer.setTitle(title);
		builer.setMessage(message);
		builer.setNegativeButton(buttonText,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
		return builer.create();
	}

	/**
	 * 
	 * <p>
	 * This is the method for .
	 * </p>
	 * @param tittle
	 * @param message
	 */
	public void showPositiveDialog(String tittle, String message) {
		AlertDialog.Builder builer = new AlertDialog.Builder(context);
		if (tittle != null) {
			builer.setTitle(tittle);
		}
		builer.setMessage(message);
		builer.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		builer.create().show();
	}

	/**
	 * 
	 * <p>
	 * This is the method for .
	 * </p>
	 * @param tittle
	 * @param message
	 */
	public void showDialog(String tittle, String message) {
		AlertDialog.Builder builer = new AlertDialog.Builder(context);
		if (tittle != null) {
			builer.setTitle(tittle);
		}
		builer.setMessage(message);
		builer.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		builer.setNegativeButton("Canel",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
		builer.create().show();
	}
	
	
	/**
	 * 
	 * <p>
	 * This is the method for .
	 * </p>
	 */
	public AlertDialog.Builder applicationExitPrompt() {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
		alertDialog.setTitle("Alert");
		alertDialog.setMessage("Do you want to exit the application?");
		// Setting Negative "NO" Button
		alertDialog.setNegativeButton("No",
				new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// Write your code here to invoke NO event
				dialog.cancel();
			}
		});
		
		// Showing Alert Message
		return alertDialog;
	}

	/**
	 * <p>
	 * This is the method for showing alert with multiple options.
	 * </p>
	 * @param title title
	 * @param message message
	 * @param positiveText positive button text
	 * @param negativeText negative button text
	 */
	public AlertDialog.Builder getMultipleOptionAlertDialog(String title,
			String message, String positiveText, String negativeText) {
		AlertDialog.Builder builer = new AlertDialog.Builder(context);
		builer.setTitle(title);
		builer.setMessage(message);
		builer.setNegativeButton(negativeText,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});

		builer.setPositiveButton(positiveText,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
		return builer;
	}
}
