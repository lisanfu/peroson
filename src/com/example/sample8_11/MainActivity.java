package com.example.sample8_11;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabWidget;
import android.widget.TextView;
public class MainActivity extends Activity {
	private TabWidget tabWidget; 
	TabHost tabHost;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tabHost=(TabHost)findViewById(android.R.id.tabhost);
		LayoutInflater.from(this).inflate(R.layout.activity_main, tabHost.getTabContentView(),true);
		tabWidget=tabHost.getTabWidget();
		tabHost.addTab(tabHost.newTabSpec("Tab1").setIndicator("‰Ø¿¿œ‡≤·",
				getResources().getDrawable(R.drawable.background)).setContent(new Intent(MainActivity.this,Tab1.class)));
		tabHost.setCurrentTab(0);
		for(int i=0;i<tabWidget.getChildCount();i++)
		{
			View v=tabWidget.getChildAt(i);
			v.setBackgroundResource(R.drawable.tab_indicator);
			TextView tv=(TextView)tabWidget.getChildAt(i).findViewById(android.R.id.title);
			tv.setTextColor(Color.WHITE);
			tv.setTextSize(15);
		}
		tabHost.setOnTabChangedListener(new OnTabChangeListener()
		{
			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				if(tabId.equals("Tab1"))
				{
					tabHost.setCurrentTabByTag("Tab1");
				}
			}
		});	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
