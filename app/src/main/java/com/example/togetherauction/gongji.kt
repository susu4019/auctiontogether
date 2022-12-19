package com.example.togetherauction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class gongji : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gongji)
        val arrow3 = findViewById<ImageView>(R.id.arrow3)





        arrow3.setOnClickListener {
            val intent = Intent(this, Ask::class.java)
            startActivity(intent)
        }



    }
}