package com.ocypode.component.view.dialog;

import roboguice.inject.ContextSingleton;
import android.app.ProgressDialog;
import android.content.Context;

import com.google.inject.Inject;

@ContextSingleton
public class ProgressDialogBuilder extends ProgressDialog {
	
	@Inject
	public ProgressDialogBuilder(Context context) {
		super(context);
		
		setDefaultValues();
	}
	
	public ProgressDialogBuilder setMessage(String message) {
		super.setMessage(message);
		return this;
	}
	
	public ProgressDialogBuilder setMessage(int messageId) {
		super.setMessage(getContext().getString(messageId));		
		return this;
	}
	
	private void setDefaultValues() {		
		setTitle(null);
		setIndeterminate(true);
		setCancelable(true);
	}
}
