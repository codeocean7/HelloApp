package com.zealsoft.helloapp

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class DialogActivity :AppCompatActivity()
{
    //step 1
    val courseList= arrayOf("MCA","MSc","BCA","Bsc")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_layout)

        //step 2
        val btnSelect=findViewById<Button>(R.id.btnSelect)
        val txtCourse=findViewById<TextView>(R.id.txtCourse)

        //step 3
        btnSelect.setOnClickListener {

            //step 4
            val dialohBuilder=AlertDialog.Builder(this)

            //step 5
            dialohBuilder.setTitle("Select Course")
                    .setIcon(R.drawable.ic_home)
                    .setNeutralButton("Cancel",DialogInterface.OnClickListener { dialog, which ->
                        dialog.dismiss()
                    })
                    .setSingleChoiceItems(courseList,-1,DialogInterface.OnClickListener { dialog, position ->
                        txtCourse.text=courseList[position]
                        dialog.dismiss()
                    })

/*                    .setMultiChoiceItems(courseList,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->

                    })*/
                    .setCancelable(false)
                    //.setMessage("Hi..Hello...")

            //step 6
            dialohBuilder.create().show()
        }
    }
}