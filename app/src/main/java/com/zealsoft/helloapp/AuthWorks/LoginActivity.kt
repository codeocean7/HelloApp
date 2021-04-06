package com.zealsoft.helloapp.AuthWorks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.zealsoft.helloapp.BottomNavActivity
import com.zealsoft.helloapp.R

class LoginActivity : AppCompatActivity()
{

    var edtEmail: EditText? = null
    var edtPassword: EditText? = null
    var btnLogin: Button? = null

    var firebaseAuth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtEmail=findViewById(R.id.edtEmail)
        edtPassword=findViewById(R.id.edtPassword)

        btnLogin=findViewById(R.id.btnLogin)

        firebaseAuth= FirebaseAuth.getInstance()

        btnLogin!!.setOnClickListener {
            val email=edtEmail!!.text.toString()
            val password=edtPassword!!.text.toString()

            loginUser(email,password)
        }
    }

    fun loginUser(email: String,pass: String){
        firebaseAuth!!.signInWithEmailAndPassword(email,pass)
            .addOnCompleteListener {
                Toast.makeText(this,"Login Successfull", Toast.LENGTH_LONG).show()

                val homeIntent= Intent(this,BottomNavActivity::class.java)
                startActivity(homeIntent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this,"Login Fail", Toast.LENGTH_LONG).show()

            }
    }
}