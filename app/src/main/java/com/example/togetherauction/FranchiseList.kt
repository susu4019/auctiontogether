package com.example.togetherauction

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.google.firebase.database.*

class FranchiseList : AppCompatActivity() {
    object Sortbyyu: Comparator<listItemVO>{
        fun yp(num1 : String): Int {
            if (num1 == "신건"){return 0}
            val num1 = num1.replace("유찰 ","")
            val num2 = num1.replace("회","")
            val num3 = num2.toInt()
            return num3
        }
        override fun compare(o1: listItemVO?, o2: listItemVO?): Int {
            return yp(o2!!.yuChal)!!.compareTo(yp(o1!!.yuChal))
        }
    }

    object SortbyLow : Comparator<listItemVO>{
        fun cp(num1 : String): Long {
            val num1 = num1.replace("원","")
            val num2 = num1.replace(",","")
            val num3 = num2.toLong()
            return num3
        }
        override fun compare(o1: listItemVO?, o2: listItemVO?): Int {
            return cp(o1!!.lowPrice)!!.compareTo(cp(o2!!.lowPrice))
        }
    }
    object Sortbygp : Comparator<listItemVO>{
        fun cp(num1 : String): Long {
            val num1 = num1.replace("원","")
            val num2 = num1.replace(",","")
            val num3 = num2.toLong()
            return num3
        }
        override fun compare(o1: listItemVO?, o2: listItemVO?): Int {
            return cp(o1!!.gjpyeong)!!.compareTo(cp(o2!!.gjpyeong))
        }
    }


    var totalcount: Int = 0
    lateinit var haveList : String
    lateinit var lowPrice : String
    lateinit var gjpyeong : String
    lateinit var sellDate : String
    lateinit var yuchal : String
    lateinit var sgNum : String
    lateinit var  mulUrl : String
    lateinit var profileadapter4 : ProfileAdapter4
    var listItemList = ArrayList<listItemVO>()
    lateinit var db: DatabaseReference
    lateinit var  rv : RecyclerView
    lateinit var sv: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_franchise_list)
        rv = findViewById<RecyclerView>(R.id.rv2)
        val arrow = findViewById<ImageView>(R.id.arrow)
        val count = findViewById<TextView>(R.id.count)
        sv = findViewById(R.id.sv)
        setAdapter()
        blockLayoutTouch()
        val date_gray = findViewById<Button>(R.id.date_gray)
        val low_gray = findViewById<Button>(R.id.low_gray)
        val yuchal_gray = findViewById<Button>(R.id.yuchal_gray)
        val gp_gray = findViewById<Button>(R.id.gp_gray)
        val loading = findViewById<LottieAnimationView>(R.id.loading)
        val loading_bar = findViewById<LottieAnimationView>(R.id.loading_bar)


//
//        var storage = FirebaseStorage.getInstance("gs://samjokoh-f42d4.appspot.com/")
//        var StorageReference = storage.getReference("사건폴더")

        // listItemlist를 처음부터 돌면서

//        val pathReference = StorageReference.child("2021타경7274").child("1.jpg")


//        Log.e("errorwe",storage.getReference("사건폴더").toString())

        sv.setOnQueryTextListener(searchViewTextListener)
        db = FirebaseDatabase.getInstance("https://sangga.firebaseio.com/").reference
        db.get().addOnSuccessListener {
            totalcount = Integer.parseInt(it.childrenCount.toString())
            db.addValueEventListener(object :
                ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    blockLayoutTouch()
                    loading.playAnimation()
                    loading_bar.playAnimation()
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
//                    for(i in 0 until listItemList.size){
//                        var a = listItemList[i].sgNum
//                        var pathReference = StorageReference.child("$a").child("1.jpg")
//                        listItemList[i].mulUrl = pathReference.toString()
//                    }


                    rv.adapter?.notifyDataSetChanged()
                    count.setText(""+listItemList.size+"건")
                    clearBlockLayoutTouch()
                    loading.visibility = View.GONE
                    loading_bar.visibility = View.GONE
                }
                override fun onCancelled(error: DatabaseError) {
                }
            })
        }.addOnFailureListener{
//            Log.e("error","error발생")
        }

        var isChecked = 0
        var isChecked2 = 0
        var isChecked3 = 0
        var isChecked4 = 0
        low_gray.setOnClickListener {
            rv.adapter?.notifyDataSetChanged()
            if(isChecked==0){
                low_gray.setBackgroundResource(R.drawable.low_black)
                gp_gray.setBackgroundResource(R.drawable.gp_gray)
                date_gray.setBackgroundResource(R.drawable.date_gray)
                yuchal_gray.setBackgroundResource(R.drawable.yuchal_gray)
                listItemList.apply{this.sortWith(ApartmentList.SortbyLow)}
                isChecked +=1
                isChecked2 =0
                isChecked3 =0
                isChecked4 =0
            }else if(isChecked==1){
                low_gray.setBackgroundResource(R.drawable.low_gray)
                isChecked -=1
                val comparator : Comparator<listItemVO> = compareBy { it.haveList }

            }
        }
        gp_gray.setOnClickListener {
            rv.adapter?.notifyDataSetChanged()
            if(isChecked2==0){
                low_gray.setBackgroundResource(R.drawable.low_gray)
                gp_gray.setBackgroundResource(R.drawable.gp_black)
                date_gray.setBackgroundResource(R.drawable.date_gray)
                yuchal_gray.setBackgroundResource(R.drawable.yuchal_gray)
                listItemList.apply{this.sortWith(ApartmentList.Sortbygp)}
                isChecked ==0
                isChecked2  +=1
                isChecked3 ==0
                isChecked4 ==0
            }else if(isChecked2==1){
                gp_gray.setBackgroundResource(R.drawable.gp_gray)
                isChecked2 -=1
            }
        }
        date_gray.setOnClickListener {
            rv.adapter?.notifyDataSetChanged()
            if(isChecked3==0){
                listItemList.apply{this.sortWith(ApartmentList.Sortbydate)}
                low_gray.setBackgroundResource(R.drawable.low_gray)
                gp_gray.setBackgroundResource(R.drawable.gp_gray)
                date_gray.setBackgroundResource(R.drawable.date_black)
                yuchal_gray.setBackgroundResource(R.drawable.yuchal_gray)
                isChecked ==0
                isChecked2 ==0
                isChecked3 +=1
                isChecked4 ==0
            }else if(isChecked3==1){
                date_gray.setBackgroundResource(R.drawable.date_gray)
                isChecked3 -=1
            }
        }
        yuchal_gray.setOnClickListener {
            rv.adapter?.notifyDataSetChanged()
            if(isChecked4==0){
                listItemList.apply{this.sortWith(ApartmentList.Sortbyyu)}
                low_gray.setBackgroundResource(R.drawable.low_gray)
                gp_gray.setBackgroundResource(R.drawable.gp_gray)
                date_gray.setBackgroundResource(R.drawable.date_gray)
                yuchal_gray.setBackgroundResource(R.drawable.yuchal_black)
                isChecked ==0
                isChecked2 ==0
                isChecked3 ==0
                isChecked4 +=1
            }else if(isChecked4==1){
                yuchal_gray.setBackgroundResource(R.drawable.yuchal_gray)
                isChecked4 -=1
            }
        }







        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv.setHasFixedSize(true)
        rv.adapter = ProfileAdapter4(listItemList)
        rv.addItemDecoration(
            DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
        )
        rv.setOnClickListener {
            val intent = Intent(applicationContext, HouseDetail::class.java)
            startActivity(intent)
        }
        arrow.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)

        }
    }
    //SearchView 텍스트 입력시 이벤트
    var searchViewTextListener: SearchView.OnQueryTextListener =
        object : SearchView.OnQueryTextListener {
            //검색버튼 입력시 호출, 검색버튼이 없으므로 사용하지 않음
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            //텍스트 입력/수정시에 호출
            override fun onQueryTextChange(s: String): Boolean {
                rv.adapter = profileadapter4
                profileadapter4.getFilter().filter(s)
                Log.d(ContentValues.TAG, "SearchVies Text is changed : $s")
                return false
            }
        }

    fun setAdapter(){
        //리사이클러뷰에 리사이클러뷰 어댑터 부착
//        rv.layoutManager = LinearLayoutManager(this)

        profileadapter4 = ProfileAdapter4(listItemList)
        rv.adapter = profileadapter4
    }
    // 화면 터치 막기
    fun blockLayoutTouch() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    // 화면 터치 풀기
    fun clearBlockLayoutTouch() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

}