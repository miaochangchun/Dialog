package com.example.dialog;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MsgAdapter extends ArrayAdapter<Msg>{
	
	private int resourceId;

	public MsgAdapter(Context context, int textViewResourceId, List<Msg> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Msg msg = getItem(position);
		View view;
		ViewHolder viewHolder;
		if(convertView == null){
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.setLeftLayout((LinearLayout) view.findViewById(R.id.left_layout));
			viewHolder.setRightLayout((LinearLayout) view.findViewById(R.id.right_layout));
			viewHolder.setLeftMsg((TextView) view.findViewById(R.id.left_msg));
			viewHolder.setRightMsg((TextView) view.findViewById(R.id.right_msg));
			
			view.setTag(viewHolder);
		}else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		if (msg.getType() == Msg.TYPE_RECEIVED) {
			viewHolder.getLeftLayout().setVisibility(View.VISIBLE);
			viewHolder.getRightLayout().setVisibility(View.INVISIBLE);
			viewHolder.getLeftMsg().setText(msg.getContent());
		}else {
			viewHolder.getRightLayout().setVisibility(View.VISIBLE);
			viewHolder.getLeftLayout().setVisibility(View.INVISIBLE);
			viewHolder.getRightMsg().setText(msg.getContent());
		}
		return view;
	}

}
