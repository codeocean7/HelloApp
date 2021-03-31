package com.zealsoft.helloapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class StudentListActivity : AppCompatActivity()
{
    var rvStudents: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.student_list)

        rvStudents=findViewById(R.id.rvstudents)

        val fireDB=FirebaseFirestore.getInstance()

        fireDB.collection("STUDENTS")
                .get()
                .addOnSuccessListener { result ->
                    val stdList=ArrayList<Student>()
                    for(singleDoc in result){
                        val student: Student=singleDoc.toObject(Student::class.java);
                        student.stdId=singleDoc.id
                        stdList.add(student)
                    }
                    rvStudents!!.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                    rvStudents!!.adapter=StudentsAdapter(this,stdList)


                }
                .addOnFailureListener {
                    Toast.makeText(this,"Fail...",Toast.LENGTH_LONG).show()
                }
    }
}