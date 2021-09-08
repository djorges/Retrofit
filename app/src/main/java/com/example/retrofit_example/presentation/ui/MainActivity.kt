package com.example.retrofit_example.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit_example.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}