package com.ocypode.component.view.button;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import com.ocypode.component.Typefaced;

public class TypefacedButton extends Button {

	public TypefacedButton(Context context, AttributeSet attrs) {
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
