package com.example.togetherauction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class loginActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_login_join = findViewById<Button>(R.id.btn_login_join)
        val edt_login_id = findViewById<EditText>(R.id.edt_login_id)
        val edt_login_pw = findViewById<EditText>(R.id.edt_login_pw)

        auth = Firebase.auth

        var isJoin = true // firebase에 저장하는 코드가 실행되는 조건
        // 2-1) Oncreate 밖에 lateinit 선언
        // 2-2) Oncreate 안에서 auth 초기화하기

        btn_login.setOnClickListener{
            val email = edt_login_id.text.toString()
            val pw1 = edt_login_pw.text.toString()
            auth.signInWithEmailAndPassword(email, pw1)
                .addOnCompleteListener(this){ task ->
                    // task로 결과값 받아와서 성공인지 판단하기
                    if (task.isSuccessful){



                        val intent = Intent(this, LoadingActivity::class.java)
                        startActivity(intent)

                    }else{
                        //로그인 실패
                        Toast.makeText(this,"로그인 실패", Toast.LENGTH_SHORT).show()
                    }
                }
        }



        btn_login_join.setOnClickListener {
            val intent2 = Intent(this, SignupActivity::class.java)
            startActivity(intent2)
        }
    }
}