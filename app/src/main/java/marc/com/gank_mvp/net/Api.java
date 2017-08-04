package marc.com.gank_mvp.net;

import io.reactivex.Observable;
import marc.com.gank_mvp.model.Girl;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by 王成达
 * Date: 2017/8/4
 * Time: 14:42
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public interface Api {

	@GET("api/data/福利/{pagenumber}/{pagesize}")
	Observable<Girl> getGirl(@Path("pagenumber")String number,@Path("pagesize")String size);
}
