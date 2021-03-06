package com.zealsoft.helloapp

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class ColorActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.color_layout)

        val rgColor=findViewById<RadioGroup>(R.id.rgColors)

        val backLayout=findViewById<LinearLayout>(R.id.backLayout)

        rgColor.setOnCheckedChangeListener { group, checkedId ->

            when(checkedId)
            {
                R.id.rbRed-> {
                    backLayout.setBackgroundColor(Color.RED)
                }
                R.id.rbGreen-> {
                    backLayout.setBackgroundColor(Color.GREEN)
                }
                R.id.rbBlue->{
                    backLayout.setBackgroundColor(Color.BLUE)
                }
            }
        }


    }
}