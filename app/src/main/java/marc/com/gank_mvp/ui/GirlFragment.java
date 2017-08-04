package marc.com.gank_mvp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import marc.com.gank_mvp.R;
import marc.com.gank_mvp.adapter.GirlAdapter;
import marc.com.gank_mvp.presenter.IListPresenter;
import marc.com.gank_mvp.presenter.ListPresenterImpl;
import marc.com.gank_mvp.view.IListView;

/**
 * Created by 王成达
 * Date: 2017/8/4
 * Time: 15:50
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public class GirlFragment extends Fragment implements IListView {
	@BindView(R.id.recycleview)
	RecyclerView mRecycleview;
	Unbinder unbinder;
	private GirlAdapter mAdapter;
	private IListPresenter mPresenter;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.girl_fragment, container, false);
		unbinder = ButterKnife.bind(this, view);
		init();
		mPresenter.setData("10-1");
		return view;
	}

	private void init() {
		mAdapter = new GirlAdapter(getContext(),null,R.layout.item_girl);
		mRecycleview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
		mRecycleview.setAdapter(mAdapter);
		mPresenter = new ListPresenterImpl(this);
	}

	public static GirlFragment newInstance() {

		Bundle args = new Bundle();

		GirlFragment fragment = new GirlFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}

	@Override
	public void showList(List list) {
		mAdapter.setmDatas(list);
		mAdapter.notifyDataSetChanged();
	}
}
