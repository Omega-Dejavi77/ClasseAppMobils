package cat.tecnocampus.mobileapps.practica2.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.web_view);
        //webView.setWebViewClient(new WebViewClient());
        //webView.loadUrl("https://www.tecnocampus.cat");

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                //return !request.getUrl().getHost().contains("tecnocampus.cat");
                return false;
            }
        });

        webView.addJavascriptInterface(new WebAppInterface(this), "android");

        webView.loadUrl("file:///android_asset/index-html");

    }

    public class WebAppInterface {
        Context context;

        public WebAppInterface(Context context) {
            this.context = context;
        }

        @JavascriptInterface
        public void showToast(String content) {
            Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
        }
    }

}
