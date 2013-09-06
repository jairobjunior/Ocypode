package com.sook.android.utility.validation;

public class StringValidation {

	public final static boolean isEmpty(String value) {
		return isNull(value) || "".equals(value.trim());
	}
	
	public final static boolean isNotEmpty(String value) {
		return !isEmpty(value);
	}
	
	public final static boolean isNull(String value) {
		return value == null;
	}
	
	public final static boolean isNotNull(String value) {
		return value != null;
	}
	
	public final static boolean isValidEmail(CharSequence target) {
	    if (target == null || isEmpty(target.toString())) {
	        return false;
	    } else {
	        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
	    }
	}
}
