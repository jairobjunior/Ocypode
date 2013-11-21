package com.ocypode.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.ocypode.R;

public class Typefaced {

	public static Typeface createTypeface(Context context, AttributeSet attrs) {
		TypedArray styledAttrs = context.obtainStyledAttributes(attrs,R.styleable.TypefacedTextView);
		String fontName = styledAttrs.getString(R.styleable.TypefacedTextView_typefaceTextView);
		styledAttrs.recycle();
	
		if (fontName != null) {
			return Typeface.createFromAsset(context.getAssets(),
					"fonts/" + fontName);		
		}
	
		return null;
	}
}
