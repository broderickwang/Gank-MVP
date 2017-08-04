package marc.com.gank_mvp.presenter;

import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import marc.com.gank_mvp.model.Girl;
import marc.com.gank_mvp.util.Service;
import marc.com.gank_mvp.view.IListView;

/**
 * Created by 王成达
 * Date: 2017/8/4
 * Time: 14:18
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public class ListPresenterImpl implements IListPresenter {
	private IListView mView;

	public ListPresenterImpl(IListView mView) {
		this.mView = mView;
	}

	@Override
	public void setData(String url) {

		String[] ss = url.split("-");
		if (ss.length == 2){
			Observable<Girl> girls = Service.apiService().getGirl(ss[0],ss[1]);
			girls.observeOn(AndroidSchedulers.mainThread())
					.subscribeOn(Schedulers.io())
					.subscribe(new Consumer<Girl>() {
						@Override
						public void accept(@NonNull Girl girl) throws Exception {
							mView.showList(girl.getResults());
						}
					});
		}
	}
}
