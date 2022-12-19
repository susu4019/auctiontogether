package com.example.togetherauction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignupActivity : AppCompatActivity() {
    // Firebase에서 제공하는 auth를 저장할 수 있는 공간 선언
    // lateinit를 사용해서 선언하기
    lateinit var auth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // 1) id값 초기화 하기
        val btnJoinJoin = findViewById<Button>(R.id.btnLoginJoin)
        val etJoinEmail = findViewById<EditText>(R.id.etLoginEmail)
        val etJoinPw1 = findViewById<EditText>(R.id.etLoginPw1)
        val etJoinPw2 = findViewById<EditText>(R.id.etJoinPw2)
        // 2) auth 초기화 하기
        auth = Firebase.auth

        var isJoin = true // firebase에 저장하는 코드가 실행되는 조건

        // 3) btnJoinJoin을 클릭했을 때!
        btnJoinJoin.setOnClickListener {
            // 3-1) EditText에 있는 id, pw1, pw2를 가져온다 (저장)
            val email = etJoinEmail.text.toString()
            val pw1 = etJoinPw1.text.toString()
            val pw2 = etJoinPw2.text.toString()
            // 3-2) EditText가 null인지 확인 : 3개
            // if(email.isEmpty()) : isJoin = false(firebase 저장x)
            // 토스트로 "email을 입력하세요"
            if (email.isEmpty()){
                isJoin = false // 회원가입을 진행하면 안되는 상태
                Toast.makeText(this,"email을 입력하세요",Toast.LENGTH_SHORT).show()
            }
            if (pw1.isEmpty()){
                isJoin = false
                Toast.makeText(this,"pw1을 입력하세요",Toast.LENGTH_SHORT).show()
            }
            if (pw2.isEmpty()){
                isJoin = false
                Toast.makeText(this,"pw2을 입력하세요",Toast.LENGTH_SHORT).show()
            }
            // 3-3) pw1이랑 pw2가 다르면
            // 토스트로 "비밀번호를 똑같이 입력해주세요" isJoin = false
            if (!pw1.equals(pw2)){
                isJoin = false
                Toast.makeText(this,"비밀번호가 서로 다릅니다. 다시입력하세요.",Toast.LENGTH_SHORT).show()
            }
            // 3-4) password가 6글자 이상인지 확인
            // 변수명.length "비밀번호를 6자리 이상으로 입력해주세요"
            if (pw1.length < 6 ){
                isJoin = false
                Toast.makeText(this,"비밀번호를 6자리 이상으로 입력해주세요.",Toast.LENGTH_SHORT).show()
            }
            // 4) isJoin이 true라면 FireBase에 이메일 & 비밀번호 전송(저장)
            // createUserWithEmailAndPassword
            // ifJoin : Firebase에 저장될 수 있는 조건을 다 통과 했다면
            // true
            if (isJoin){

                auth.createUserWithEmailAndPassword(email, pw1)
                    .addOnCompleteListener(this){ task ->
                        // task로 결과값 받아와서 성공인지 판단하기
                        if (task.isSuccessful){
                            //회원가입 성공
                            Toast.makeText(this,"회원가입 성공",Toast.LENGTH_SHORT).show()
                        }else{
                            //회원가입 실패
                            Toast.makeText(this,"회원가입 실패",Toast.LENGTH_SHORT).show()
                        }
                    }


            }
        }}}