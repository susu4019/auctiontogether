package com.example.togetherauction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.firebase.storage.FirebaseStorage

class prac22 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prac22)
        val iv = findViewById<ImageView>(R.id.iv)

        var storage = FirebaseStorage.getInstance("gs://samjokoh-f42d4.appspot.com/")
        val StorageReference = storage.getReference("사건폴더")

        val pathReference = StorageReference.child("2021타경7274").child("1.jpg")

        pathReference.downloadUrl.addOnSuccessListener { uri->
            Glide.with(iv.context)
                .load(uri)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                   .centerCrop()
                .into(iv)
        }

//        fun loadImage(imageView: ImageView, url: String){
//            val storage: FirebaseStorage = FirebaseStorage.getInstance("gs://samjokoh-f42d4.appspot.com")
//            val storageReference = storage.reference
//            val pathReference = storageReference.child("images/1.jpg")
//            pathReference.downloadUrl.addOnSuccessListener { uri ->
//                Glide.with(imageView.context)
//                    .load(uri)
//                    .diskCacheStrategy(DiskCacheStrategy.NONE)
//                    .centerCrop()
//                    .into(imageView)
//            }
//        }
    }
}