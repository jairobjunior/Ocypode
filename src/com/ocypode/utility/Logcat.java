package com.ocypode.utility;

/**
 * @author Jairo Barros Junior (jairobjunior@gmail.com)
 * @since May 9, 2013
 */
public class Logcat {
	
	public static boolean LOG_ENABLED = true;
	private static String TAG = "Logcat";

	public static void d(String msg) {
		if (LOG_ENABLED)
			android.util.Log.d(TAG, msg);
	}

	public static void d(String tag, String msg) {
		if (LOG_ENABLED)
			android.util.Log.d(tag, msg);
	}

	public static void e(String msg) {
		if (LOG_ENABLED)
			android.util.Log.e(TAG, msg);
	}

	public static void e(String tag, String msg) {
		if (LOG_ENABLED)
			android.util.Log.e(tag, msg);
	}

	public static void e(String msg, Throwable tr) {
		if (LOG_ENABLED)
			android.util.Log.e(TAG, msg, tr);
	}

	public static void e(String tag, String msg, Throwable tr) {
		if (LOG_ENABLED)
			android.util.Log.e(tag, msg, tr);
	}

	public static void i(String msg) {
		if (LOG_ENABLED)
			android.util.Log.i(TAG, msg);
	}

	public static void i(String tag, String msg) {
		if (LOG_ENABLED)
			android.util.Log.i(tag, msg);
	}

	public static void v(String msg) {
		if (LOG_ENABLED)
			android.util.Log.v(TAG, msg);
	}

	public static void v(String tag, String msg) {
		if (LOG_ENABLED)
			android.util.Log.v(tag, msg);
	}

	public static void w(String msg) {
		if (LOG_ENABLED)
			android.util.Log.w(TAG, msg);
	}

	public static void w(String tag, String msg) {
		if (LOG_ENABLED)
			android.util.Log.w(tag, msg);
	}
	
	public static void setTag(String tag) {
		TAG = tag;
	}
}
