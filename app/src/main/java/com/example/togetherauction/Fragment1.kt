package com.example.togetherauction

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.togetherauction.databinding.ActivityMainBinding
//import com.example.togetherauction.databinding.Fragment1Binding
import com.google.firebase.database.*


class Fragment1(position: Any?, mg : Any?) : Fragment() {
    // TODO: Rename and change types of parameters
    var pos = position
    var mg = mg
//
//    private var _binding : Fragment1Binding? = null
//    private val binding get() = _binding!!
    lateinit var db: DatabaseReference

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lateinit var binding: ActivityMainBinding
        val view = inflater.inflate(R.layout.fragment_1,container,false)
        val sgNum : TextView = view.findViewById(R.id.sgNum)
        val sellDate : TextView = view.findViewById(R.id.sellDate)
        val gjpyeong : TextView = view.findViewById(R.id.gjpyeong)
        val lowPrice : TextView = view.findViewById(R.id.lowPrice)
        val haveList : TextView = view.findViewById(R.id.haveList)
        val icDeposit : TextView = view.findViewById(R.id.icDeposit)
        val DD : TextView = view.findViewById(R.id.DD)
        val openDate : TextView = view.findViewById(R.id.opneDate)
        val mgNum : TextView = view.findViewById(R.id.mgNum)
        val a : TextView = view.findViewById(R.id.mgNum)
        var st : String
        val ivmg : ImageView = view.findViewById(R.id.iv_mg)
        var btn1 : ImageView = view.findViewById(R.id.btn1)
        var btn2 : ImageView = view.findViewById(R.id.btn2)
        var btn3 : ImageView = view.findViewById(R.id.btn3)


        val message : String? = this.arguments?.getString("haveList")

        // 뷰 바인딩


        Log.d("pos",pos.toString());
        Log.d("pos",mg.toString());

        if (mg!!.equals("jutaek")){
            ivmg.setImageResource(R.drawable.jutaek_mini)
        }
        else if(mg!!.equals("officetel")){
            ivmg.setImageResource(R.drawable.officetel_mini)
        }
        else if(mg!!.equals("sangga")){
            ivmg.setImageResource(R.drawable.franchise_mini2)
        }





        db = FirebaseDatabase.getInstance("https://$mg.firebaseio.com/").reference
        db.get().addOnSuccessListener {
            db.addValueEventListener(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    sgNum.text = snapshot.child("$pos").child("mulBasic").child("sgNum").value.toString()
                    sellDate.text = snapshot.child("$pos").child("mulBasic").child("sellDate").value.toString()
                    gjpyeong.text = snapshot.child("$pos").child("mulBasic").child("gjpyeong").value.toString()
                    lowPrice.text = snapshot.child("$pos").child("mulBasic").child("lowPrice").value.toString()
                    DD.text = snapshot.child("$pos").child("mulBasic").child("court").value.toString()
                    val a = snapshot.child("$pos").child("mulBasic").child("mgNum").value.toString()
                    mgNum.text = "(물건번호 : $a)"
                    haveList.text = snapshot.child("$pos").child("mulBasic").child("haveList").value.toString()
                    btn1.setOnClickListener {
                        // Dialog만들기
                        val mDialogView = LayoutInflater.from(activity).inflate(R.layout.custom_dialog, null)
                        val tv_m : TextView = view.findViewById(R.id.tv_popup)
                        var a = snapshot.child("$pos").child("gjPyeongyy").child("gjPyeongyy").value.toString()
                        val mBuilder = androidx.appcompat.app.AlertDialog.Builder(requireActivity())
                            .setView(mDialogView)
                            .setTitle("                    감정평가요약")
                            .setMessage("$a")
                        val  mAlertDialog = mBuilder.show()
                        val noButton = mDialogView.findViewById<Button>(R.id.closeButton)
                        noButton.setOnClickListener {
                            mAlertDialog.dismiss()
                        }}
                        btn2.setOnClickListener {
                            // Dialog만들기
                            val mDialogView = LayoutInflater.from(activity).inflate(R.layout.custom_dialog, null)
                            val tv_m : TextView = view.findViewById(R.id.tv_popup)
                            var a = snapshot.child("$pos").child("listList").child("listList").value.toString()
                            val mBuilder = androidx.appcompat.app.AlertDialog.Builder(requireActivity())
                                .setView(mDialogView)
                                .setTitle("                    물건현황")
                                .setMessage("$a")
                            val  mAlertDialog = mBuilder.show()
                            val noButton = mDialogView.findViewById<Button>(R.id.closeButton)
                            noButton.setOnClickListener {
                                mAlertDialog.dismiss()
                            }}
                            btn3.setOnClickListener {
                                // Dialog만들기
                                val mDialogView = LayoutInflater.from(activity).inflate(R.layout.custom_dialog, null)
                                val tv_m : TextView = view.findViewById(R.id.tv_popup)
                                var a = snapshot.child("$pos").child("dateList").child("date").child("0").value.toString()
                                val mBuilder = androidx.appcompat.app.AlertDialog.Builder(requireActivity())
                                    .setView(mDialogView)
                                    .setTitle("                    기일내역")
                                    .setMessage("$a")
                                val  mAlertDialog = mBuilder.show()
                                val noButton = mDialogView.findViewById<Button>(R.id.closeButton)
                                noButton.setOnClickListener {
                                    mAlertDialog.dismiss()
                                }

                            }



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