package marc.com.gank_mvp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;

import java.util.List;

import marc.com.gank_mvp.R;
import marc.com.gank_mvp.bean.Hot;
import marc.com.multrecycleadapter.CommonRecycleAdapter;
import marc.com.multrecycleadapter.ViewHolder;

/**
 * Created by 王成达
 * Date: 2017/8/23
 * Time: 14:24
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public class HotAdapter extends CommonRecycleAdapter<Hot.ResultsBean> {
	private Context mContext;
	public HotAdapter(Context context, List<Hot.ResultsBean> datas, int layoutId) {
		super(context, datas, layoutId);
		this.mContext = context;
	}

	@Override
	public void convert(ViewHolder holder, Hot.ResultsBean item) {
		holder.setText(R.id.item_description,item.getDesc());
		holder.setText(R.id.item_publish_time,item.getPublishedAt());
		holder.setText(R.id.item_publish_who,item.getWho());
		holder.setText(R.id.item_type,item.getType());
		switch (item.getType()){
			case "Android":
				setColor(holder,mContext.getResources().getColor(R.color.color_android_bg,null));
				break;
			case "iOS":
				setColor(holder,mContext.getResources().getColor(R.color.color_ios_bg,null));
				break;
		}
	}

	private void setColor(ViewHolder holder,int color){
		holder.setBackgroundColor(R.id.item_type,color);
	}

	@Override
	public int getLayoutId(Object item, int position) {
		return  R.layout.item;
	}
}
