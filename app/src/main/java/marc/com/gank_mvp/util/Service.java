package marc.com.gank_mvp.util;

import marc.com.gank_mvp.net.Api;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 王成达
 * Date: 2017/8/4
 * Time: 14:45
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public class Service {
	public  static String BASE_URL = "http://gank.io/";
	public static Api apiService(){
		Retrofit retrofit = new Retrofit.Builder()
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.baseUrl(BASE_URL)
				.build();
		return retrofit.create(Api.class);
	}
}
