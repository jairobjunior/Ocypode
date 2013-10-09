package com.sook.android.component.delegate.adaptor;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public interface IStartActivityAdaptor {

	Context getContext();

	void startActivity(Intent intent);

	void overridePendingTransition(int enterAnim, int exitAnim);

	void startActivityForResult(Intent intent, int requestCode);

	void startService(Intent service);

	void stopService(Intent service);

	void bindService(Intent service, ServiceConnection conn,
			int flags);

}
