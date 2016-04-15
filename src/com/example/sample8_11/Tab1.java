package com.example.sample8_11;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class Tab1 extends Activity {
	int [] imageIds={R.drawable.woaf01,
			R.drawable.woaf02,
			R.drawable.woaf03,
			R.drawable.woaf04,R.drawable.woaf01,R.drawable.woaf02,
			R.drawable.woaf03};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab);
		Gallery gl=(Gallery)findViewById(R.id.gallery);
		BaseAdapter ba=new BaseAdapter()
		{

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return imageIds.length;
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
				ImageView iv=new ImageView(Tab1.this);
				iv.setImageResource(imageIds[position]);
				iv.setScaleType(ImageView.ScaleType.FIT_XY);
				iv.setLayoutParams(new Gallery.LayoutParams(256,127));
				return iv;
			}
			
		};
		gl.setAdapter(ba);
		gl.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Gallery gl=(Gallery)findViewById(R.id.gallery);
				gl.setSelection(position);
			}
			
		});
	}

}
