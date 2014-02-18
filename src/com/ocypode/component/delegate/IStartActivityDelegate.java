package com.ocypode.component.delegate;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;

import com.ocypode.activity.IResultCallbackActivity;

/**
 * @author Jairo Barros Junior (jairobjunior@gmail.com)
 * @since May 9, 2013
 */
public interface IStartActivityDelegate {

	void goToActivity(Class<?> screen);
	
	void pushActivity(Class<?> screen);
	
	void pushActivity(Class<?> screen, Bundle extras);
	
	void popActivity(Class<?> screen);
	
	void popActivity(Class<?> screen, Bundle extras);
	
	void goToActivityWithNoAnimation(Class<?> screen);
	
	void goToActivityWithAnimation(Class<?> screen, int enterAnim, int exitAnim);
	
	void goToActivityWithAnimation(Class<?> screen, Bundle extras, int enterAnim, int exitAnim);
	
	void goToActivityWithAnimationSettingFlagClearTop(Class<?> screen, int enterAnim, int exitAnim);

	void goToActivity(String action);
	
	void reorderActivityToFront(Class<?> screen, Bundle extras);

	void goToActivityWithNoAnimation(Class<?> screen, Bundle extras);

	void openBrowser(String url);

	void launchSubActivity(Class<?> subActivityClass,
			IResultCallbackActivity callback);
	
	public void launchSubActivity(Intent i, 
			IResultCallbackActivity callback);

	void onActivityResult(int requestCode, int resultCode, Intent data);
	
	void startService(Class<?> cl);

	void stopService(Class<?> cl);
	
	void bindService(Service service, Class<?> serviceClass,
			ServiceConnection serviceConnection);
}
