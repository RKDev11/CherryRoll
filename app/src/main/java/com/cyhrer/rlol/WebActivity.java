package com.cyhrer.rlol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView webViewPr = findViewById(R.id.Webid);
        webViewPr.loadUrl(CR.Rator("aHR0cHM6Ly93d3cucHJpdmFjeXBvbGljeW9ubGluZS5jb20vbGl2ZS5waHA/dG9rZW49eFMzdkpiUlNMNWJ2SjR6d0VIaHdJbGJQd0lJYm9CMkw="));
    }
}