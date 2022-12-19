package com.example.togetherauction

import androidx.versionedparcelable.VersionedParcelize
import com.google.firebase.storage.StorageReference

@VersionedParcelize
class listItemVO(val haveList:String, val lowPrice:String,val sellDate:String,val gjpyeong:String, val yuChal : String, val sgNum:String)

    //haveList,lowPrice,sellDate,gjPyeong
