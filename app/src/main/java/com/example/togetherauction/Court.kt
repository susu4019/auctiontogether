package com.example.togetherauction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.togetherauction.R

class Court : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_court)
        val wv = findViewById<WebView>(R.id.wv)

        wv.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        wv.loadUrl("https://www.courtauction.go.kr/RetrieveAucTermInq.laf")
//        wv.loadUrl("https://gfauction.info/auction/map.html")

//true로 지정하면 Wide ViewPort를 사용할 수 있음

        wv.getSettings().setUseWideViewPort(true);
    }


    override fun onBackPressed() {

        val wv = findViewById<WebView>(R.id.wv)
        if (wv.canGoBack())
        {
            wv.goBack()
        }
        else
        {
            finish()
        }
    }
}
