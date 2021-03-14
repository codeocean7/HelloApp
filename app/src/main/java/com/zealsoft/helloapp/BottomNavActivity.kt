package com.zealsoft.helloapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavActivity :AppCompatActivity()
{
    private var mAppBarConfiguration: AppBarConfiguration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_nav_lay)
        val bottom_nav_home = findViewById<BottomNavigationView>(R.id.bottom_nav_home)

        mAppBarConfiguration = AppBarConfiguration.Builder(R.id.mnHome,
                R.id.mnNotify, R.id.mnProfile).build()
        val navController = Navigation.findNavController(this, R.id.host_fragment)

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration!!)
        NavigationUI.setupWithNavController(bottom_nav_home, navController)


    }
}