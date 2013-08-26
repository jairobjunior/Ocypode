package com.sook.android.component.view.dialog.titledescription;

import java.io.Serializable;

public class TitleDescriptionModel implements Serializable {
	
	private static final long serialVersionUID = 3713749197807895796L;
	
	private String mTitle;
	private String mDescription;
	
	public TitleDescriptionModel(String title, String description) {
		mTitle = title;
		mDescription = description;
	}
	
	public String getTitle() {
		return mTitle;
	}
	
	public String getDescription() {
		return mDescription;
	}

}
