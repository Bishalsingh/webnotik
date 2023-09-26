package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.evaluateJavascript("document.body.style.background = 'blue';", null);
        //url of our offerwall page and it was working without the 24 metrics and didnot with 24metrics
        webView.loadUrl("https://notik.me/coins?api_key=kahYDyDX5Z9KtolN4Mcgk3C88YYS7Kqi&pub_id=i3kQ9n&app_id=kiBcZY7Qd3&user_id=bishal");

        // same thing without 24metrics check this
       // webView.loadUrl("https://notik.me/testoffers");

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Log.d("MyApplication", consoleMessage.message() + " -- From line " +
                        consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
                return true;
            }
        });
    }
}