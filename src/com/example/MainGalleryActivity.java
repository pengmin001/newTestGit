package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.adapter.GalleryAdapter;
import com.example.model.HomeModel;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.Toast;
import itlanbao.com.R;

@SuppressLint("NewApi")
public class MainGalleryActivity extends Activity {

	private int current;
	public Gallery gallery = null;
	public GalleryAdapter adapter = null;
	private List<Map> dataList;
	// public int selectNum = 0;//全局变量，保存被选中的item

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initData();
		gallery = (Gallery) findViewById(R.id.gallery);
		// 图片
		adapter = new GalleryAdapter(dataList, this, gallery);
		adapter.setGallery(gallery);
		gallery.setAdapter(adapter);
		current = 1;
		gallery.setSelection(current);// 设置默认显示的图片
		gallery.setOnItemSelectedListener(new Gallery.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				System.out.println(arg2);
				adapter.setSelectNum(arg2);
				adapter.notifyDataSetChanged();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				System.out.println("not");
			}
		});

		gallery.setOnItemClickListener(new Gallery.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

			}
		});

	}

	public void initData() {
		dataList = new ArrayList<Map>();
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("title", "活动专区");
		List<HomeModel> list1 = new ArrayList<HomeModel>();
		HomeModel huodongModel1 = new HomeModel("注册活动", R.drawable.huodong1,
				"http://mp.weixin.qq.com/s?__biz=MzIzODAzNTY3OA==&mid=504002040&idx=1&sn=3a1b769170bc2e288f165e574d05c19b&scene=0&previewkey=R61YYqDz4MqUcHEOfTQaPp1iJUUG%2F7eLf7OA%2FVEtaJE%3D#wechat_redirect");
		HomeModel huodongModel2 = new HomeModel("消费抽奖", R.drawable.huodong2,
				"http://mp.weixin.qq.com/s?__biz=MzIzODAzNTY3OA==&mid=504002039&idx=1&sn=b533f3d206b7bf67a5b1e318a0e4777e&scene=0&previewkey=R61YYqDz4MqUcHEOfTQaPp1iJUUG%2F7eLf7OA%2FVEtaJE%3D#wechat_redirect");

		HomeModel huodongModel3 = new HomeModel("消费立送", R.drawable.huodong3,
				"http://mp.weixin.qq.com/s?__biz=MzIzODAzNTY3OA==&mid=504002042&idx=1&sn=2e20ba01d82d4416ddca9d42c166bf42&scene=0&previewkey=R61YYqDz4MqUcHEOfTQaPp1iJUUG%2F7eLf7OA%2FVEtaJE%3D#wechat_redirect");

		HomeModel huodongModel4 = new HomeModel("微信抽奖", R.drawable.huodong4,
				"http://mp.weixin.qq.com/s?__biz=MzIzODAzNTY3OA==&mid=504002031&idx=1&sn=17809ceb8dde5fa45edb9f7704423bb4&scene=0&previewkey=R61YYqDz4MqUcHEOfTQaPp1iJUUG%2F7eLf7OA%2FVEtaJE%3D#wechat_redirect");
		list1.add(huodongModel1);
		list1.add(huodongModel2);
		list1.add(huodongModel3);
		list1.add(huodongModel4);

		map1.put("list", list1);
		dataList.add(map1);

		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("title", "遛吧特色");
		List<HomeModel> list2 = new ArrayList<HomeModel>();
		HomeModel liubaModel1 = new HomeModel("积分商城", R.drawable.jifen,
				"http://114.55.36.91:8080/Liuba/jifen/index.jsp");
		HomeModel liubaModel2 = new HomeModel("转盘抽奖", R.drawable.choujiang,
				"http://114.55.36.91:8080/Liuba/choujiang/index.jsp");
		HomeModel liubaModel3 = new HomeModel("遛吧官网", R.drawable.card, "http://www.51liuba.com");
		HomeModel liubaModel4 = new HomeModel("遛卡说明", R.drawable.about,
				"http://mp.weixin.qq.com/s?__biz=MzIzODAzNTY3OA==&mid=504002046&idx=1&sn=2d77d54add0a842e93805f43f85b07a7&scene=0&previewkey=R61YYqDz4MqUcHEOfTQaPp1iJUUG%2F7eLf7OA%2FVEtaJE%3D#wechat_redirect");

		list2.add(liubaModel1);
		list2.add(liubaModel2);
		list2.add(liubaModel3);
		list2.add(liubaModel4);

		map2.put("list", list2);
		dataList.add(map2);
		
		
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("title", "遛吧生活");
		List<HomeModel> list3 = new ArrayList<HomeModel>();
		HomeModel tuiwenModel1=new HomeModel("宠物生活", R.drawable.tuiwen1, "http://mp.weixin.qq.com/s?__biz=MzIzODAzNTY3OA==&mid=504002032&idx=1&sn=54fbd63fb9d3a127691597d6835bc40d&scene=0&previewkey=R61YYqDz4MqUcHEOfTQaPp1iJUUG%2F7eLf7OA%2FVEtaJE%3D");
		HomeModel tuiwenModel2=new HomeModel("关爱宠物", R.drawable.tuiwen2, "http://mp.weixin.qq.com/s?__biz=MzIzODAzNTY3OA==&mid=504002035&idx=1&sn=279b714838cc306ad369591f4532645b&scene=0&previewkey=R61YYqDz4MqUcHEOfTQaPp1iJUUG%2F7eLf7OA%2FVEtaJE%3D");
		HomeModel tuiwenModel3=new HomeModel("养宠指南", R.drawable.tuiwei3, "http://mp.weixin.qq.com/s?__biz=MzIzODAzNTY3OA==&mid=504002034&idx=1&sn=fe641cbfcf7ffb80f910a16ed20f1d0e&scene=0&previewkey=R61YYqDz4MqUcHEOfTQaPp1iJUUG%2F7eLf7OA%2FVEtaJE%3D");
		HomeModel tuiwenModel4=new HomeModel("选宠推荐", R.drawable.tuiwen4, "http://mp.weixin.qq.com/s?__biz=MzIzODAzNTY3OA==&mid=504002033&idx=1&sn=fe1b48fab285e7b07b6dff815b1e6a82&scene=0&previewkey=R61YYqDz4MqUcHEOfTQaPp1iJUUG%2F7eLf7OA%2FVEtaJE%3D");
				list3.add(tuiwenModel1);
				list3.add(tuiwenModel2);
				list3.add(tuiwenModel3);
				list3.add(tuiwenModel4);
				map3.put("list", list3);
		dataList.add(map3);

	}
}
