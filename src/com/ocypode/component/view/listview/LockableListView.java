package com.ocypode.component.view.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class LockableListView extends ListView{
	private boolean isLocked = false;
	
	public LockableListView(Context context, AttributeSet attrs) {
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
