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
		//�󶨵�LocalService
		Intent intent=new Intent(this,LocalService.class);
		bindService(intent,mConnection,Context.BIND_AUTO_CREATE);
		
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		//��������İ�
		if(mBound)
		{
			unbindService(mConnection);
			mBound=false;
		}
	}
	//�����°�ťʱ���øð�ť��layout�ļ�������android:onClick�����뱾�������� */
	public void onButtonClick(View v)
	{
		if(mBound)
		{
			//����LocalService�еķ���
			//����������õ��ûᵼ��ĳЩ��������
			//��ô�߳���÷��뵥�����߳��н���
			//�Ա��⽵��Activity������
			int num=mService.getRandomNumber();
			Toast.makeText(this,"number "+num, Toast.LENGTH_SHORT).show();
		}
	}
	//��������ʱ�Ļص����������ڴ���BindService
	private ServiceConnection mConnection=new ServiceConnection()
			{
				@Override
				public void onServiceConnected(ComponentName name, IBinder service) {
					// TODO Auto-generated method stub
					//�����Ѿ��󶨵�LocalService�ˣ���IBinder����ת����cast�������LocalService�����ʵ��
					
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
