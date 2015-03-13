package com.lge.selinuxlogcatcher;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SELinuxLCMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selinux_lcmain);
		
		ListView logListView = (ListView) findViewById(R.id.logListView);
		
		SELinuxLogItemMgr logItemMgr = new SELinuxLogItemMgr();
		
		/*SELinuxLogItem logItem = new SELinuxLogItem("avc denied", "scontext:sensor");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:atd");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:logd");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:fs");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:untrusted_app");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:platform_app");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:platform_app");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:platform_app");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:platform_app");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:platform_app");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:platform_app");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:platform_app");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:platform_app");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:platform_app");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:platform_app");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:platform_app");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:platform_app");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:platform_app");
		logItemMgr.addList(logItem);
		logItem = new SELinuxLogItem("avc denied", "scontext:platform_app");
		logItemMgr.addList(logItem);
		*/	
		
		LogCustomView logCustomView = new LogCustomView(logItemMgr.getLogItemList());
		logListView.setAdapter(logCustomView);
//		TextView seLinuxMainTv = (TextView) findViewById(R.id.mainTv);
//		seLinuxMainTv.setMovementMethod(new ScrollingMovementMethod());
//
//		String command = String.format("logcat -d");
//		try {
//			Process process = Runtime.getRuntime().exec(command);
//			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//			StringBuilder result = new StringBuilder();
//			String currentLine = null;
//			
//			while ((currentLine = reader.readLine()) != null) {
//				if (currentLine != null) {
//					result.append(currentLine);
//					result.append("\n");
//				}
//			}
//			seLinuxMainTv.setText(result.toString());
//		} catch (Exception e) {
//			Toast.makeText(this, "IOException", Toast.LENGTH_SHORT).show();
//		}

	}

	public class LogCustomView extends BaseAdapter {

		ArrayList<SELinuxLogItem> logItemList;
				
		public LogCustomView(ArrayList<SELinuxLogItem> logItemList) {
			super();
			this.logItemList = logItemList;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return logItemList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return logItemList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			View logView = inflater.inflate(R.layout.log_item_row, null);
			TextView tagTextView = (TextView) logView.findViewById(R.id.tagTextView);
			TextView logTextView = (TextView) logView.findViewById(R.id.logTextView);
			SELinuxLogItem logItem = logItemList.get(position);
			tagTextView.setText(logItem.getTag());
			logTextView.setText(logItem.getLog());
			return logView;
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.selinux_lcmain, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
