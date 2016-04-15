package com.example.sample8_11;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Tab3 extends Activity {
	public static enum WhichView{MAIN,RZ};
	static WhichView curr=null;
	static WhichView pre=null;
	String stemp;
	int[] bodyIds={R.string.p1,R.string.p2,R.string.p3,R.string.p4,R.string.p5};
	int[] titleIds={R.string.z1,
			R.string.z2,
			R.string.z3,
			R.string.z4,
			R.string.z5};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		gotoMain(curr);
	}
	public void gotoMain(WhichView preTemp)
	{	
		pre=preTemp;
		this.setContentView(R.layout.tab3);
		curr=WhichView.MAIN;
		ListView lv=(ListView)this.findViewById(R.id.listView01);
		BaseAdapter ba=new BaseAdapter()
		{

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return titleIds.length;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				LinearLayout ll=new LinearLayout(Tab3.this);
				ll.setOrientation(LinearLayout.HORIZONTAL);
				ll.setPadding(5, 5, 5, 5);
				TextView tvTitle=new TextView(Tab3.this);
				tvTitle.setText(getResources().getText(titleIds[position]));
				tvTitle.setTextSize(24);
				tvTitle.setTextColor(getResources().getColor(R.color.white));
				tvTitle.setPadding(5, 5, 5, 5);
				tvTitle.setGravity(Gravity.LEFT);
				ll.addView(tvTitle);
				return ll;
			}
			
		};
		lv.setAdapter(ba);
		lv.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				StringBuilder sb=new StringBuilder();
				sb.append(getResources().getText(bodyIds[position]));
				stemp=sb.toString();
				gotoRZ(curr);
			}
			
		});
		
	}
	public void gotoRZ(WhichView preTemp)
	{
		pre=preTemp;
		this.setContentView(R.layout.tab3);
		curr=WhichView.RZ;
		this.setContentView(R.layout.diary_body);
		TextView tvBody=(TextView)this.findViewById(R.id.body);
		tvBody.setText(stemp);
		tvBody.setTextSize(20);
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode==4)
		{
			switch(curr)
			{
			case MAIN:
				System.exit(0);
				break;
			case RZ:
				gotoMain(curr);
				break;
			}
			return true;
		}
		return false;
	}
	
}
