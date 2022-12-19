package com.example.togetherauction

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.togetherauction.R
//import com.example.togetherauction.databinding.Fragment1Binding
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import org.w3c.dom.Text


class Fragment2(position: Any?, mg : Any?) : Fragment() {
    // TODO: Rename and change types of parameters
    var pos = position
    var mg = mg

//    private var _binding : Fragment1Binding? = null
//    private val binding get() = _binding!!
    lateinit var db: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_2,container,false)
        val iv1 : TextView = view.findViewById(R.id.iv1)
        val iv2 : TextView = view.findViewById(R.id.iv2)
        val iv3 : TextView = view.findViewById(R.id.iv3)
        val iv4 : TextView = view.findViewById(R.id.iv4)
        val iv5 : TextView = view.findViewById(R.id.iv5)
        val iv6 : TextView = view.findViewById(R.id.iv6)
        val iv7 : TextView = view.findViewById(R.id.iv7)
        val iv8 : TextView = view.findViewById(R.id.iv8)
        val iv9 : TextView = view.findViewById(R.id.iv9)
        val iv10 : TextView = view.findViewById(R.id.iv10)
        val iv11 : TextView = view.findViewById(R.id.iv11)
        val iv12 : TextView = view.findViewById(R.id.iv12)
        val iv13 : TextView = view.findViewById(R.id.iv13)
        val iv14 : TextView = view.findViewById(R.id.iv14)
        val iv15 : TextView = view.findViewById(R.id.iv15)
        val iv16 : TextView = view.findViewById(R.id.iv16)
        val iv17 : TextView = view.findViewById(R.id.iv17)
        val iv18 : TextView = view.findViewById(R.id.iv18)
        val iv19 : TextView = view.findViewById(R.id.iv19)
        val iv20 : TextView = view.findViewById(R.id.iv20)
        val iv21 : TextView = view.findViewById(R.id.iv21)
        val iv22 : TextView = view.findViewById(R.id.iv22)
        val iv23 : TextView = view.findViewById(R.id.iv23)
        val iv24 : TextView = view.findViewById(R.id.iv24)
        val iv25 : TextView = view.findViewById(R.id.iv25)
        val iv26 : TextView = view.findViewById(R.id.iv26)
        val iv27 : TextView = view.findViewById(R.id.iv27)

        Log.d("pos",pos.toString());
        Log.d("pos",mg.toString());





        db = FirebaseDatabase.getInstance("https://$mg.firebaseio.com/").reference
        db.get().addOnSuccessListener {
            db.addValueEventListener(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    iv1.text = snapshot.child("$pos").child("nearSellAvg").child("three").child("1").value.toString()
                    iv2.text = snapshot.child("$pos").child("nearSellAvg").child("three").child("2").value.toString()
                    iv3.text = snapshot.child("$pos").child("nearSellAvg").child("three").child("3").value.toString()
                    iv4.text = snapshot.child("$pos").child("nearSellAvg").child("three").child("4").value.toString()
                    iv5.text = snapshot.child("$pos").child("nearSellAvg").child("three").child("5").value.toString()
                    iv6.text = snapshot.child("$pos").child("nearSellAvg").child("six").child("1").value.toString()
                    iv7.text = snapshot.child("$pos").child("nearSellAvg").child("six").child("2").value.toString()
                    iv8.text = snapshot.child("$pos").child("nearSellAvg").child("six").child("3").value.toString()
                    iv9.text = snapshot.child("$pos").child("nearSellAvg").child("six").child("4").value.toString()
                    iv10.text = snapshot.child("$pos").child("nearSellAvg").child("six").child("5").value.toString()
                    iv11.text = snapshot.child("$pos").child("nearSellAvg").child("twelve").child("1").value.toString()
                    iv12.text = snapshot.child("$pos").child("nearSellAvg").child("twelve").child("2").value.toString()
                    iv13.text = snapshot.child("$pos").child("nearSellAvg").child("twelve").child("3").value.toString()
                    iv14.text = snapshot.child("$pos").child("nearSellAvg").child("twelve").child("4").value.toString()
                    iv15.text = snapshot.child("$pos").child("nearSellAvg").child("twelve").child("5").value.toString()
                    iv15.text = snapshot.child("$pos").child("nearSellAvg").child("twelve").child("5").value.toString()
                    iv15.text = snapshot.child("$pos").child("nearSellAvg").child("twelve").child("5").value.toString()
                    iv15.text = snapshot.child("$pos").child("nearSellAvg").child("twelve").child("5").value.toString()

                    iv16.text = snapshot.child("$pos").child("nearSell").child("nearHaveList").child("0").value.toString()
                    iv17.text = snapshot.child("$pos").child("nearSell").child("nearGjpyeong").child("0").value.toString()
                    iv18.text = snapshot.child("$pos").child("nearSell").child("nearsellPrice").child("0").value.toString()
                    iv19.text = snapshot.child("$pos").child("nearSell").child("nearsellMon").child("0").value.toString()
                    iv20.text = snapshot.child("$pos").child("nearSell").child("nearHaveList").child("1").value.toString()
                    iv21.text = snapshot.child("$pos").child("nearSell").child("nearGjpyeong").child("1").value.toString()
                    iv22.text = snapshot.child("$pos").child("nearSell").child("nearsellPrice").child("1").value.toString()
                    iv23.text = snapshot.child("$pos").child("nearSell").child("nearsellMon").child("1").value.toString()
                    iv24.text = snapshot.child("$pos").child("nearSell").child("nearHaveList").child("2").value.toString()
                    iv25.text = snapshot.child("$pos").child("nearSell").child("nearGjpyeong").child("2").value.toString()
                    iv26.text = snapshot.child("$pos").child("nearSell").child("nearsellPrice").child("2").value.toString()
                    iv27.text = snapshot.child("$pos").child("nearSell").child("nearsellMon").child("2").value.toString()


                }



                override fun onCancelled(error: DatabaseError) {
                }
            })
        }.addOnFailureListener{
//            Log.e("error","error발생")
        }






























        return view
    }


}