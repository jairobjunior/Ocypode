package com.ocypode.utility;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Utility {
	
	public static final String TAG = "Ocypode.Utility";
	
	public static void alertDialog(final Context context, final String title, final int mensagem) {
		try {
			AlertDialog.Builder builder = new AlertDialog.Builder(context);
			builder.setTitle(title);
			builder.setMessage(context.getString(mensagem));
			builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface arg0, int arg1) {
							return;
						}
					});
			
			builder.create();
			builder.show();
		} catch (Exception e) {
			Logcat.e(TAG, e.getMessage(), e);
		}
	}

	public static void alertDialog(final Context context, final String title, final String mensagem) {
		try {
			AlertDialog.Builder builder = new AlertDialog.Builder(context);
			builder.setTitle(title);
			builder.setMessage(mensagem);
			builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface arg0, int arg1) {
							return;
						}
					});
			
			builder.create();
			builder.show();
		} catch (Exception e) {
			Logcat.e(TAG, e.getMessage(), e);
		}
	}
	
	public static boolean closeVirtualKeyboard(Context context, View view) {
		InputMethodManager imm = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm != null) {
			boolean b = imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
			return b;
		}
		return false;
	}

}
