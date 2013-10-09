package com.sook.android.component.delegate.adaptor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public class StartActivityAdaptor implements IStartActivityAdaptor {

	private Activity mActivity;

	public StartActivityAdaptor(Activity activity) {
		this.mActivity = activity;
	}
	
	@Override
	public Context getContext() {
		return mActivity;
	}

	@Override
	public void startActivity(Intent intent) {
		mActivity.startActivity(intent);
	}

	@Override
	public void overridePendingTransition(int enterAnim, int exitAnim) {
		mActivity.overridePendingTransition(enterAnim, exitAnim);
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		mActivity.startActivityForResult(intent, requestCode);
	}

	@Override
	public void startService(Intent service) {
		mActivity.startService(service);
	}

	@Override
	public void stopService(Intent service) {
		mActivity.stopService(service);
	}

	@Override
	public void bindService(Intent service, ServiceConnection conn,
			int flags) {
		mActivity.bindService(service, conn, flags);
	}

}
