package marc.com.gank_mvp.presenter;

import java.util.List;

import marc.com.gank_mvp.view.IListView;

/**
 * Created by 王成达
 * Date: 2017/8/4
 * Time: 14:13
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public interface IListPresenter<T> {
	void setData(String url);
}
