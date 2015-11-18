package com.lzz.listviewfooter;

import java.util.ArrayList;
import java.util.List;

import com.lzz.adapter.MyAdapter;
import com.lzz.entity.ApkEntity;
import com.lzz.view.LoadListView;
import com.lzz.view.LoadListView.IloadListner;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity implements IloadListner{

	private LoadListView mListView;
	private MyAdapter myAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getData();
		show();
	}
	private void show() {
		if(myAdapter==null){
			mListView = (LoadListView) findViewById(R.id.listview);
			myAdapter = new MyAdapter(this, list);
			mListView.setAdapter(myAdapter);
			mListView.setInterface(this);
		}else{
			myAdapter.onDataChange(list);
		}
	}

	private List<ApkEntity> list = new ArrayList<ApkEntity>();
	private void getData() {
		for(int i=0;i<10;i++){
			ApkEntity entity = new ApkEntity();
			entity.setName("���ǵ�"+i+"����Ϸ������");
			entity.setInfo("���ǵ�"+i+"����Ϸ��Ϣ");
			entity.setDes("���ǵ�"+i+"����Ϸ����");
			list.add(entity);
		}
	}
	public void onLoad(){
		Handler mHandler = new Handler();
		mHandler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				getLoadData();
				show();
				mListView.loadComplete();
			}
		}, 2000);
	}
	private void getLoadData() {
		for(int i=0;i<5;i++){
			ApkEntity entity = new ApkEntity();
			entity.setName("this add ��"+i+"����Ϸ������");
			entity.setInfo("this add ��"+i+"����Ϸ��Ϣ");
			entity.setDes("this add ��"+i+"����Ϸ����");
			list.add(entity);
		}
		mListView.loadComplete();
	}
	
	
	

}
