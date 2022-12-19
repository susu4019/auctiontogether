package com.example.togetherauction

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList


class sell_result : AppCompatActivity() {



    var totalcount: Int = 0

    lateinit var haveList : String
    lateinit var lowPrice : String
    lateinit var gjpyeong : String
    lateinit var sellDate : String
    lateinit var nakchal : String
    lateinit var sgNum : String

    lateinit var profileadapter : ProfileAdapter6
    var listItemList3 = ArrayList<listotiemVO3>()

    lateinit var db: DatabaseReference
    lateinit var  rv2 : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell_result)

        rv2 = findViewById<RecyclerView>(R.id.rv2)
        val arrow = findViewById<ImageView>(R.id.arrow)

        haveList = "매각(191,111,000원)"
        lowPrice = "광주광역시 북구 양산택지로37번길 78, 6층601호 (양산동,올리브아파트)"
        sellDate = "1.8억"
        gjpyeong = "2022.12.07"
        nakchal =  "2.1억"
        sgNum  = "2022타경71975 [전자]"
        val vo = listotiemVO3(haveList,lowPrice,sellDate,gjpyeong,nakchal,sgNum)
        listItemList3.add(vo)

        haveList = "매각(250,402,000원)"
        lowPrice = "광주광역시 서구 내방로 430, 2동 4층411호"
        sellDate = "2.1억"
        gjpyeong = "2022.10.27"
        nakchal = "3.2억"
        sgNum  = "2022타경71692 [전자]"
        val vo2 = listotiemVO3(haveList,lowPrice,sellDate,gjpyeong,nakchal,sgNum)
        listItemList3.add(vo2)

        haveList = "매각(622,000,000원)"
        lowPrice = "전라남도 나주시 중야1길 37, 103동 16층1601호 "
        sellDate = "5.7억"
        gjpyeong = "2022.12.07"
        nakchal = "8.2억"
        sgNum  = "2022타경69606 [전자]"
        val vo3 = listotiemVO3(haveList,lowPrice,sellDate,gjpyeong,nakchal,sgNum)
        listItemList3.add(vo3)

        haveList = "매각(249,901,400원)"
        lowPrice = "광주광역시 광산구 수등로258번길 46, 102동 15층1607호 (신창동,해광샹그릴라)"
        sellDate = "2.1억"
        gjpyeong = "2022.12.15"
        nakchal = "3.0억원"
        sgNum  = "2022타경69408 [전자]"
        val vo4 = listotiemVO3(haveList,lowPrice,sellDate,gjpyeong,nakchal,sgNum)
        listItemList3.add(vo4)
        haveList = "매각(1,055,555,000원)"
        lowPrice = "광주광역시 서구 상무대로911번길 42, 101동 4층404호 (쌍촌동,상무힐스테이트)"
        sellDate = "9.2억"
        gjpyeong = "2022.10.27"
        nakchal = "10.0억"
        sgNum  = "2022타경1662"
        val vo5 = listotiemVO3(haveList,lowPrice,sellDate,gjpyeong,nakchal,sgNum)
        listItemList3.add(vo5)



//        db = FirebaseDatabase.getInstance("https://sellresult.firebaseio.com/").reference
//        db.get().addOnSuccessListener {
//            db.addValueEventListener(object :
//                ValueEventListener{
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    listItemList3.clear()
//                        haveList = snapshot.child("0").child("saleBasic").child("haveList").child("0").value.toString()
//                        Log.d("leeeeeee",haveList.toString())
//                        lowPrice = snapshot.child("0").child("dateList").child("dateLowPrice").child("17").value.toString()
//                        sellDate = snapshot.child("0").child("dateList").child("date").child("17").value.toString()
//                        gjpyeong = snapshot.child("0").child("saleBasic").child("gjpyeong").value.toString()
//                        nakchal = snapshot.child("0").child("dateList").child("dategg").child("17").value.toString()
//                        sgNum  = snapshot.child("0").child("saleBasic").child("sgNum").value.toString()
//                        val vo = listotiemVO3(haveList,lowPrice,sellDate,gjpyeong,nakchal,sgNum)
//                        listItemList3.add(vo)
//                        haveList = snapshot.child("1").child("saleBasic").child("haveList").child("0").value.toString()
//                        lowPrice = snapshot.child("1").child("dateList").child("dateLowPrice").child("1").value.toString()
//                        sellDate = snapshot.child("1").child("dateList").child("date").child("2").value.toString()
//                        gjpyeong = snapshot.child("1").child("saleBasic").child("gjpyeong").value.toString()
//                        nakchal = snapshot.child("1").child("dateList").child("dategg").child("2").value.toString()
//                        sgNum  = snapshot.child("1").child("saleBasic").child("sgNum").value.toString()
//                        val vo2= listotiemVO3(lowPrice,sellDate,gjpyeong,nakchal,sgNum,haveList)
//                        listItemList3.add(vo2)
//                        haveList = snapshot.child("2").child("saleBasic").child("haveList").child("0").value.toString()
//                        lowPrice = snapshot.child("2").child("dateList").child("dateLowPrice").child("0").value.toString()
//                        sellDate = snapshot.child("2").child("dateList").child("date").child("3").value.toString()
//                        gjpyeong = snapshot.child("2").child("saleBasic").child("gjpyeong").value.toString()
//                        nakchal = snapshot.child("2").child("dateList").child("dategg").child("2").value.toString()
//                        sgNum  = snapshot.child("2").child("saleBasic").child("sgNum").value.toString()
//                        val vo3 = listotiemVO3(haveList,lowPrice,sellDate,gjpyeong,nakchal,sgNum)
//                        listItemList3.add(vo3)
//                        haveList = snapshot.child("3").child("saleBasic").child("haveList").child("0").value.toString()
//                        lowPrice = snapshot.child("3").child("dateList").child("dateLowPrice").child("3").value.toString()
//                        sellDate = snapshot.child("3").child("dateList").child("date").child("2").value.toString()
//                        gjpyeong = snapshot.child("3").child("saleBasic").child("gjpyeong").value.toString()
//                        nakchal = snapshot.child("3").child("dateList").child("dategg").child("2").value.toString()
//                        sgNum  = snapshot.child("3").child("saleBasic").child("sgNum").value.toString()
//                        val vo4 = listotiemVO3(haveList,lowPrice,sellDate,gjpyeong,nakchal,sgNum)
//                        listItemList3.add(vo4)
//                        haveList = snapshot.child("4").child("saleBasic").child("haveList").child("0").value.toString()
//                        lowPrice = snapshot.child("4").child("dateList").child("dateLowPrice").child("3").value.toString()
//                        sellDate = snapshot.child("4").child("dateList").child("date").child("3").value.toString()
//                        gjpyeong = snapshot.child("4").child("saleBasic").child("gjpyeong").value.toString()
//                        nakchal = snapshot.child("4").child("dateList").child("dategg").child("3").value.toString()
//                        sgNum  = snapshot.child("4").child("saleBasic").child("sgNum").value.toString()
//                        val vo5 = listotiemVO3(haveList,lowPrice,sellDate,gjpyeong,nakchal,sgNum)
//                        listItemList3.add(vo5)
//                        haveList = snapshot.child("5").child("saleBasic").child("haveList").child("0").value.toString()
//                        lowPrice = snapshot.child("5").child("dateList").child("dateLowPrice").child("3").value.toString()
//                        sellDate = snapshot.child("5").child("dateList").child("date").child("4").value.toString()
//                        gjpyeong = snapshot.child("5").child("saleBasic").child("gjpyeong").value.toString()
//                        nakchal = snapshot.child("5").child("dateList").child("dategg").child("4").value.toString()
//                        sgNum  = snapshot.child("5").child("saleBasic").child("sgNum").value.toString()
//                        var vo6 = listotiemVO3(haveList,lowPrice,sellDate,gjpyeong,nakchal,sgNum)
//                        listItemList3.add(vo6)
//                        haveList = snapshot.child("6").child("saleBasic").child("haveList").child("0").value.toString()
//                        lowPrice = snapshot.child("6").child("dateList").child("dateLowPrice").child("2").value.toString()
//                        sellDate = snapshot.child("6").child("dateList").child("date").child("2").value.toString()
//                        gjpyeong = snapshot.child("6").child("saleBasic").child("gjpyeong").value.toString()
//                        nakchal = snapshot.child("6").child("dateList").child("dategg").child("2").value.toString()
//                        sgNum  = snapshot.child("6").child("saleBasic").child("sgNum").value.toString()
//                        var vo7 = listotiemVO3(haveList,lowPrice,sellDate,gjpyeong,nakchal,sgNum)
//                        listItemList3.add(vo7)
//                        haveList = snapshot.child("7").child("saleBasic").child("haveList").child("0").value.toString()
//                        lowPrice = snapshot.child("7").child("dateList").child("dateLowPrice").child("2").value.toString()
//                        sellDate = snapshot.child("7").child("dateList").child("date").child("2").value.toString()
//                        gjpyeong = snapshot.child("7").child("saleBasic").child("gjpyeong").value.toString()
//                        nakchal = snapshot.child("7").child("dateList").child("dategg").child("1").value.toString()
//                        sgNum  = snapshot.child("7").child("saleBasic").child("sgNum").value.toString()
//                        var vo8 = listotiemVO3(haveList,lowPrice,sellDate,gjpyeong,nakchal,sgNum)
//                        listItemList3.add(vo8)
//                        rv2.adapter?.notifyDataSetChanged()
//                        Log.d("leeeeeee",listItemList3[1].haveList)
//                }
//                override fun onCancelled(error: DatabaseError) {
//                }
//            })
//        }.addOnFailureListener{
//           Log.e("error","error발생")
//        }

        rv2.adapter?.notifyDataSetChanged()
        rv2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv2.setHasFixedSize(true)
        rv2.adapter = ProfileAdapter6(listItemList3)
        rv2.addItemDecoration(
            DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
        )
        arrow.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
    //SearchView 텍스트 입력시 이벤트


}