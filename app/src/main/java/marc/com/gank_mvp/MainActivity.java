package marc.com.gank_mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import marc.com.gank_mvp.adapter.GirlAdapter;
import marc.com.gank_mvp.model.Girl;
import marc.com.gank_mvp.presenter.IListPresenter;
import marc.com.gank_mvp.presenter.ListPresenterImpl;
import marc.com.gank_mvp.view.IListView;

public class MainActivity extends AppCompatActivity implements IListView {

	@BindView(R.id.recycle_view)
	RecyclerView mRecycleView;
	private IListPresenter mPresenter;
	private GirlAdapter mGirlAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		init();

		mPresenter = new ListPresenterImpl(this);
		mPresenter.setData("10-1");
	}

	private void init() {
		StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
		mRecycleView.setLayoutManager(manager);
		mGirlAdapter = new GirlAdapter(MainActivity.this,null,R.layout.item_girl);
		mRecycleView.setAdapter(mGirlAdapter);
	}

	@Override
	public void showList(List list) {
		mGirlAdapter.setmDatas(list);
		mGirlAdapter.notifyDataSetChanged();
	}
}
