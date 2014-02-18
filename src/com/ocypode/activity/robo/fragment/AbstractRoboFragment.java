package com.ocypode.activity.robo.fragment;

import roboguice.fragment.RoboFragment;
import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.ocypode.R;
import com.ocypode.activity.IResultCallbackActivity;
import com.ocypode.component.delegate.IStartActivityDelegate;
import com.ocypode.component.delegate.StartActivityDelegate;
import com.ocypode.component.delegate.adaptor.StartFragmentAdaptor;

abstract public class AbstractRoboFragment extends RoboFragment implements IStartActivityDelegate {
	
	private IStartActivityDelegate mStartActivityDelegate;

	@Override
	public void onCreate(Bundle arg0) {
		super.onCreate(arg0);		

		mStartActivityDelegate = new StartActivityDelegate(new StartFragmentAdaptor(this));
	}	
	
	public void pushActivity(Class<?> screen) {
		goToActivityWithAnimation(screen, R.anim.slide_left_enter, R.anim.slide_left_exit);
	}
	
	public void pushActivity(Class<?> screen, Bundle extras) {
		goToActivityWithAnimation(screen, extras, R.anim.slide_left_enter, R.anim.slide_left_exit);
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
	public void goToActivityWithAnimationSettingFlagClearTop(Class<?> screen,
			int enterAnim, int exitAnim) {
		mStartActivityDelegate.goToActivityWithAnimationSettingFlagClearTop(screen, enterAnim, exitAnim);
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
	public void launchSubActivity(Intent i, IResultCallbackActivity callback) {
		mStartActivityDelegate.launchSubActivity(i, callback);
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
