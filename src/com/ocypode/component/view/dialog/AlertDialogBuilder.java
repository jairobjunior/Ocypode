package com.ocypode.component.view.dialog;

import android.app.AlertDialog;
import android.content.Context;

import com.ocypode.R;

public class AlertDialogBuilder {

	private final Context mContext;

	public AlertDialogBuilder(Context context) {
		mContext = context;		
	}
	
	public void showAlertDialog(String title, String message) {
		createAlertDialog(title, message).show();
	}
	
	public void showAlertDialog(int title, int message) {
		createAlertDialog(title, message).show();
	}

	public void showSuccessMessage(String message) {
		createAlertDialog(mContext.getString(R.string.success), message).show();
	}
	
	public void showErrorMessage(String message) {
		createAlertDialog(mContext.getString(R.string.error), message).show();
	}
	
	public void showErrorMessage(int messageId) {
		showErrorMessage(mContext.getString(messageId));
	}
	
	private AlertDialog createAlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage(message)
        		.setTitle(title)
        		.setPositiveButton(R.string.ok, null);

        return builder.create();
	}
	
	private AlertDialog createAlertDialog(int title, int message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage(message)
        		.setTitle(title)
        		.setPositiveButton(R.string.ok, null);

        return builder.create();
	}
	
}