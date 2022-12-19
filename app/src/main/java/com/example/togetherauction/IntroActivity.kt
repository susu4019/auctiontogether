package com.example.togetherauction

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.daimajia.androidanimations.library.Techniques

class IntroActivity : AppCompatActivity() {
    private lateinit var  imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        val tv = findViewById<TextView>(R.id.tv)
        val iv = findViewById<ImageView>(R.id.iv)
        tv.visibility = View.VISIBLE
        iv.visibility = View.VISIBLE
        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        tv.startAnimation(animation)
        iv.startAnimation(animation)

        // SplashActivity가 첫 번째 화면으로 등장
        // 등장 시간이 3초
        // 3초가 지나면 MainActivity로 이동
        // Handler() --> MainThread로 메세지 전송
        // 메세지 --> SubThread가 하는 동작을 실행시켜달라는
        //          요청

        // postDelay({실행코드(Runnable)},delay time(millis))
        Handler().postDelayed(
            {
                // SplashActivity ------> MainActivity
                val intent = Intent(this, loginActivity::class.java)
                startActivity(intent)
                finish()// Activity가 Stack구조로 쌓이는데
                // Stack구조에서 제외
            },4500
        )

    }
}
