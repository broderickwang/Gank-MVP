package marc.com.gank_mvp.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import marc.com.gank_mvp.R;
import marc.com.gank_mvp.bean.Girl;
import marc.com.multrecycleadapter.CommonRecycleAdapter;
import marc.com.multrecycleadapter.ViewHolder;

/**
 * Created by 王成达
 * Date: 2017/8/4
 * Time: 14:39
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public class GirlAdapter extends CommonRecycleAdapter<Girl.ResultsBean> {

	public GirlAdapter(Context context, List<Girl.ResultsBean> datas, int layoutId) {
		super(context, datas, layoutId);
	}

	@Override
	public void convert(ViewHolder holder,final Girl.ResultsBean item) {
		holder.setImageByUrl(R.id.image_girl, new ViewHolder.ImageLoader(item.getUrl()) {
			@Override
			public void displayImage(Context context, ImageView imageView, String imagePath) {
				Glide.with(context).load(item.getUrl()).into(imageView);
			}
		});
	}

	@Override
	public int getLayoutId(Object item, int position) {
		return 0;
	}
}
/*
public class GirlAdapter extends RecyclerView.Adapter<GirlAdapter.ViewHolder> {

	private List<Girl.ResultsBean> mDatas = null;
	private Context mContext;

	public GirlAdapter(Context mContext) {
		this.mContext = mContext;
	}

	public void setDatas(List<Girl.ResultsBean> datas) {
		this.mDatas = datas;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(mContext).inflate(R.layout.item_girl,parent,false);
		return new ViewHolder(v);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		Glide.with(mContext).load(mDatas.get(position).getUrl()).into(holder.imageView);
	}

	@Override
	public int getItemCount() {
		return mDatas==null?0:mDatas.size();
	}

	static class ViewHolder extends RecyclerView.ViewHolder{
		private ImageView imageView;
		public ViewHolder(View itemView) {
			super(itemView);
			imageView = (ImageView) itemView.findViewById(R.id.image_girl);
		}
	}
}
*/
