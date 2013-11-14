package com.sook.android.component.delegate;

import java.util.Random;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;

import com.sook.android.activity.IResultCallbackActivity;
import com.sook.android.component.delegate.adaptor.IStartActivityAdaptor;
import com.sook.android.utility.Logcat;

/**
 * @author Jairo Barros Junior (jairobjunior@gmail.com)
 * @since May 9, 2013
 */
public class StartActivityDelegate implements IStartActivityDelegate {
		
	private IStartActivityAdaptor mStartActivityAdaptor;
	
	protected SparseArray<IResultCallbackActivity> mCallbackMap;
	
	public StartActivityDelegate(IStartActivityAdaptor startActivityAdaptor) {
		mStartActivityAdaptor = startActivityAdaptor;
		mCallbackMap = new SparseArray<IResultCallbackActivity>();
	}

	@Override
	public void goToActivity(Class<?> screen) {
		Intent intent = new Intent(mStartActivityAdaptor.getContext(), screen);
		mStartActivityAdaptor.startActivity(intent);
	}
	
	@Override
	public void reorderActivityToFront(Class<?> screen, Bundle extras) {
		Intent intent = new Intent(mStartActivityAdaptor.getContext(), screen);
		intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		intent.putExtras(extras);
		mStartActivityAdaptor.startActivity(intent);
	}
	
	@Override
	public void goToActivityWithNoAnimation(Class<?> screen) {		
		goToActivityWithAnimation(screen, 0, 0);
	}	

	@Override
	public void goToActivityWithNoAnimation(Class<?> screen, Bundle extras) {
		goToActivityWithAnimation(screen, extras, 0, 0);	
	}
	
	@Override
	public void goToActivityWithAnimation(Class<?> screen, int enterAnim,
			int exitAnim) {
		goToActivity(screen);
		mStartActivityAdaptor.overridePendingTransition(enterAnim, exitAnim);
	}
	
	@Override
	public void goToActivityWithAnimation(Class<?> screen, Bundle extras,
			int enterAnim, int exitAnim) {
		Intent intent = new Intent(mStartActivityAdaptor.getContext(), screen);
		intent.putExtras(extras);
		mStartActivityAdaptor.startActivity(intent);
		mStartActivityAdaptor.overridePendingTransition(enterAnim, exitAnim);
	}
	

	@Override
	public void goToActivityWithAnimationSettingFlagClearTop(Class<?> screen,
			int enterAnim, int exitAnim) {
		Intent intent = new Intent(mStartActivityAdaptor.getContext(), screen);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		mStartActivityAdaptor.startActivity(intent);
		mStartActivityAdaptor.overridePendingTransition(enterAnim, exitAnim);
	}
	
	@Override
	public void goToActivity(String action) {
		Intent intent = new Intent(action);
		mStartActivityAdaptor.startActivity(intent);
	}

	@Override
	public void openBrowser(String url) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW,
				Uri.parse(url));
		mStartActivityAdaptor.startActivity(browserIntent);		
	}
	
	@Override
	public void launchSubActivity(Class<?> subActivityClass, IResultCallbackActivity callback) {
		Intent i = new Intent(mStartActivityAdaptor.getContext(), subActivityClass);
		
		launchSubActivity(i, callback);
	}
	
	@Override
	public void launchSubActivity(Intent i, IResultCallbackActivity callback) {
		int correlationId = new Random().nextInt(9999);

		mCallbackMap.put(correlationId, callback);
		mStartActivityAdaptor.startActivityForResult(i, correlationId);
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		try {
			IResultCallbackActivity callback = mCallbackMap.get(requestCode);

			switch (resultCode) {
				case Activity.RESULT_CANCELED:
					callback.onResultCancel(data);
					mCallbackMap.remove(requestCode);
					break;
				case Activity.RESULT_OK:
					callback.onResultOk(data);
					mCallbackMap.remove(requestCode);
					break;
				default:
					Logcat.e("Couldn't find callback handler for correlationId");
			}
		} catch (Exception e) {
			Logcat.e("Problem processing result from sub-activity", e);
		}
	}

	@Override
	public void startService(Class<?> cl) {
		Intent i = new Intent(mStartActivityAdaptor.getContext(), cl);
		mStartActivityAdaptor.startService(i);
	}

	@Override
	public void stopService(Class<?> cl) {
		Intent i = new Intent(mStartActivityAdaptor.getContext(), cl);
		mStartActivityAdaptor.stopService(i);
	}

	@Override
	public void bindService(Service service, Class<?> serviceClass,
			ServiceConnection serviceConnection) {
		if (service == null) {
			Logcat.d("Binding Service: " + serviceClass.getName());
			mStartActivityAdaptor.bindService(new Intent(mStartActivityAdaptor.getContext(), serviceClass), serviceConnection,
					Context.BIND_AUTO_CREATE);
		}
	}

}