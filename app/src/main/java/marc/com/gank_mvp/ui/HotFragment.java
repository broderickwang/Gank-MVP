package marc.com.gank_mvp.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import marc.com.gank_mvp.R;
import marc.com.gank_mvp.contract.HotContract;
import marc.com.gank_mvp.presenter.HotPresenter;

/**
 * Created by 王成达
 * Date: 2017/8/23
 * Time: 14:23
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public class HotFragment extends Fragment implements HotContract.View {
	@BindView(R.id.item_list)
	RecyclerView mItemList;
	Unbinder unbinder;
	private HotContract.Presenter mPresenter;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.item_fragment, container, false);
		unbinder = ButterKnife.bind(this, v);
		init();
		return v;
	}

	private void init() {
		mItemList.setLayoutManager(new LinearLayoutManager(getContext()));
		mPresenter = new HotPresenter(this);
		mPresenter.createAdapter(getContext());
		mPresenter.setData("10");
	}

	public static HotFragment newInstance() {

		Bundle args = new Bundle();

		HotFragment fragment = new HotFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}

	@Override
	public void setAdapter(RecyclerView.Adapter adapter) {
		mItemList.setAdapter(adapter);
	}

	@Override
	public void showList() {
		mPresenter.updateList();
	}

	@Override
	public FragmentActivity getAty() {
		return getActivity();
	}
}
