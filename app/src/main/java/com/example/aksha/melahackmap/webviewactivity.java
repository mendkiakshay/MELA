package com.example.aksha.melahackmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webviewactivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewactivity);

        WebView myWebView = new WebView(this);
        setContentView(myWebView);
        myWebView.loadUrl("https://www.arcgis.com/apps/CrowdsourceReporter/index.html?appid=4ae15082099b4112a55f6ef456252e02");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.getSettings().setBuiltInZoomControls(false);
        myWebView.getSettings().setSupportZoom(false);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setAllowFileAccess(true);
        myWebView.getSettings().setDomStorageEnabled(true);



    }
}
