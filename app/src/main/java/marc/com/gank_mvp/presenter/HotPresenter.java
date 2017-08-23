package marc.com.gank_mvp.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import marc.com.gank_mvp.R;
import marc.com.gank_mvp.bean.Hot;
import marc.com.gank_mvp.contract.HotContract;
import marc.com.gank_mvp.model.HotModel;
import marc.com.gank_mvp.ui.WebActivity;
import marc.com.gank_mvp.util.Service;
import marc.com.gank_mvp.adapter.HotAdapter;
import marc.com.multrecycleadapter.OnItemClickListner;

/**
 * Created by 王成达
 * Date: 2017/8/7
 * Time: 09:51
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public class HotPresenter implements HotContract.Presenter {

	private HotContract.View mView;
	private HotContract.Model mModel;
	private HotAdapter mAdapter;

	public HotPresenter(HotContract.View mView) {
		this.mView = mView;
		mModel = new HotModel<Hot.ResultsBean>();
	}

	@Override
	public void setData(String url) {
		Observable<Hot> hots =  Service.apiService().getHot(url);
		hots.observeOn(AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.subscribe(new Consumer<Hot>() {
					@Override
					public void accept(@NonNull Hot hot) throws Exception {
						mModel.setList(hot.getResults());
						mView.showList();
					}
				});
	}

	@Override
	public void createAdapter(final Context context) {
		mAdapter = new HotAdapter(context,null, R.layout.item);
		mAdapter.setOnClickListner(new OnItemClickListner() {
			@Override
			public void onClice(RecyclerView parent, int position) {
				Hot.ResultsBean bean = (Hot.ResultsBean) mModel.getList().get(position);

				Intent i = new Intent(context, WebActivity.class);
				i.putExtra("url",bean.getUrl());
				context.startActivity(i);
			}
		});
		mView.setAdapter(mAdapter);
	}

	@Override
	public void updateList() {
		mAdapter.setmDatas(mModel.getList());
		mAdapter.notifyDataSetChanged();
	}
}
