package marc.com.gank_mvp.contract;

import java.util.List;

/**
 * Created by 王成达
 * Date: 2017/8/7
 * Time: 09:51
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public interface HotContract {
	interface Model {
	}

	interface View<T> {
		void showList(List<T> list);
	}

	interface Presenter {
		void setData(String url);

		void createAdapter();
	}
}
