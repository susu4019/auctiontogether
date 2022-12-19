package com.example.togetherauction


import androidx.versionedparcelable.VersionedParcelize
import com.google.firebase.storage.StorageReference

@VersionedParcelize
class listItemVO2(val ref : StorageReference, val num : String)

//haveList,lowPrice,sellDate,gjPyeong
