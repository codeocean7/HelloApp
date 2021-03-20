package com.zealsoft.helloapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity()
{

    // Shared Preferenses

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val edtUserName=findViewById<EditText>(R.id.edtUserName)
        val edtPassword=findViewById<EditText>(R.id.edtPassword)

        val btnLogin=findViewById<Button>(R.id.btnLogin)


        val mPref=getSharedPreferences("MyPref",0)
        val prefEditor=mPref.edit();

        btnLogin.setOnClickListener {

            prefEditor.putString("UserName",edtUserName.text.toString())
            prefEditor.putBoolean("IsLogin",true)
            
            prefEditor.commit()

            val i=Intent(this,HomeActivity::class.java)
            startActivity(i)

        }
    }
}