package com.zealsoft.helloapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DemoActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setting layout
        setContentView(R.layout.demo)

        val email=intent.getStringExtra("email")
        val age=intent.getIntExtra("age",0)

        val txtEmail=findViewById<TextView>(R.id.txtemail)

        txtEmail.text=email
    }

}