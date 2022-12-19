package com.example.togetherauction

import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.math.log

class Ask : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ask)
        val arrow1 = findViewById<ImageView>(R.id.arrow1)
        val gong = findViewById<TextView>(R.id.textView15)
        val gong1 = findViewById<TextView>(R.id.textView19)
        val out = findViewById<TextView>(R.id.textView21)
        val logout = findViewById<TextView>(R.id.textView20)
        auth = Firebase.auth


        gong1.setOnClickListener {
            val intent = Intent(this,jungbo::class.java)
            startActivity(intent)
        }


        gong.setOnClickListener {
            val intent = Intent(this,gongji::class.java)
            startActivity(intent)
        }



        arrow1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        logout.setOnClickListener {
            onBack()
        }
        out.setOnClickListener {
            onBackPressed()
        }
    }



    override fun onBackPressed() {
        val dlg: AlertDialog.Builder = AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth)
        dlg.setTitle("⚠️ 경고") //제목
        dlg.setMessage("탈퇴하시겠습니까?") // 메시지
        dlg.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
            if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
                // Workaround for Android Q memory leak issue in IRequestFinishCallback$Stub.
                // (https://issuetracker.google.com/issues/139738913)
                val intent = Intent(this, loginActivity::class.java)
                startActivity(intent)
                delete()
                finishAfterTransition()

            } else {
                super.onBackPressed()
            }
        })
        dlg.setNegativeButton("취소", DialogInterface.OnClickListener{
                dialog, which ->
            // Do nothing
        })
        dlg.show()
    }
    fun onBack() {
        val dlg: AlertDialog.Builder = AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth)
        dlg.setTitle("⚠️ 경고") //제목
        dlg.setMessage("로그아웃 하시겠습니까?") // 메시지
        dlg.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
            if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
                // Workaround for Android Q memory leak issue in IRequestFinishCallback$Stub.
                // (https://issuetracker.google.com/issues/139738913)
                val intent = Intent(this, loginActivity::class.java)
                startActivity(intent)
                finishAfterTransition()

            } else {
                super.onBackPressed()
            }
        })
        dlg.setNegativeButton("취소", DialogInterface.OnClickListener{
                dialog, which ->
            // Do nothing
        })
        dlg.show()
    }
    fun delete() {
        auth.currentUser!!.delete()
    }
}