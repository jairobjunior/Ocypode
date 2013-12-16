package com.ocypode.component.view.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class LockableScrollView extends ScrollView {

	private boolean isLocked = false;
	
	public LockableScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	public void setLock(boolean lock){
		isLocked = lock;
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if(isLocked){
			return false;
		}else{
			return super.onInterceptTouchEvent(ev);			
		}
	}
}
