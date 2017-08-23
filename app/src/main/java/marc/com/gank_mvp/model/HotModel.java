package marc.com.gank_mvp.model;

import java.util.List;

import marc.com.gank_mvp.bean.Hot;
import marc.com.gank_mvp.contract.HotContract;

/**
 * Created by 王成达
 * Date: 2017/8/7
 * Time: 09:51
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public class HotModel<T> implements HotContract.Model {
	private List<T> list;



	@Override
	public void setList(List list) {
		this.list = list;
	}

	@Override
	public List<T> getList() {
		return list;
	}
}
