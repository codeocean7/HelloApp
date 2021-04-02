package com.zealsoft.helloapp

import java.io.Serializable

data class Student(var stdName: String = "",
                   var stdCity: String = "",
                   var stdMobNo: String = "",
                   var stdId: String = "" ) : Serializable {
}