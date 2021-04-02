package com.zealsoft.helloapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import java.io.Serializable

class StudentsAdapter(val ctx: Context, val studentList: ArrayList<Student>) : RecyclerView.Adapter<StudentsAdapter.ItemViewHolder>()
{
    var firestoreDB: FirebaseFirestore? = null

    init {
        firestoreDB = FirebaseFirestore.getInstance()
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(ctx).inflate(R.layout.std_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val singleStudent=studentList.get(position)

        holder.txtName.text=singleStudent.stdName
        holder.txtCity.text=singleStudent.stdCity
        holder.txtMobNo.text=singleStudent.stdMobNo

        holder.btnDelete.setOnClickListener {
            firestoreDB!!.collection("STUDENTS")
                    .document(singleStudent!!.stdId)
                    .delete()
                    .addOnSuccessListener {
                        Toast.makeText(ctx,"Record Deleted",Toast.LENGTH_LONG).show()
                        studentList.removeAt(position)
                        notifyDataSetChanged()
                    }.addOnFailureListener {
                        Toast.makeText(ctx,"Deletion Fail",Toast.LENGTH_LONG).show()
                    }
        }

        holder.btnUpdate.setOnClickListener {
            val updateIntent=Intent(ctx,StudentUpdateForm::class.java).apply {
                putExtra("student",singleStudent as Serializable)
            }

            ctx.startActivity(updateIntent)
        }

    }

    class ItemViewHolder(v: View) : RecyclerView.ViewHolder(v){

        val txtName=v.findViewById<TextView>(R.id.txtName)
        val txtCity=v.findViewById<TextView>(R.id.txtCity)
        val txtMobNo=v.findViewById<TextView>(R.id.txtMobNo)

        val btnUpdate=v.findViewById<Button>(R.id.btnUpdate)
        val btnDelete=v.findViewById<Button>(R.id.btnDelete)

    }
}