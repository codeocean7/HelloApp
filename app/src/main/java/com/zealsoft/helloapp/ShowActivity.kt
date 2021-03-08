package com.zealsoft.helloapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShowActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_lay)

        val txtName=findViewById<TextView>(R.id.txtName)
        val txtMobNo=findViewById<TextView>(R.id.txtMoNo)
        val txtAddress=findViewById<TextView>(R.id.txtAddress)

        val std=Student("Ashish","8888813277","Bsl")
        val std1=Student("Ashish","8888813277","Bsl")
        val std2=Student("Ashish","8888813277","Bsl")
        val std3=Student("Ashish","8888813277","Bsl")
        val std4=Student("Ashish","8888813277","Bsl")
        /*txtName.text = std.stdName
        txtMobNo.text = std.mobNo
        txtAddress.text = std.address*/

        val stdList=ArrayList<Student>()
        stdList.add(std)//0
        stdList.add(std1)//1
        stdList.add(std2)//2
        stdList.add(std3)//3
        stdList.add(std4)//4

        stdList.size //5

        stdList.removeAt(2)

        stdList.get(3)
    }
}