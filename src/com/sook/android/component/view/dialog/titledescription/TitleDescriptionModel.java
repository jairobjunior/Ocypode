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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mDescription == null) ? 0 : mDescription.hashCode());
		result = prime * result + ((mTitle == null) ? 0 : mTitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TitleDescriptionModel other = (TitleDescriptionModel) obj;
		if (mDescription == null) {
			if (other.mDescription != null)
				return false;
		} else if (!mDescription.equals(other.mDescription))
			return false;
		if (mTitle == null) {
			if (other.mTitle != null)
				return false;
		} else if (!mTitle.equals(other.mTitle))
			return false;
		return true;
	}
}