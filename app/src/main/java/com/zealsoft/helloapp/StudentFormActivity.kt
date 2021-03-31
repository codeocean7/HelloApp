package com.zealsoft.helloapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class StudentFormActivity : AppCompatActivity() {

    var edtName: EditText? =null
    var edtCity: EditText? =null
    var edtMobNo: EditText? =null

    var btnSubmit: Button? =null
    var btnShow: Button? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.student_form)

        edtName=findViewById(R.id.edtName)
        edtCity=findViewById(R.id.edtCity)
        edtMobNo=findViewById(R.id.edtMobNo)

        val firestoreDB=FirebaseFirestore.getInstance()

        btnSubmit=findViewById(R.id.btnSubmit)
        btnShow=findViewById(R.id.btnShow)

        btnSubmit!!.setOnClickListener {
            val dataMap= hashMapOf<String,Any>(
                    "stdName" to edtName!!.text.toString(),
                    "stdCity" to edtCity!!.text.toString(),
                    "stdMobNo" to edtMobNo!!.text.toString(),
            )

            //insertion
            firestoreDB.collection("STUDENTS")
                    .add(dataMap)
                    .addOnSuccessListener {
                           Toast.makeText(this,"Data Added",Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this,"Data Added Fail",Toast.LENGTH_LONG).show()
                    }

        }


        btnShow!!.setOnClickListener {
            val showIntent=Intent(this,StudentListActivity::class.java)
            startActivity(showIntent)
        }
    }
}