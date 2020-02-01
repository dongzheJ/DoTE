package com.example.dotb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView mW;
    private View call_js;
    private EditText eT;
    private String id;
    private String data;

    @Override
    @SuppressLint("JavascriptInterface")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        //
        mW = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mW.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mW.loadUrl("file:///android_asset/index.html");
        mW.addJavascriptInterface(MainActivity.this, "test");
        mW.setBackgroundColor(Color.TRANSPARENT);
        //
        call_js = findViewById(R.id.call_js);
        call_js.setOnClickListener(this);
        //
        eT = findViewById(R.id.input);
        //
//        int startColor = 0xfff6ee19; // yellow
//        int endColor = 0xff115ede;   // blue
//        GradientDrawable gradientDrawable = new GradientDrawable(
//                GradientDrawable.Orientation.LEFT_RIGHT,
//                new int[] {startColor, endColor});
//
//        View myView = findViewById(R.id.my_view);
//        myView.setBackgroundDrawable(gradientDrawable);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.call_js:
                id = eT.getText().toString();
                performCallJs(id);
                break;
            default:
                break;
        }
    }

    private void performCallJs(String id) {
        mW.loadUrl("javascript:setData(" + id + ")");
//        mW.loadUrl("javascript:hero()");

//        mW.loadUrl("javascript:chart()");
//        mW.loadUrl("javascript:chart("+ id + ")");
    }
}
