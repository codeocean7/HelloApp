package com.zealsoft.helloapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.splash_layout)

        val mPref=getSharedPreferences("MyPref",0)

        Handler().postDelayed({
               if(mPref.getBoolean("IsLogin",false)){
                    val homeIntent= Intent(this,HomeActivity::class.java)
                    startActivity(homeIntent)
                }else{
                    val loginIntent= Intent(this,LoginActivity::class.java)
                startActivity(loginIntent)
            }
        },3000)

    }
}