package com.example.dialog;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private MsgAdapter adapter;

	private List<Msg> msgList = new ArrayList<Msg>();

	private EditText inputText;

	private Button send;

	private ListView msgListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		adapter = new MsgAdapter(MainActivity.this, R.layout.msg_item, msgList);
		inputText = (EditText) findViewById(R.id.input_text);
		send = (Button) findViewById(R.id.send);
		msgListView = (ListView) findViewById(R.id.msg_list_view);
		msgListView.setAdapter(adapter);
		
		send.setOnTouchListener(new OnTouchListener() {
			
			private String content;

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					content = inputText.getText().toString();
					if(!"".equals(content)){
						Msg msg = new Msg(content, Msg.TYPE_SEND);
						msgList.add(msg);
						adapter.notifyDataSetChanged();
						msgListView.setSelection(msgList.size());
						inputText.setText("");
					}else {
						Toast.makeText(MainActivity.this, "不能输入为空~", Toast.LENGTH_SHORT).show();
					}
					break;
				case MotionEvent.ACTION_UP:
					if (!"".equals(content)) {
						String content2 = "echo: " + content;
						Msg msg2 = new Msg(content2, Msg.TYPE_RECEIVED);
						msgList.add(msg2);
						adapter.notifyDataSetChanged();
						msgListView.setSelection(msgList.size());
					}
					break;
				default:
					break;
				}
				return false;
			}
		});
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
