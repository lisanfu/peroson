package com.example.sample8_11;

import com.example.sample8_11.LocalService.LocalBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

public class BindingActivity extends Activity {
	LocalService mService;
	boolean mBound=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//绑定到LocalService
		Intent intent=new Intent(this,LocalService.class);
		bindService(intent,mConnection,Context.BIND_AUTO_CREATE);
		
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		//解除与服务的绑定
		if(mBound)
		{
			unbindService(mConnection);
			mBound=false;
		}
	}
	//当按下按钮时调用该按钮在layout文件中利用android:onClick属性与本方法关联 */
	public void onButtonClick(View v)
	{
		if(mBound)
		{
			//调用LocalService中的方法
			//不过，如果该调用会导致某些操作挂起
			//那么线程因该放入单独的线程中进行
			//以避免降低Activity的性能
			int num=mService.getRandomNumber();
			Toast.makeText(this,"number "+num, Toast.LENGTH_SHORT).show();
		}
	}
	//定义服务绑定时的回调方法，用于传递BindService
	private ServiceConnection mConnection=new ServiceConnection()
			{
				@Override
				public void onServiceConnected(ComponentName name, IBinder service) {
					// TODO Auto-generated method stub
					//我们已经绑定到LocalService了，对IBinder进行转化（cast）并获得LocalService对象的实例
					
					LocalBinder binder=(LocalBinder)service;
					mService=binder.getService();
					mBound=true;
				}
				@Override
				public void onServiceDisconnected(ComponentName name) {
					// TODO Auto-generated method stub
					
				}
			};
}
