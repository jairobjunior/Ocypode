package com.sook.android.component.delegate.adaptor;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.support.v4.app.Fragment;

public class StartFragmentAdaptor implements IStartActivityAdaptor {

	private Fragment mFragment;

	public StartFragmentAdaptor(Fragment fragment) {
		this.mFragment = fragment;
	}

	@Override
	public Context getContext() {
		return mFragment.getActivity();
	}

	@Override
	public void startActivity(Intent intent) {
		mFragment.startActivity(intent);
	}

	@Override
	public void overridePendingTransition(int enterAnim, int exitAnim) {
		mFragment.getActivity().overridePendingTransition(enterAnim, exitAnim);
	}

	@Override
	public void startActivityForResult(Intent i, int correlationId) {
		mFragment.startActivityForResult(i, correlationId);
	}

	@Override
	public void startService(Intent i) {
		mFragment.getActivity().startService(i);
	}

	@Override
	public void stopService(Intent i) {
		mFragment.getActivity().stopService(i);
	}

	@Override
	public void bindService(Intent intent, ServiceConnection conn,
			int flags) {
		mFragment.getActivity().bindService(intent, conn, flags);
	}

}
