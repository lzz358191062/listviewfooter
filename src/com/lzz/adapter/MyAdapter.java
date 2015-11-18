package com.lzz.adapter;

import java.util.ArrayList;
import java.util.List;

import com.lzz.entity.ApkEntity;
import com.lzz.listviewfooter.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private Context mContext;
	private List<ApkEntity> data = new ArrayList<ApkEntity>();
	private LayoutInflater inflater;
	public MyAdapter(Context context,List<ApkEntity> list) {
		mContext = context;
		data = list;
		inflater = LayoutInflater.from(mContext);
	}

	public void onDataChange(List<ApkEntity> list) {
		data = list;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ApkEntity item = data.get(position);
		ViewHolder holder;
		if(convertView==null){
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_layout, null);
			holder.item_name = (TextView) convertView.findViewById(R.id.item3_apkname);
			holder.item_info = (TextView) convertView.findViewById(R.id.item3_apkinfo);
			holder.item_des = (TextView) convertView.findViewById(R.id.item3_apkdes);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.item_name.setText(item.getName());
		holder.item_des.setText(item.getDes());
		holder.item_info.setText(item.getInfo());
		return convertView;
	}
	
	class ViewHolder{
		TextView item_name;
		TextView item_info;
		TextView item_des;
	}
	

}
