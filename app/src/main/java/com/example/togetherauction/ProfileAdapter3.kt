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
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ProfileAdapter3 (val listItemList : ArrayList<listItemVO>) : RecyclerView.Adapter<ProfileAdapter3.CustomViewHolder>(),Filterable
{  private lateinit var context: Context
    //    private lateinit var accounts: List<listItemVO>
//    val mdDataListAll = ArrayList<listItemVO>(accounts)
//    var mAccounts:MutableList<listItemVO> = accounts as MutableList<listItemVO>
    var filteredPerson = ArrayList<listItemVO>()
    var itemFilter = ItemFilter()
    init {
        filteredPerson.addAll(listItemList)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter3.CustomViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item3, parent, false)
        return CustomViewHolder(view).apply{
            itemView.setOnClickListener {
                val curPos : Int = adapterPosition
                val intent = Intent(context, OfficetelDetail::class.java)
                var item = listItemList.get(curPos)
                var name = remove_gj(remove_apt(item.haveList))
                Toast.makeText(context, name + " Click event", Toast.LENGTH_SHORT).show();
                intent.putExtra("1",name)
                intent.putExtra("index",adapterPosition)
                intent.putExtra("mg","officetel")
                context.startActivity(intent)
            }
        }
    }
    fun remove_gj(txt : String): String{
        val txt = txt.replace("???????????????","")
        return txt
    }
    fun remove_yuchal(txt : String): String {
        if (txt.equals("??????")){
            return "??????"
        }
        else{
            val txt2 = txt.replace("?????? ","")
            return txt2
        }
    }
    fun change_price(num1 : String): String {
        val num1 = num1.replace("???","")
        val num2 = num1.replace(",","")
        val num3 = num2.toLong()
        val a : Long = ((num3/100000000).toLong())
        val b : Long = ((num3-(a*100000000))/10000000)
        return ("$a"+"."+"$b"+"???")
    }
    fun remove_apt(txt : String): String {
        val txt = txt.replace("(?????????)","")
        val txt2 = txt.replace("(????????????)","")
        return txt2
    }
    fun remove_kor(txt1 : String): String{
        var txt1 = txt1.replace("10:00","")
        val txt2 = txt1.replace("????????????","")
        val txt3 = txt2.replace("????????????","")
        val txt4 = txt3.replace("????????????","")
        return txt4
    }
    fun remove_kor2(txt1 : String): String{
        var txt1 = txt1.replace("10:00","")
        val txt2 = txt1.replace("????????????","")
        val txt3 = txt2.replace("????????????","")
        val txt4 = txt3.replace("????????????","")
        val txt5 = txt4.replace(".","-")
        var today = Calendar.getInstance()
        var sampleDate = "$txt5 00:00:00"
        var sf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        var date = sf.parse(sampleDate)
        var calcuDate = (today.time.time - date.time) / (60 * 60 * 24 * 1000)
        var calcuDate2 = calcuDate.toString()
        var day = calcuDate2.replace("+","")
        var day2 = day.replace("-","")
        var day3 = "$day2"+"??? ???"
        return day3
    }

    override fun onBindViewHolder(holder: ProfileAdapter3.CustomViewHolder, position: Int) {
        holder.haveList.text = remove_apt(listItemList.get(position).haveList)
        holder.lowPrice.text = change_price(listItemList.get(position).lowPrice)
        holder.sellDate.text = remove_kor2(listItemList.get(position).sellDate)
        holder.gjpyeong.text = change_price(listItemList.get(position).gjpyeong)
        holder.yuChal.text = remove_yuchal(listItemList.get(position).yuChal)
//        val testViewHolder = holder as RecyclerView.ViewHolder
//        var storage = FirebaseStorage.getInstance("gs://samjokoh-f42d4.appspot.com/")
//        val StorageReference = storage.getReference("????????????")
//        val pathReference = StorageReference.child("2021??????7779").child("1.jpg").toString()
//        holder.mulUrlIv.apply{
//            Glide.with(holder.mulUrlIv).load(listItemList.get(0).mulUrl)
//                .into(holder.mulUrlIv)
//        }
        var accnum = listItemList.get(position).sgNum
        var storage = FirebaseStorage.getInstance("gs://samjokoh-f42d4.appspot.com/")
        val StorageReference = storage.getReference("????????????")
        val pathReference = StorageReference.child("$accnum").child("1.jpg")
        pathReference.downloadUrl.addOnSuccessListener() { uri->
            Glide.with(holder.mulUrlIv)
                .load(uri)
                .override(173,158)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .centerCrop()
                .into(holder.mulUrlIv)
        }
//        Log.d("gdgdgdgdg1111",listItemList.get(0).mulUrl)
//        Log.d("gdgdgdgdg2222",pathReference)
//        Log.d("gdgdgdgdg2222",pathReference.equals(listItemList.get(0).mulUrl).toString())
//        Log.d("gdgdgdgdg3333",listItemList.get(1).mulUrl)
//        pathReference.downloadUrl.addOnSuccessListener { uri ->
//            Glide.with(holder.mulUrlIv)
//                .load(listItemList.get(position).mulUrl)
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .centerCrop()
//                .into(holder.mulUrlIv)
//        }
//        holder.mulUrlIv
//        var storage = FirebaseStorage.getInstance("gs://samjokoh-f42d4.appspot.com/")
//        val StorageReference = storage.getReference("????????????")
//        val pathReference = StorageReference.child("2021??????7274").child("1.jpg")
//        StorageReference()=listItemList.get(position).mulUrl
//        (StorageReference)(listItemList.get(position).mulUrl).downloadUrl.addOnSuccessListener { uri->
//            Glide.with(iv.context)
//                .load(uri)
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .centerCrop()
//                .into(iv)
//        }
    }
    override fun getItemCount(): Int {
        return listItemList.size
    }
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val haveList = itemView.findViewById<TextView>(R.id.tv_haveList)
        val lowPrice = itemView.findViewById<TextView>(R.id.tv_lowPrice)
        val sellDate = itemView.findViewById<TextView>(R.id.tv_sellDate)
        val gjpyeong = itemView.findViewById<TextView>(R.id.tv_gjpyeong)
        val yuChal = itemView.findViewById<TextView>(R.id.tv4)
        val mulUrlIv = itemView.findViewById<ImageView>(R.id.iv)
    }
    override fun getFilter(): Filter {
        return itemFilter
    }

    inner class ItemFilter : Filter() {
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filterString = charSequence.toString()
            val results = FilterResults()
            Log.d(TAG, "charSequence : $charSequence")
            //????????? ???????????? ????????? ?????? ?????? ????????? ??????
            val filteredList = ArrayList<listItemVO>()
            //???????????? ????????? ?????? ?????? ?????? -> ?????? ??????
            if (filterString.isEmpty()) {
                results.values = listItemList
                results.count = listItemList.size
                return results
            }  else {
                for (item in listItemList) {
                    if (item.haveList.contains(filterString) ) {
                        filteredList.add(item)
                    }
                }
            }
            results.values = filteredList
            results.count = filteredList.size
            return results
        }

        @SuppressLint("NotifyDataSetChanged")
        override fun publishResults(charSequence: CharSequence?, filteResults: FilterResults) {
            filteredPerson.clear()
            filteredPerson.addAll(filteResults.values as ArrayList<listItemVO>)
            notifyDataSetChanged()
        }
    }
}
