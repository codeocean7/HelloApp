package com.zealsoft.helloapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class StudentUpdateForm : AppCompatActivity()
{
    var edtName: EditText? =null
    var edtCity: EditText? =null
    var edtMobNo: EditText? =null

    var btnUpdate: Button? =null

    var fireDB: FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.student_update_form)

        edtName=findViewById(R.id.edtName)
        edtCity=findViewById(R.id.edtCity)
        edtMobNo=findViewById(R.id.edtMobNo)

        btnUpdate=findViewById(R.id.btnUpdate)

        fireDB= FirebaseFirestore.getInstance()

        val student=intent.getSerializableExtra("student") as Student

        edtName!!.setText(student.stdName)
        edtCity!!.setText(student.stdCity)
        edtMobNo!!.setText(student.stdMobNo)

        btnUpdate!!.setOnClickListener {
            val dataMap= hashMapOf<String,Any>(
                    "stdCity" to edtCity!!.text.toString()
            )
            fireDB!!.collection("STUDENTS")
                    .document(student.stdId)
                    .update(dataMap)
                    .addOnSuccessListener {
                        Toast.makeText(this,"Data Updated", Toast.LENGTH_LONG).show()
                        finish()
                    }.addOnFailureListener {
                        Toast.makeText(this,"Data Update Fail", Toast.LENGTH_LONG).show()
                    }
        }

    }
}