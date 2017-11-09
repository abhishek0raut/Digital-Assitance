package com.afe.da;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class Browser extends Activity {
    String Url = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0058R.layout.browser);
        TextView tb = (TextView) findViewById(C0058R.id.textView1);
        WebView Wb = (WebView) findViewById(C0058R.id.web);
        Wb.setWebViewClient(new ourBrow());
        this.Url = "http://www.evi.com/q/" + getIntent().getExtras().getString("key").replace(" ", "_");
        tb.setText(this.Url);
        if (this.Url.equals("")) {
            Wb.loadUrl("http://www.google.com");
        } else {
            Wb.loadUrl(this.Url);
        }
    }

    public void putUrl(String s) {
        this.Url = "http://www.wolframalpha.com/input/?i=";
    }
}
