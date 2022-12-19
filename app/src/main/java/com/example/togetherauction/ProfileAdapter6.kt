package com.example.togetherauction

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.firebase.storage.FirebaseStorage
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ProfileAdapter6 (val listItemList3 : ArrayList<listotiemVO3>) : RecyclerView.Adapter<ProfileAdapter6.CustomViewHolder>()
{  private lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter6.CustomViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item6, parent, false)
        return CustomViewHolder(view).apply{

        }
    }
    fun remove_gj(txt : String): String{
        val txt = txt.replace("광주광역시","")
        return txt
    }
    fun remove_yuchal(txt : String): String {
        if (txt.equals("신건")){
            return "없음"
        }
        else{
            val txt2 = txt.replace("유찰 ","")
            return txt2
        }
    }
    fun change_price(num1 : String): String {
        val num1 = num1.replace("원","")
        val num2 = num1.replace(",","")
        val num3 = num2.toLong()
        val a : Long = ((num3/100000000).toLong())
        val b : Long = ((num3-(a*100000000))/10000000)
        return ("$a"+"."+"$b"+"억")
    }
    fun remove_apt(txt : String): String {
        val txt = txt.replace("(아파트)","")
        val txt2 = txt.replace("(오피스텔)","")
        return txt2
    }
    fun remove_kor(txt1 : String): String{
        var txt1 = txt1.replace("10:00","")
        val txt2 = txt1.replace("매각법정","")
        val txt3 = txt2.replace("입찰법정","")
        val txt4 = txt3.replace("매각결정","")
        return txt4
    }


    override fun onBindViewHolder(holder: ProfileAdapter6.CustomViewHolder, position: Int) {
        holder.haveList.text = (listItemList3.get(position).haveList)
        holder.lowPrice.text = (listItemList3.get(position).lowPrice)
        holder.sellDate.text = (listItemList3.get(position).sellDate)
        holder.gjpyeong.text = (listItemList3.get(position).gjpyeong)
        holder.nakchal.text = listItemList3.get(position).nakchal

//        val testViewHolder = holder as RecyclerView.ViewHolder
//        var storage = FirebaseStorage.getInstance("gs://samjokoh-f42d4.appspot.com/")
//        val StorageReference = storage.getReference("사건폴더")
//        val pathReference = StorageReference.child("2021타경7779").child("1.jpg").toString()
//        holder.mulUrlIv.apply{
//            Glide.with(holder.mulUrlIv).load(listItemList.get(0).mulUrl)
//                .into(holder.mulUrlIv)
//        }

        var accnum = listItemList3.get(position).sgNum
        var storage = FirebaseStorage.getInstance("gs://samjokoh-f42d4.appspot.com/")
        val StorageReference = storage.getReference("사건폴더")
        val pathReference = StorageReference.child("$accnum").child("1.jpg")
        pathReference.downloadUrl.addOnSuccessListener() { uri->
            Glide.with(holder.mulUrlIv)
                .load(uri)
                .override(173,158)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .centerCrop()
                .into(holder.mulUrlIv)
        }

    }
    override fun getItemCount(): Int {
        return listItemList3.size
    }
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val haveList = itemView.findViewById<TextView>(R.id.tv_haveList)
        val lowPrice = itemView.findViewById<TextView>(R.id.tv_lowPrice)
        val sellDate = itemView.findViewById<TextView>(R.id.tv_sellDate)
        val gjpyeong = itemView.findViewById<TextView>(R.id.tv_gjpyeong)
        val nakchal = itemView.findViewById<TextView>(R.id.tv_nakchal)
        val mulUrlIv = itemView.findViewById<ImageView>(R.id.mulUrlIv)

    }



}
