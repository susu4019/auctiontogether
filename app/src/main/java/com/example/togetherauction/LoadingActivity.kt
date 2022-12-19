package com.example.togetherauction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.database.*

class LoadingActivity : AppCompatActivity() {
    var totalcount: Int = 0
    lateinit var haveList : String
    lateinit var lowPrice : String
    lateinit var gjpyeong : String
    lateinit var sellDate : String
    lateinit var yuchal : String
    lateinit var sgNum : String
    lateinit var  mulUrl : String
    var listItemList = ArrayList<listItemVO>()
    var listItemList2 = ArrayList<listItemVO>()
    var listItemList3 = ArrayList<listItemVO>()
    var listItemList4 = ArrayList<listItemVO>()
    lateinit var db: DatabaseReference
    lateinit var db2: DatabaseReference
    lateinit var db3: DatabaseReference
    lateinit var db4: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)



            db = FirebaseDatabase.getInstance("https://apart.firebaseio.com/").reference
                    db.get().addOnSuccessListener {
                        totalcount = Integer.parseInt(it.childrenCount.toString())
                db.addValueEventListener(object :
                    ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        listItemList.clear()
                        for (model in 0 until totalcount){
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

                    }
                    override fun onCancelled(error: DatabaseError) {
                    }
                })
            }.addOnFailureListener{
//            Log.e("error","error발생")
            }
                    db2 = FirebaseDatabase.getInstance("https://jutaek.firebaseio.com/").reference
                    db2.get().addOnSuccessListener {
                        totalcount = Integer.parseInt(it.childrenCount.toString())
                db2.addValueEventListener(object :
                    ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        listItemList2.clear()
                        for (model in 0 until totalcount){
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

                    }
                    override fun onCancelled(error: DatabaseError) {
                    }
                })
            }.addOnFailureListener{
//            Log.e("error","error발생")
            }
                    db3 = FirebaseDatabase.getInstance("https://officetel.firebaseio.com/").reference
                    db3.get().addOnSuccessListener {
                        totalcount = Integer.parseInt(it.childrenCount.toString())
                db3.addValueEventListener(object :
                    ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        listItemList3.clear()
                        for (model in 0 until totalcount){
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

                    }
                    override fun onCancelled(error: DatabaseError) {
                    }
                })
            }.addOnFailureListener{
//            Log.e("error","error발생")
            }
                    db4 = FirebaseDatabase.getInstance("https://sangga.firebaseio.com/").reference
                    db4.get().addOnSuccessListener {
                        totalcount = Integer.parseInt(it.childrenCount.toString())
                        val intent = Intent(this, MainActivity::class.java)
                db4.addValueEventListener(object :
                    ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        for (model in 0 until totalcount){
                            haveList = snapshot.child("$model").child("mulBasic").child("haveList").value.toString()
                            lowPrice = snapshot.child("$model").child("mulBasic").child("lowPrice").value.toString()
                            sellDate = snapshot.child("$model").child("mulBasic").child("sellDate").value.toString()
                            gjpyeong = snapshot.child("$model").child("mulBasic").child("gjpyeong").value.toString()
                            yuchal = snapshot.child("$model").child("mulBasic").child("yuChal").value.toString()
                            sgNum = snapshot.child("$model").child("mulBasic").child("sgNum").value.toString()
                            mulUrl = snapshot.child("$model").child("mulBasic").child("sgNum").value.toString()
                            var vo = listItemVO(haveList,lowPrice,sellDate,gjpyeong,yuchal,sgNum)
                            listItemList4.add(vo)

                            startActivity(intent)
                            finish()// Activity가 Stack구조로 쌓이는데

                        }

                    }
                    override fun onCancelled(error: DatabaseError) {
                    }
                })
            }.addOnFailureListener{
//            Log.e("error","error발생")
            }



    }
}