package marc.com.gank_mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import marc.com.gank_mvp.ui.GirlFragment;

public class MainActivity extends AppCompatActivity {
	@BindView(R.id.bottom_view)
	BottomNavigationView mBottomView;
	private GirlFragment mGirlFragment;
	private FragmentManager mFragmentManager;
	private FragmentTransaction mTransaction;
	private SparseArray<Fragment> mFragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		init();
	}

	private void init() {
		mFragmentManager = getSupportFragmentManager();
		mFragments = new SparseArray<>();

		mBottomView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {
				switch (item.getItemId()){
					case R.id.menu_girl:
						mGirlFragment = (GirlFragment) mFragments.get(R.id.menu_girl);
						if(mGirlFragment == null){
							mGirlFragment = GirlFragment.newInstance();
							mFragments.put(R.id.menu_girl,mGirlFragment);
						}
						changeFragment(mGirlFragment);
						break;
				}
				return true;
			}


		});
	}
	private void changeFragment(Fragment fragment) {
		mTransaction = mFragmentManager.beginTransaction();
		mTransaction.replace(R.id.frame,fragment);
		mTransaction.commit();
	}


}
