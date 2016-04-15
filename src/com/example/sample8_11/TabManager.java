package com.example.sample8_11;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;

public class TabManager extends TabActivity {
	private TabWidget tabWidget; 
	TabHost tabHost;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tabHost=(TabHost)findViewById(android.R.id.tabhost);
		LayoutInflater.from(this).inflate(R.layout.activity_main, tabHost.getTabContentView(),true);
		tabWidget=tabHost.getTabWidget();
		tabHost.addTab(tabHost.newTabSpec("Tab1").setIndicator("浏览相册",
				getResources().getDrawable(R.drawable.background)).setContent(new Intent(this,Tab1.class)));
		tabHost.addTab(tabHost.newTabSpec("Tab2").setIndicator("发表性情",
				getResources().getDrawable(R.drawable.background02)).setContent(new
						Intent(this,Tab2.class)));
		tabHost.addTab(tabHost.newTabSpec("Tab3").setIndicator("查看日志",
				getResources().getDrawable(R.drawable.background03)).setContent(new 
						Intent(this,Tab3.class)));
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
				else if(tabId.equals("Tab2"))
				{
					tabHost.setCurrentTabByTag("Tab2");
				}
				else if(tabId.equals("Tab3"))
				{
					tabHost.setCurrentTabByTag("Tab3");
				}
				
				
			}
		});	
	}
	
}
