package com.example.sample8_11;

import android.R.color;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class Tab2 extends Activity {
	int[] imageIds={R.drawable.rank_004,R.drawable.rank_005,R.drawable.rank_006,R.drawable.rank_007,
			R.drawable.rank_008,R.drawable.rank_009};
	int[] msgIds={R.string.p1,R.string.p2,
			R.string.p3,R.string.p4,R.string.p5};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab2);
		Spinner sp=(Spinner)findViewById(R.id.spinner01);
		BaseAdapter ba=new BaseAdapter()
		{

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return msgIds.length;
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
				LinearLayout ll=new LinearLayout(Tab2.this);
				ll.setOrientation(LinearLayout.HORIZONTAL);
				ImageView ii=new ImageView(Tab2.this);
				ii.setImageDrawable(getResources().getDrawable(imageIds[position]));
				ii.setScaleType(ImageView.ScaleType.FIT_XY);
				ii.setLayoutParams(new Gallery.LayoutParams(40,40));
				ll.addView(ii);
				
				TextView tv=new TextView(Tab2.this);
				tv.setText(" "+getResources().getText(msgIds[position]));
				tv.setTextSize(24);
				tv.setTextColor(color.black);
				ll.addView(tv);
				
				return ll;
			}
			
		};
		sp.setAdapter(ba);
		sp.setOnItemSelectedListener(new OnItemSelectedListener()
		{

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				TextView tv=(TextView)findViewById(R.id.textView);
				LinearLayout ll=(LinearLayout)view;
				TextView tvn=(TextView)ll.getChildAt(1);
				StringBuilder sb=new StringBuilder();
				sb.append(getResources().getText(R.string.selected_mood));
				sb.append(":");
				sb.append(tvn.getText());
				tv.setText(sb.toString());
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

}
