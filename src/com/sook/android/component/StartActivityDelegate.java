package com.sook.android.component;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;

import com.sook.android.activity.IResultCallbackActivity;
import com.sook.android.utility.Logcat;

/**
 * @author Jairo Barros Junior (jairobjunior@gmail.com)
 * @since May 9, 2013
 */
public class StartActivityDelegate implements IStartActivityDelegate {
		
	private Activity mActivity;
	
	protected SparseArray<IResultCallbackActivity> mCallbackMap;
	
	public StartActivityDelegate(Activity activity) {
		mActivity = activity;
		mCallbackMap = new SparseArray<IResultCallbackActivity>();
	}		

	@Override
	public void goToActivity(Class<?> screen) {
		Intent intent = new Intent(mActivity, screen);
		mActivity.startActivity(intent);
	}
	
	@Override
	public void reorderActivityToFront(Class<?> screen, Bundle extras) {
		Intent intent = new Intent(mActivity, screen);
		intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		intent.putExtras(extras);
		mActivity.startActivity(intent);
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
		mActivity.overridePendingTransition(enterAnim, exitAnim);
	}
	
	@Override
	public void goToActivityWithAnimation(Class<?> screen, Bundle extras,
			int enterAnim, int exitAnim) {
		Intent intent = new Intent(mActivity, screen);
		intent.putExtras(extras);
		mActivity.startActivity(intent);
		mActivity.overridePendingTransition(enterAnim, exitAnim);
	}
	
	@Override
	public void goToActivity(String action) {
		Intent intent = new Intent(action);
		mActivity.startActivity(intent);
	}

	@Override
	public void openBrowser(String url) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW,
				Uri.parse(url));
		mActivity.startActivity(browserIntent);		
	}
	
	@Override
	public void launchSubActivity(Class<?> subActivityClass, IResultCallbackActivity callback) {
		Intent i = new Intent(mActivity, subActivityClass);

		int correlationId = new Random().nextInt(9999);

		mCallbackMap.put(correlationId, callback);
		mActivity.startActivityForResult(i, correlationId);
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
}