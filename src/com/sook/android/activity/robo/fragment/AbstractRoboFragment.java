package com.sook.android.activity.robo.fragment;

import roboguice.fragment.RoboFragment;
import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.sook.android.activity.IResultCallbackActivity;
import com.sook.android.component.IStartActivityDelegate;
import com.sook.android.component.StartActivityDelegate;

abstract public class AbstractRoboFragment extends RoboFragment implements IStartActivityDelegate {
	
	private IStartActivityDelegate mStartActivityDelegate;

	@Override
	public void onCreate(Bundle arg0) {
		super.onCreate(arg0);		
		
		mStartActivityDelegate = new StartActivityDelegate(getActivity());
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
	
	protected void addFragment(int fragmentId, Fragment fragment) {
		FragmentTransaction transaction = getChildFragmentManager().beginTransaction();		
		transaction.replace(fragmentId, fragment).commit();
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
	
	@Override
	public void startService(Class<?> cl) {
		mStartActivityDelegate.startService(cl);
	}
	
	@Override
	public void stopService(Class<?> cl) {
		mStartActivityDelegate.stopService(cl);
	}
	
	@Override
	public void bindService(Service service, Class<?> serviceClass,
			ServiceConnection serviceConnection) {
		mStartActivityDelegate.bindService(service, serviceClass, serviceConnection);
	}

}
