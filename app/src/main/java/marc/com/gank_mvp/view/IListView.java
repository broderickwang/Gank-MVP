package marc.com.gank_mvp.view;

import java.util.List;

/**
 * Created by 王成达
 * Date: 2017/8/4
 * Time: 14:12
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public interface IListView<T> {

	void showList(List<T> list);
}
