package com.example.dialog;

import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewHolder {
	private LinearLayout leftLayout;
	
	private LinearLayout rightLayout;
	
	private TextView leftMsg;
	
	private TextView rightMsg;
	
	public LinearLayout getLeftLayout() {
		return leftLayout;
	}
	public void setLeftLayout(LinearLayout leftLayout) {
		this.leftLayout = leftLayout;
	}
	public LinearLayout getRightLayout() {
		return rightLayout;
	}
	public void setRightLayout(LinearLayout rightLayout) {
		this.rightLayout = rightLayout;
	}
	public TextView getLeftMsg() {
		return leftMsg;
	}
	public void setLeftMsg(TextView leftMsg) {
		this.leftMsg = leftMsg;
	}
	public TextView getRightMsg() {
		return rightMsg;
	}
	public void setRightMsg(TextView rightMsg) {
		this.rightMsg = rightMsg;
	}
	
}
