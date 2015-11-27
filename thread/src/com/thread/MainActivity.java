package com.thread;

import android.R.integer;
import android.support.v7.app.ActionBarActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	 private static final String TAG = "ASYNC_TASK"; 
	
	private Button execute;
	private Button cancel;
	private ProgressBar progressBar;
	
	private TextView textView;
	private MyTask mTask;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		execute 	=  (Button) findViewById(R.id.execute);
		execute.setOnClickListener(new OnClickListener() {	
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mTask = new MyTask();
				mTask.execute("http://www.baidu.com");
				
				execute.setEnabled(false);
				cancel.setEnabled(true);
			}
		});
		cancel =(Button ) findViewById(R.id.cancel);
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mTask.cancel(true);
			}
		});
		//progressBar = findViewById(R.id.progressbar);
		
		
	}
	
	private class  MyTask extends AsyncTask<String , integer, String>{
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			//super.onPreExecute();
            Log.i(TAG, "onPreExecute() called");
            textView.setText("loading...");  
		}
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		}
		@Override
		protected void onProgressUpdate(integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}
		@Override
		protected void onCancelled(String result) {
			// TODO Auto-generated method stub
			 Log.i(TAG, "onCancelled() called");
			super.onCancelled(result);
		}
		@Override
		protected void onCancelled() {
			// TODO Auto-generated method stub
			super.onCancelled();
		}
		
		
		
	}
	


}
