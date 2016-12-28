package com.example.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.WebActivity;
import com.example.model.HomeModel;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import itlanbao.com.R;

public class GalleryAdapter extends BaseAdapter {
	private List<Map> list = null;
	private Context context = null;
	private int selectNum = 0;
	private Gallery gallery;

	
	
	public GalleryAdapter(List<Map> list, Context context, Gallery gallery) {
		super();
		this.list = list;
		this.context = context;
		this.gallery = gallery;
	}

	public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

	public List<Map> getList() {
		return list;
	}

	public void setList(List<Map> list) {
		this.list = list;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public int getSelectNum() {
		return selectNum;
	}

	public void setSelectNum(int selectNum) {
		this.selectNum = selectNum;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressWarnings("deprecation")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = View.inflate(context, R.layout.image_item, null);
			holder.mainLinlayout = (LinearLayout) convertView.findViewById(R.id.mainLinlayout);
			
			holder.linone = (RelativeLayout) convertView.findViewById(R.id.linone);
			holder.linTwo = (RelativeLayout) convertView.findViewById(R.id.lintwo);
			holder.linethree = (RelativeLayout) convertView.findViewById(R.id.linethree);
			holder.lineFour = (RelativeLayout) convertView.findViewById(R.id.linfour);
			
			holder.image1=(ImageView) convertView.findViewById(R.id.image1);
			holder.image2=(ImageView) convertView.findViewById(R.id.image2);
			holder.image3=(ImageView) convertView.findViewById(R.id.image3);
			holder.image4=(ImageView) convertView.findViewById(R.id.image4);
			
			holder.mainTitle=(TextView) convertView.findViewById(R.id.mainTitleText);
			holder.text1=(TextView) convertView.findViewById(R.id.text1);
			holder.text2=(TextView) convertView.findViewById(R.id.text2);
			holder.text3=(TextView) convertView.findViewById(R.id.text3);
			holder.text4=(TextView) convertView.findViewById(R.id.text4);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		//关键点 设置当前view的位置
		if (selectNum == position) {
			holder.mainLinlayout.setLayoutParams(
					new Gallery.LayoutParams(gallery.getLayoutParams().height - 100, gallery.getLayoutParams().height));// 如果被选择则放大显示
		} else {
			holder.mainLinlayout
					.setLayoutParams(new Gallery.LayoutParams((gallery.getLayoutParams().height - 100) / 10 * 9,

			gallery.getLayoutParams().height / 10 * 9));// 否则正常
		}
		System.out.println("gallery height:" + gallery.getLayoutParams().height);
		
		HashMap dataMap=(HashMap) list.get(position);
		List cardList=(List) dataMap.get("list");
		String title=(String) dataMap.get("title");
		final HomeModel model1=(HomeModel) cardList.get(0);
		final HomeModel model2=(HomeModel) cardList.get(1);
		final HomeModel model3=(HomeModel) cardList.get(2);
		final HomeModel model4=(HomeModel) cardList.get(3);
		

		holder.image1.setBackgroundResource(model1.getImage());
		holder.image2.setBackgroundResource(model2.getImage());
		holder.image3.setBackgroundResource(model3.getImage());
		holder.image4.setBackgroundResource(model4.getImage());
		
		holder.text1.setText(model1.getTitle());
		holder.text2.setText(model2.getTitle());
		holder.text3.setText(model3.getTitle());
		holder.text4.setText(model4.getTitle());
		holder.mainTitle.setText(title);
		
		
		holder.image1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent in= new Intent(context,WebActivity.class);
				in.putExtra("url", model1.getUrl());
				context.startActivity(in);
			}
		});
		
		
		holder.image2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent in= new Intent(context,WebActivity.class);
				in.putExtra("url", model2.getUrl());
				context.startActivity(in);
			}
		});
		
		
		holder.image3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent in= new Intent(context,WebActivity.class);
				in.putExtra("url", model3.getUrl());
				context.startActivity(in);
			}
		});
		
		
		holder.image4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent in= new Intent(context,WebActivity.class);
				in.putExtra("url", model4.getUrl());
				context.startActivity(in);
			}
		});
		return convertView;
	}

}

class ViewHolder {
	LinearLayout mainLinlayout;
	RelativeLayout linTwo,linone,linethree,lineFour;
	ImageView image1,image2,image3,image4;
	TextView text1,text2,text3,text4,mainTitle;

}
