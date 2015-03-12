package com.lge.selinuxlogcatcher;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SELinuxLCMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selinux_lcmain);
		
		TextView seLinuxMainTv = (TextView) findViewById(R.id.mainTv);
		seLinuxMainTv.setMovementMethod(new ScrollingMovementMethod());

		String command = String.format("logcat -d");
		try {
			Process process = Runtime.getRuntime().exec(command);
			//process.waitFor();
			
			
			//String stdout = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			StringBuilder result = new StringBuilder();
			String currentLine = null;
			
			while ((currentLine = reader.readLine()) != null) {
				if (currentLine != null) {
					result.append(currentLine);
					result.append("\n");
				}
			}
			seLinuxMainTv.setText(result.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Toast.makeText(this, "IOException", Toast.LENGTH_SHORT).show();
		}

		
		//		seLinuxMainTv.setText(text);
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
