package com.example.sample8_11;

import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class LocalService extends Service {
	//给客户端的Binder
	private final IBinder mBinder=new LocalBinder();
	//生成随机数
	private  final Random mGenerator=new Random();
	/*
	 * 用于客户端的Binder类
	 * 因为知道本服务总是运行于客户端相同的进程中
	 * 我们就不需要IPC处理
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
