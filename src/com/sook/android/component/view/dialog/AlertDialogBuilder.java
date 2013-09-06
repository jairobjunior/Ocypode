package com.sook.android.component.view.dialog;

import android.app.Activity;
import android.app.AlertDialog;

import com.sook.R;

public class AlertDialogBuilder {

	private final Activity mActivity;

	public AlertDialogBuilder(Activity activity) {
		mActivity = activity;		
	}
	
	public void showAlertDialog(String title, String message) {
		createAlertDialog(title, message).show();
	}
	
	public void showAlertDialog(int title, int message) {
		createAlertDialog(title, message).show();
	}

	public void showSuccessMessage(String message) {
		createAlertDialog(mActivity.getString(R.string.success), message).show();
	}
	
	public void showErrorMessage(String message) {
		createAlertDialog(mActivity.getString(R.string.error), message).show();
	}
	
	public void showErrorMessage(int messageId) {
		showErrorMessage(mActivity.getString(messageId));
	}
	
	private AlertDialog createAlertDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setMessage(message)
        		.setTitle(title)
        		.setPositiveButton(R.string.ok, null);

        return builder.create();
	}
	
	private AlertDialog createAlertDialog(int title, int message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setMessage(message)
        		.setTitle(title)
        		.setPositiveButton(R.string.ok, null);

        return builder.create();
	}
	
}