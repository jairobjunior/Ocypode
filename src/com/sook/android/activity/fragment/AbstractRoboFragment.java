package com.sook.android.activity.fragment;

import roboguice.fragment.RoboFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

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
		transaction.add(fragmentId, fragment).commit();
	}

}
