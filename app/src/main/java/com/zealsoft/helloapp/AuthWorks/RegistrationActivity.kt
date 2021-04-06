package com.zealsoft.helloapp.AuthWorks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.zealsoft.helloapp.R

class RegistrationActivity : AppCompatActivity()
{
    var edtEmail: EditText? = null
    var edtPassword: EditText? = null
    var btnReg: Button? = null

    var firebaseAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        edtEmail=findViewById(R.id.edtEmail)
        edtPassword=findViewById(R.id.edtPassword)

        btnReg=findViewById(R.id.btnRegister)

        firebaseAuth= FirebaseAuth.getInstance()

        btnReg!!.setOnClickListener {
            val email=edtEmail!!.text.toString()
            val password=edtPassword!!.text.toString()

            registerUser(email,password)
        }
    }

    fun registerUser(email: String,pass: String) {
        firebaseAuth!!.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener {
                    Toast.makeText(this,"Registration Successfull",Toast.LENGTH_LONG).show()

                    val loginIntent=Intent(this,LoginActivity::class.java)
                    startActivity(loginIntent)
                    finish()
                }.addOnFailureListener {

                    Toast.makeText(this,"Registration Fail",Toast.LENGTH_LONG).show()
                }
    }
}