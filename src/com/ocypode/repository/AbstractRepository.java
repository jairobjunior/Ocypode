package com.ocypode.repository;

import android.content.Context;
import android.content.SharedPreferences;

abstract public class AbstractRepository {
	
	private SharedPreferences mSharedPreferences;

	public AbstractRepository(Context context) {
		mSharedPreferences = context.getSharedPreferences(
				getSharedPreferencesName(), Context.MODE_PRIVATE);
	}
	
	protected SharedPreferences getSharedPreferences() {
		return mSharedPreferences;
	}
	
	protected SharedPreferences.Editor getEditor() {
		return mSharedPreferences.edit();
	}
	
	public void delete() {
		SharedPreferences.Editor editor = getEditor();
		editor.clear();
		editor.commit();
	}

	public void saveBoolean(String key, Boolean value) {
		SharedPreferences.Editor editor = getEditor();
		editor.putBoolean(key, value);
		editor.commit();
	}

	abstract protected String getSharedPreferencesName();
}
