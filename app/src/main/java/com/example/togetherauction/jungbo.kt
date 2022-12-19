package com.example.togetherauction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class jungbo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jungbo)
        val arrow4 = findViewById<ImageView>(R.id.arrow4)








        arrow4.setOnClickListener {
            val intent = Intent(this, Ask::class.java)
            startActivity(intent)
        }

    }
}