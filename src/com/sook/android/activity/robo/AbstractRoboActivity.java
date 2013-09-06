package com.sook.android.activity.robo;

import roboguice.activity.RoboActivity;
import android.content.Intent;
import android.os.Bundle;

import com.sook.android.activity.IResultCallbackActivity;
import com.sook.android.component.IStartActivityDelegate;
import com.sook.android.component.StartActivityDelegate;

abstract public class AbstractRoboActivity extends RoboActivity implements IStartActivityDelegate {
		
	private IStartActivityDelegate mStartActivityDelegate;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);		
		
		mStartActivityDelegate = new StartActivityDelegate(this);
	}	
	
	@Override
	public void goToActivity(Class<?> screen) {
		mStartActivityDelegate.goToActivity(screen);
	}	
	
	@Override
	public void reorderActivityToFront(Class<?> screen, Bundle extras) {
		mStartActivityDelegate.reorderActivityToFront(screen, extras);
	}
	
	@Override
	public void goToActivityWithAnimation(Class<?> screen, int enterAnim,
			int exitAnim) {
		mStartActivityDelegate.goToActivityWithAnimation(screen, enterAnim, exitAnim);
	}
	
	@Override
	public void goToActivityWithAnimation(Class<?> screen, Bundle extras,
			int enterAnim, int exitAnim) {
		mStartActivityDelegate.goToActivityWithAnimation(screen, extras, enterAnim, exitAnim);		
	}
	
	@Override
	public void goToActivityWithNoAnimation(Class<?> screen) {
		mStartActivityDelegate.goToActivityWithNoAnimation(screen);
	}
	
	@Override
	public void goToActivityWithNoAnimation(Class<?> screen, Bundle extras) {
		mStartActivityDelegate.goToActivityWithNoAnimation(screen, extras);
	}
	
	@Override
	public void goToActivity(String action) {
		mStartActivityDelegate.goToActivity(action);
	}
	
	@Override
	public void openBrowser(String url) {
		mStartActivityDelegate.openBrowser(url);
	}
	
	@Override
	public void launchSubActivity(Class<?> subActivityClass,
			IResultCallbackActivity callback) {
		mStartActivityDelegate.launchSubActivity(subActivityClass, callback);
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		mStartActivityDelegate.onActivityResult(requestCode, resultCode, data);
	}

}
