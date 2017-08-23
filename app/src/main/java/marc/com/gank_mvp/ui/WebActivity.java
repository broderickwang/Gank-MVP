package marc.com.gank_mvp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import marc.com.gank_mvp.R;

public class WebActivity extends AppCompatActivity {
	String mUrl = "";
	@BindView(R.id.web_view)
	WebView mWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		ButterKnife.bind(this);

		WebSettings webSettings = mWebView.getSettings();
		webSettings.setUseWideViewPort(true);
		webSettings.setDefaultTextEncodingName("utf-8");
		webSettings.setLoadWithOverviewMode(true);

		mUrl = getIntent().getExtras().getString("url");
		mWebView.loadUrl(mUrl);
		mWebView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
				view.loadUrl(request.getUrl().toString());
				return true;
			}
		});
		mWebView.setWebChromeClient(new WebChromeClient(){
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				Log.d("TAG", "onProgressChanged: "+newProgress);
				super.onProgressChanged(view, newProgress);
			}
		});
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK)
		{
			if(mWebView.canGoBack())
			{
				mWebView.goBack();
				return true;
			}

		}
		return super.onKeyDown(keyCode, event);
	}
}
