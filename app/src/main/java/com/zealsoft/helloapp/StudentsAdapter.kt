package com.zealsoft.helloapp

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentsAdapter(val ctx: Context, val studentList: ArrayList<Student>) : RecyclerView.Adapter<StudentsAdapter.ItemViewHolder>()
{

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
    }

    class ItemViewHolder(v: View) : RecyclerView.ViewHolder(v){

        val txtName=v.findViewById<TextView>(R.id.txtName)
        val txtCity=v.findViewById<TextView>(R.id.txtCity)
        val txtMobNo=v.findViewById<TextView>(R.id.txtMobNo)

    }
}