package com.sook.android.activity;

import android.content.Intent;

public interface IResultCallbackActivity {

	public void onResultOk(Intent data);

	public void onResultCancel(Intent data);
}
