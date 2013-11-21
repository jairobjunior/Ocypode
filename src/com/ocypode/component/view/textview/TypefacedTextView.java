package com.ocypode.component.view.textview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ocypode.component.Typefaced;

public class TypefacedTextView extends TextView {

	public TypefacedTextView(Context context, AttributeSet attrs) {
		super(context, attrs);

		if (isInEditMode()) {
			return;
		}

		Typeface typeface = Typefaced.createTypeface(context, attrs);
		if (typeface != null) {			
			setTypeface(typeface);
		}
	}

}
