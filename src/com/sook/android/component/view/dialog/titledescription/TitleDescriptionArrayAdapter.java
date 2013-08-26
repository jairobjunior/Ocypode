package com.sook.android.component.view.dialog.titledescription;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sook.R;

public class TitleDescriptionArrayAdapter<T extends TitleDescriptionModel> extends ArrayAdapter<T> {
	
	private ArrayList<T> mEntries;
    private Activity mActivity;
	
	public TitleDescriptionArrayAdapter(Activity activity, int textViewResourceId, ArrayList<T> entries) {
        super(activity, textViewResourceId, entries);
        mEntries = entries;
        mActivity = activity;
    }
	
	public static class TitleDescriptionViewHolder{
        public TextView title;
        public TextView description;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        TitleDescriptionViewHolder titleDescriptionHolder;
        if (view == null) {
            LayoutInflater viewInflate =
                (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = viewInflate.inflate(R.layout.title_description_list_view, null);
            titleDescriptionHolder = new TitleDescriptionViewHolder();
            titleDescriptionHolder.title = (TextView) view.findViewById(R.id.title_description_list_view_title_label);
            titleDescriptionHolder.description = (TextView) view.findViewById(R.id.title_description_list_view_description_label);
            view.setTag(titleDescriptionHolder);
        } else {
            titleDescriptionHolder = (TitleDescriptionViewHolder) view.getTag();
        }
 
        final T titleDescriptionModel = mEntries.get(position);
        if (titleDescriptionModel != null) {
            titleDescriptionHolder.title.setText(titleDescriptionModel.getTitle());
            titleDescriptionHolder.description.setText(titleDescriptionModel.getDescription());
        }
        return view;
    }
}
