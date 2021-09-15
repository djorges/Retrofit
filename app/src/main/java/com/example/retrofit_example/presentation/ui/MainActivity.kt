package com.example.retrofit_example.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.retrofit_example.R
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mAppBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        configSettings()
    }
    override fun onSupportNavigateUp():Boolean {
        return NavigationUI.navigateUp( navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }
    private fun configSettings() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Setup Navigation
        navController = supportFragmentManager.findFragmentById(R.id.nav_host)!!.findNavController()
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        NavigationUI.setupWithNavController(navigationView, navController)

        //Toolbar Up button. Set top level destinations.
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        mAppBarConfiguration = AppBarConfiguration.Builder(
                R.id.mainFragment)
                .setOpenableLayout(drawer)
                .build()
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration)
    }
}