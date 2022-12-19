package com.example.togetherauction

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.togetherauction.databinding.ActivityApartmentDetailBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class FranchiseDetail : AppCompatActivity() {
    var totalcount: Int = 0
    lateinit var  rv2 : RecyclerView
    lateinit var binding: ActivityApartmentDetailBinding
    lateinit var db: DatabaseReference
    lateinit var ref : StorageReference
    lateinit var sgNum : String
    lateinit var profileadapter : ProfileAdapter5
    var num: String = "0"
    var listItemList2 = ArrayList<listItemVO2>()
    var listItemList3 = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApartmentDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pos = intent.getIntExtra("index",0)
        val mg = intent.getStringExtra("mg").toString()





        rv2 = findViewById<RecyclerView>(R.id.rv2)

        // 탭 설정
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // 탭이 선택 되었을 때
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // 탭이 선택되지 않은 상태로 변경 되었을 때
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
                // 이미 선택된 탭이 다시 선택 되었을 때
            }
        })
        val back = findViewById<ImageView>(R.id.back)
        back.setOnClickListener {
            val intent = Intent(this, FranchiseList::class.java )
            startActivity(intent)
        }
        // 뷰페이저에 어댑터 연결
        binding.pager.adapter = ViewPagerAdapter(this,pos,mg)
        /* 탭과 뷰페이저를 연결, 여기서 새로운 탭을 다시 만드므로 레이아웃에서 꾸미지말고
        여기서 꾸며야함
         */
        TabLayoutMediator(binding.tabLayout, binding.pager) {tab, position ->
            when(position) {
                0 -> tab.text = "기본정보"
                1 -> tab.text = "투자정보"
            }
        }.attach()


        db = FirebaseDatabase.getInstance("https://sangga.firebaseio.com/").reference
        db.get().addOnSuccessListener {
            totalcount = Integer.parseInt(it.childrenCount.toString())
            db.addValueEventListener(object :
                ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    listItemList2.clear()
                    sgNum = snapshot.child("$pos").child("mulBasic").child("sgNum").value.toString()
                    var storage = FirebaseStorage.getInstance("gs://samjokoh-f42d4.appspot.com/")
                    val StorageReference = storage.getReference("사건폴더")
                    for (i in 1 until 4){
                        ref = StorageReference.child("$sgNum").child("$i"+".jpg")
                        Log.d("sdfdsfsdf","$ref")
                        num = i.toString()
                        var vo = listItemVO2(ref,num)

                        listItemList2.add(vo)
                    }
                    rv2.adapter?.notifyDataSetChanged()}



                override fun onCancelled(error: DatabaseError) {
                }
            })
        }.addOnFailureListener{
//            Log.e("error","error발생")
        }








        val intent = intent
        val b = intent.getStringExtra("1")
        var tv_name = findViewById<TextView>(R.id.tv_name)
        Log.d("333",b.toString())
        tv_name.setText(b)

        rv2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv2.setHasFixedSize(true)
        rv2.adapter = ProfileAdapter5(listItemList2)
        rv2.addItemDecoration(
            DividerItemDecoration(applicationContext, DividerItemDecoration.HORIZONTAL)
        )

    }
}