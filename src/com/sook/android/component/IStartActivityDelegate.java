package com.sook.android.component;

import android.os.Bundle;

/**
 * @author Jairo Barros Junior (jairobjunior@gmail.com)
 * @since May 9, 2013
 */
public interface IStartActivityDelegate {

	void goToActivity(Class<?> screen);

	void goToActivityWithNoAnimation(Class<?> screen);
	
	void goToActivityWithAnimation(Class<?> screen, int enterAnim, int exitAnim);
	
	void goToActivityWithAnimation(Class<?> screen, Bundle extras, int enterAnim, int exitAnim);

	void goToActivity(String action);
	
	void reorderActivityToFront(Class<?> screen, Bundle extras);

	void goToActivityWithNoAnimation(Class<?> screen, Bundle extras);

}
