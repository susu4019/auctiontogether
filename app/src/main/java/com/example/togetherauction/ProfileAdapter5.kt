package com.example.togetherauction

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.icu.util.TimeUnit.values
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ProfileAdapter5(val listItemList2: ArrayList<listItemVO2>) : RecyclerView.Adapter<ProfileAdapter5.CustomViewHolder>()
{  private lateinit var context: Context




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter5.CustomViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item5, parent, false)
        return CustomViewHolder(view).apply{
                val curPos : Int = adapterPosition
//                var item = listItemList2.get(curPos)
        }
    }


    override fun onBindViewHolder(holder: ProfileAdapter5.CustomViewHolder, position: Int) {

//        holder.haveList.text = (listItemList.get(position).haveList)
//        holder.lowPrice.text = ((listItemList.get(position).lowPrice))
//        holder.sellDate.text = (listItemList.get(position).sellDate)
//        holder.gjpyeong.text = (listItemList.get(position).gjpyeong)
//        holder.yuChal.text = (listItemList.get(position).yuChal)

//
//        var storage = FirebaseStorage.getInstance("gs://samjokoh-f42d4.appspot.com/")
//        val StorageReference = storage.getReference("사건폴더")


            val pathReference = listItemList2.get(position).ref
            pathReference.downloadUrl.addOnSuccessListener() { uri ->
                Glide.with(holder.iv)
                    .load(uri)
//                    .override(173, 158)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .centerCrop()
                    .into(holder.iv)
                Log.d("gdgdgdgdggdgd","$pathReference")
            }


    }
    override fun getItemCount(): Int {
        return listItemList2.size
    }
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val iv = itemView.findViewById<ImageView>(R.id.iv)
        val tv4 = itemView.findViewById<TextView>(R.id.tv4)
    }





    }

