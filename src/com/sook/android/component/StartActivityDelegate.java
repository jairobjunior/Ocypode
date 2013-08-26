package com.sook.android.component;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author Jairo Barros Junior (jairobjunior@gmail.com)
 * @since May 9, 2013
 */
public class StartActivityDelegate implements IStartActivityDelegate {
	
	private Activity mActivity;
	
	public StartActivityDelegate(Activity activity) {
		mActivity = activity;
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
}
