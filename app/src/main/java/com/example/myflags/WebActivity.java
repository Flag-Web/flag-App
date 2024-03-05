package com.example.myflags;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView web=findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);

        String url=getIntent().getStringExtra("lienr");
        web.loadUrl(url);
    }
}