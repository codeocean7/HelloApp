package com.zealsoft.helloapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShowActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_lay)

        val rvStdList=findViewById<RecyclerView>(R.id.rvStudentList);

        val std=Student("Ashish","8888813277","Bsl")
        val std1=Student("Paean","8888813277","Bsl")
        val std2=Student("Dhiraj","8888813277","Bsl")
        val std3=Student("Amol","8888813277","Bsl")
        val std4=Student("SArvesh","8888813277","Bsl")

        val stdList=ArrayList<Student>()
        stdList.add(std)//0
        stdList.add(std1)//1
        stdList.add(std2)//2
        stdList.add(std3)//3
        stdList.add(std4)//4

        rvStdList.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvStdList.adapter=StudentAdapter(stdList,this)

    }
}