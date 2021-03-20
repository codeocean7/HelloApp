package com.zealsoft.helloapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_layout)
        val txtUsrName=findViewById<TextView>(R.id.txtUserName)


        val mPref=getSharedPreferences("MyPref",0)

        txtUsrName.text=mPref.getString("UserName","")
    }
}