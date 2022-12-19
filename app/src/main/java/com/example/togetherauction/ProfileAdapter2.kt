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

class ProfileAdapter2 (val listItemList : ArrayList<listItemVO>) : RecyclerView.Adapter<ProfileAdapter2.CustomViewHolder>(),Filterable
{  private lateinit var context: Context
    //    private lateinit var accounts: List<listItemVO>
//    val mdDataListAll = ArrayList<listItemVO>(accounts)
//    var mAccounts:MutableList<listItemVO> = accounts as MutableList<listItemVO>
    var filteredPerson = ArrayList<listItemVO>()
    var itemFilter = ItemFilter()
    init {
        filteredPerson.addAll(listItemList)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter2.CustomViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item2, parent, false)
        return CustomViewHolder(view).apply{
            itemView.setOnClickListener {
                val curPos : Int = adapterPosition
                val intent = Intent(context, HouseDetail::class.java)
                var item = listItemList.get(curPos)
                var name = remove_gj(remove_apt(item.haveList))
                Toast.makeText(context, name + " Click event", Toast.LENGTH_SHORT).show();
                intent.putExtra("1",name)
                intent.putExtra("index",adapterPosition)
                intent.putExtra("mg","jutaek")
                context.startActivity(intent)
            }
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
    fun remove_kor2(txt1 : String): String{
        var txt1 = txt1.replace("10:00","")
        val txt2 = txt1.replace("매각법정","")
        val txt3 = txt2.replace("입찰법정","")
        val txt4 = txt3.replace("매각결정","")
        val txt5 = txt4.replace(".","-")
        var today = Calendar.getInstance()
        var sampleDate = "$txt5 00:00:00"
        var sf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        var date = sf.parse(sampleDate)
        var calcuDate = (today.time.time - date.time) / (60 * 60 * 24 * 1000)
        var calcuDate2 = calcuDate.toString()
        var day = calcuDate2.replace("+","")
        var day2 = day.replace("-","")
        var day3 = "$day2"+"일 후"
        return day3
    }

    override fun onBindViewHolder(holder: ProfileAdapter2.CustomViewHolder, position: Int) {
        holder.haveList.text = remove_apt(listItemList.get(position).haveList)
        holder.lowPrice.text = change_price(listItemList.get(position).lowPrice)
        holder.sellDate.text = remove_kor2(listItemList.get(position).sellDate)
        holder.gjpyeong.text = change_price(listItemList.get(position).gjpyeong)
        holder.yuChal.text = remove_yuchal(listItemList.get(position).yuChal)
//        val testViewHolder = holder as RecyclerView.ViewHolder
//        var storage = FirebaseStorage.getInstance("gs://samjokoh-f42d4.appspot.com/")
//        val StorageReference = storage.getReference("사건폴더")
//        val pathReference = StorageReference.child("2021타경7779").child("1.jpg").toString()
//        holder.mulUrlIv.apply{
//            Glide.with(holder.mulUrlIv).load(listItemList.get(0).mulUrl)
//                .into(holder.mulUrlIv)
//        }
        var accnum = listItemList.get(position).sgNum
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
//        val StorageReference = storage.getReference("사건폴더")
//        val pathReference = StorageReference.child("2021타경7274").child("1.jpg")
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
            //검색이 필요없을 경우를 위해 원본 배열을 복제
            val filteredList = ArrayList<listItemVO>()
            //공백제외 아무런 값이 없을 경우 -> 원본 배열
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
