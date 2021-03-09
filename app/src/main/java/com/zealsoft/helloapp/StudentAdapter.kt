package com.zealsoft.helloapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(val stdList: List<Student>, val ctx: Context) : RecyclerView.Adapter<StudentAdapter.ItemViewHolder>()
{

    override fun getItemCount(): Int {
        return stdList.size //5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
       return ItemViewHolder(LayoutInflater.from(this.ctx).inflate(R.layout.std_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val std=stdList.get(position)

        holder.txtName.text=std.stdName
        holder.txtMobNo.text=std.mobNo
        holder.txtAddress.text=std.address

    }

    class  ItemViewHolder(v: View):RecyclerView.ViewHolder(v)
    {
        val txtName=v.findViewById<TextView>(R.id.txtName)
        val txtMobNo=v.findViewById<TextView>(R.id.txtMobNo)
        val txtAddress=v.findViewById<TextView>(R.id.txtAddress)
    }
}