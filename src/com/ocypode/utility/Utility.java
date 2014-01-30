package com.ocypode.utility;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Utility {
	
	public static final String TAG = "Ocypode.Utility";
	
	public static void hideKeyboard(Activity mActivity, View view) {
		if(mActivity != null){
			InputMethodManager inputManager = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
			if(inputManager != null && view != null)
				inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
		}
	}

}
