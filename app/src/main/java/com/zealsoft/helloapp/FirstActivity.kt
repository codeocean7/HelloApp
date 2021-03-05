package com.zealsoft.helloapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)

        val btnStart=findViewById<Button>(R.id.btnStart)

        btnStart.setOnClickListener {
            //intent
            val i=Intent(this,DemoActivity::class.java).apply {
                putExtra("email","ashishbendale777@gmail.com")
                putExtra("mobNo","8888813277")
                putExtra("age",27)
            }
            startActivity(i)
        }

    }
}