package com.lzz.view;

import com.lzz.listviewfooter.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

public class LoadListView extends ListView implements OnScrollListener{
	
	View footer;
	private int lastVisibleItem;
	private int totalItemCount;
	public LoadListView(Context context) {
		super(context);
		init(context);
	}
	public LoadListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public LoadListView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	private void init(Context context) {
		LayoutInflater inflater = LayoutInflater.from(context);
		footer = inflater.inflate(R.layout.footer_layout, null);
		footer.findViewById(R.id.load_layout).setVisibility(View.GONE);
		this.addFooterView(footer);
		this.setOnScrollListener(this);
	}
	
	
	private boolean loading = false;
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		if(lastVisibleItem==totalItemCount&&scrollState==SCROLL_STATE_IDLE){
			if(!loading){
				loading = true;
				footer.findViewById(R.id.load_layout).setVisibility(View.VISIBLE);
				mIloadListner.onLoad();
			}
		}
		
	}
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		this.lastVisibleItem = firstVisibleItem + visibleItemCount;
		this.totalItemCount = totalItemCount;
	}

	public void loadComplete(){
		loading = false;
		footer.findViewById(R.id.load_layout).setVisibility(View.GONE);
	}


	private IloadListner mIloadListner;
	public void setInterface(IloadListner iloadListner){
		mIloadListner = iloadListner;
	}
	
	public interface IloadListner{
		public void onLoad();
	}
	
	

}
