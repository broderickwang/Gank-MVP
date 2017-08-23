package marc.com.gank_mvp.contract;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import marc.com.gank_mvp.bean.Hot;

/**
 * Created by 王成达
 * Date: 2017/8/7
 * Time: 09:51
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public interface HotContract {
	interface Model<T> {

		void setList(List<T> list);

		List<T> getList();
	}

	interface View<T> {
		void setAdapter(RecyclerView.Adapter adapter);

		void showList();

		FragmentActivity getAty();
	}

	interface Presenter {
		void setData(String url);

		void createAdapter(Context context);

		void updateList();
	}
}
