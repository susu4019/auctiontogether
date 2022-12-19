package com.example.togetherauction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    var totalcount: Int = 0
    lateinit var haveList : String
    lateinit var lowPrice : String
    lateinit var gjpyeong : String
    lateinit var sellDate : String
    lateinit var yuchal : String
    lateinit var sgNum : String
    lateinit var  mulUrl : String
    lateinit var profileadapter : ProfileAdapter
    lateinit var profileadapter2 : ProfileAdapter2
    lateinit var profileadapter3 : ProfileAdapter3
    lateinit var profileadapter4 : ProfileAdapter4
    var listItemList = ArrayList<listItemVO>()
    var listItemList2 = ArrayList<listItemVO>()
    var listItemList3 = ArrayList<listItemVO>()
    var listItemList4 = ArrayList<listItemVO>()
    lateinit var db: DatabaseReference
    lateinit var db2: DatabaseReference
    lateinit var db3: DatabaseReference
    lateinit var db4: DatabaseReference
    lateinit var  rv_apt : RecyclerView
    lateinit var  rv_house : RecyclerView
    lateinit var  rv_office : RecyclerView
    lateinit var  rv_franchise : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_apt = findViewById<RecyclerView>(R.id.rv_apt)
        rv_house = findViewById<RecyclerView>(R.id.rv_house)
        rv_office = findViewById<RecyclerView>(R.id.rv_office)
        rv_franchise = findViewById<RecyclerView>(R.id.rv_franchise)


        db = FirebaseDatabase.getInstance("https://apart.firebaseio.com/").reference
        db.get().addOnSuccessListener {
            db.addValueEventListener(object :
                ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    listItemList.clear()
                    for (model in 0 until 6){

                        haveList = snapshot.child("$model").child("mulBasic").child("haveList").value.toString()
                        lowPrice = snapshot.child("$model").child("mulBasic").child("lowPrice").value.toString()
                        sellDate = snapshot.child("$model").child("mulBasic").child("sellDate").value.toString()
                        gjpyeong = snapshot.child("$model").child("mulBasic").child("gjpyeong").value.toString()
                        yuchal = snapshot.child("$model").child("mulBasic").child("yuChal").value.toString()
                        sgNum = snapshot.child("$model").child("mulBasic").child("sgNum").value.toString()
                        mulUrl = snapshot.child("$model").child("mulBasic").child("sgNum").value.toString()
                        var vo = listItemVO(haveList,lowPrice,sellDate,gjpyeong,yuchal,sgNum)
                        listItemList.add(vo)
                    }
                    rv_apt.adapter?.notifyDataSetChanged()
                }
                override fun onCancelled(error: DatabaseError) {
                }
            })
        }.addOnFailureListener{
//            Log.e("error","error발생")
        }
        db2 = FirebaseDatabase.getInstance("https://jutaek.firebaseio.com/").reference
        db2.get().addOnSuccessListener {
            db2.addValueEventListener(object :
                ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    listItemList2.clear()
                    for (model in 0 until 6){
                        haveList = snapshot.child("$model").child("mulBasic").child("haveList").value.toString()
                        lowPrice = snapshot.child("$model").child("mulBasic").child("lowPrice").value.toString()
                        sellDate = snapshot.child("$model").child("mulBasic").child("sellDate").value.toString()
                        gjpyeong = snapshot.child("$model").child("mulBasic").child("gjpyeong").value.toString()
                        yuchal = snapshot.child("$model").child("mulBasic").child("yuChal").value.toString()
                        sgNum = snapshot.child("$model").child("mulBasic").child("sgNum").value.toString()
                        mulUrl = snapshot.child("$model").child("mulBasic").child("sgNum").value.toString()
                        var vo = listItemVO(haveList,lowPrice,sellDate,gjpyeong,yuchal,sgNum)
                        listItemList2.add(vo)
                    }
                    rv_house.adapter?.notifyDataSetChanged()
                }
                override fun onCancelled(error: DatabaseError) {
                }
            })
        }.addOnFailureListener{
//            Log.e("error","error발생")
        }
        db3 = FirebaseDatabase.getInstance("https://officetel.firebaseio.com/").reference
        db3.get().addOnSuccessListener {
            db3.addValueEventListener(object :
                ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    listItemList3.clear()
                    for (model in 0 until 6){
                        haveList = snapshot.child("$model").child("mulBasic").child("haveList").value.toString()
                        lowPrice = snapshot.child("$model").child("mulBasic").child("lowPrice").value.toString()
                        sellDate = snapshot.child("$model").child("mulBasic").child("sellDate").value.toString()
                        gjpyeong = snapshot.child("$model").child("mulBasic").child("gjpyeong").value.toString()
                        yuchal = snapshot.child("$model").child("mulBasic").child("yuChal").value.toString()
                        sgNum = snapshot.child("$model").child("mulBasic").child("sgNum").value.toString()
                        mulUrl = snapshot.child("$model").child("mulBasic").child("sgNum").value.toString()
                        var vo2 = listItemVO(haveList,lowPrice,sellDate,gjpyeong,yuchal,sgNum)
                        listItemList3.add(vo2)
                    }
                    rv_office.adapter?.notifyDataSetChanged()
                }
                override fun onCancelled(error: DatabaseError) {
                }
            })
        }.addOnFailureListener{
//            Log.e("error","error발생")
        }
        db4 = FirebaseDatabase.getInstance("https://sangga.firebaseio.com/").reference
        db4.get().addOnSuccessListener {
            db4.addValueEventListener(object :
                ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    listItemList4.clear()
                    for (model in 0 until 6){
                        haveList = snapshot.child("$model").child("mulBasic").child("haveList").value.toString()
                        lowPrice = snapshot.child("$model").child("mulBasic").child("lowPrice").value.toString()
                        sellDate = snapshot.child("$model").child("mulBasic").child("sellDate").value.toString()
                        gjpyeong = snapshot.child("$model").child("mulBasic").child("gjpyeong").value.toString()
                        yuchal = snapshot.child("$model").child("mulBasic").child("yuChal").value.toString()
                        sgNum = snapshot.child("$model").child("mulBasic").child("sgNum").value.toString()
                        mulUrl = snapshot.child("$model").child("mulBasic").child("sgNum").value.toString()
                        var vo = listItemVO(haveList,lowPrice,sellDate,gjpyeong,yuchal,sgNum)
                        listItemList4.add(vo)
                    }
                    rv_franchise.adapter?.notifyDataSetChanged()

                }
                override fun onCancelled(error: DatabaseError) {
                }
            })
        }.addOnFailureListener{
//            Log.e("error","error발생")
        }
        rv_apt.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_apt.setHasFixedSize(true)
        rv_apt.adapter = ProfileAdapter(listItemList)
        rv_apt.addItemDecoration(
            DividerItemDecoration(applicationContext, DividerItemDecoration.HORIZONTAL)
        )
        rv_house.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_house.setHasFixedSize(true)
        rv_house.adapter = ProfileAdapter2(listItemList2)
        rv_house.addItemDecoration(
            DividerItemDecoration(applicationContext, DividerItemDecoration.HORIZONTAL)
        )
        rv_office.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_office.setHasFixedSize(true)
        rv_office.adapter = ProfileAdapter3(listItemList3)
        rv_office.addItemDecoration(
            DividerItemDecoration(applicationContext, DividerItemDecoration.HORIZONTAL)
        )
        rv_franchise.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_franchise.setHasFixedSize(true)
        rv_franchise.adapter = ProfileAdapter4(listItemList4)
        rv_franchise.addItemDecoration(
            DividerItemDecoration(applicationContext, DividerItemDecoration.HORIZONTAL)
        )




        val iv1 = findViewById<ImageView>(R.id.iv1)
        val iv2 = findViewById<ImageView>(R.id.iv2)
        val iv3 = findViewById<ImageView>(R.id.iv3)
        val iv4 = findViewById<ImageView>(R.id.iv4)
        val map = findViewById<ImageView>(R.id.imageView16)
        val result = findViewById<ImageView>(R.id.imageView17)

        result.setOnClickListener {
            val intent = Intent(this, sell_result::class.java)
            startActivity(intent)
        }


        val user = findViewById<LottieAnimationView>(R.id.loading)
        user.setOnClickListener {
            val intent = Intent(this,Ask::class.java)
            startActivity(intent)
        }

        map.setOnClickListener {
            val intent = Intent(this, Mapactivity::class.java)
            startActivity(intent)
        }

        iv1.setOnClickListener {
            val intent = Intent(this, ApartmentList::class.java)
            startActivity(intent)
        }
        iv2.setOnClickListener {
            val intent2 = Intent(this, HouseList::class.java)
            startActivity(intent2)
        }
        iv3.setOnClickListener {
            val intent3 = Intent(this, OfficetelList::class.java)
            startActivity(intent3)
        }
        iv4.setOnClickListener {
            val intent4 = Intent(this, FranchiseList::class.java)
            startActivity(intent4)
        }

        val btn = findViewById<ImageView>(R.id.btn_banner)
        btn.setOnClickListener {
            val intent = Intent(this,Activitybanner::class.java)
            startActivity(intent)

        }

        // 화면 터치 막기
        fun blockLayoutTouch() {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }

        // 화면 터치 풀기
        fun clearBlockLayoutTouch() {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }


//        val rv2= findViewById<RecyclerView>(R.id.rv2)

//        rv2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        rv2.setHasFixedSize(true)
//
//        rv2.adapter = ProfileAdapter(profileList)
//
//        rv2.addItemDecoration(
//            DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
//        )
    }
}