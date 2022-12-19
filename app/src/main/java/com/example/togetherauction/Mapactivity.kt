package com.example.togetherauction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class Mapactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapactivity)


        val wv = findViewById<WebView>(R.id.wv)



        wv.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }

//        wv.loadUrl("https://www.courtauction.go.kr/RetrieveAucTermInq.laf")
        wv.loadUrl("https://m.gfauction.info/auction/map.html")

        wv.getSettings().setUseWideViewPort(true);

    }
}