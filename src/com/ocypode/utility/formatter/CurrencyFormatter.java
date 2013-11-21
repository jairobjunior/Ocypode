package com.ocypode.utility.formatter;

import java.util.Formatter;
import java.util.Locale;

public class CurrencyFormatter {

	private static Formatter formatter;

	/**
	 * 
	 * @param value = 1000
	 * @return = 1,000.00
	 */
	public static String formatIncludingDecimal(double value){
		StringBuilder sb = new StringBuilder();
		formatter = new Formatter(sb, Locale.US);
		formatter.format("%,.2f", value);
		return sb.toString();
	}
}
