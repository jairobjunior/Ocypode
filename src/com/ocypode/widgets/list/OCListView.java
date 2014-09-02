package com.ocypode.widgets.list;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.ocypode.R;

public class OCListView extends ListView {

	public OCListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		if (isInEditMode()) {
			return;
		}

		TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.OCLisView);
		int layoutHeaderResource = styledAttrs.getResourceId(R.styleable.OCLisView_layout_header_embedded, 0);
		int layoutFooterResource = styledAttrs.getResourceId(R.styleable.OCLisView_layout_footer_embedded, 0);
		styledAttrs.recycle();
		
		embedHeader(layoutHeaderResource);
		embedFooter(layoutFooterResource);
	}

	private void embedHeader(int layoutHeaderResource) {
		if (layoutHeaderResource != 0) {
			LayoutInflater inflater = LayoutInflater.from(getContext());
	    	View header = inflater.inflate(layoutHeaderResource, this, false);
	    	if (header != null) {
	    		addHeaderView(header, null, false);
	    	}
		}
	}
	
	private void embedFooter(int layoutFooterResource) {
		if (layoutFooterResource != 0) {
			LayoutInflater inflater = LayoutInflater.from(getContext());
	    	View footer = inflater.inflate(layoutFooterResource, this, false);
	    	if (footer != null) { 
	    		addFooterView(footer, null, false);
	    	}
		}
	}
	
	public View findViewInHeaderById(int id) {
		return findViewTraversal(id);
	}
	
	public View findViewInFooterById(int id) {
		return findViewTraversal(id);
	}
}
