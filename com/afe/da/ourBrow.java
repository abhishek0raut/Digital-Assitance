package com.afe.da;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ourBrow extends WebViewClient {
    public boolean shouldOverrideUrlLoading(WebView v, String url) {
        v.loadUrl(url);
        return true;
    }
}
