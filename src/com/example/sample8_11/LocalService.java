package com.example.sample8_11;

import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class LocalService extends Service {
	//���ͻ��˵�Binder
	private final IBinder mBinder=new LocalBinder();
	//���������
	private  final Random mGenerator=new Random();
	/*
	 * ���ڿͻ��˵�Binder��
	 * ��Ϊ֪�����������������ڿͻ�����ͬ�Ľ�����
	 * ���ǾͲ���ҪIPC����
	 * 
	 * */
	public class LocalBinder extends Binder
	{
		LocalService getService()
		{
			return LocalService.this;
		}
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return mBinder;
	}
	public int getRandomNumber()
	{
		return mGenerator.nextInt(100);
	} 
}
