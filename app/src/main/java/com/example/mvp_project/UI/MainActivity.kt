package com.example.mvp_project.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp_project.R
import com.example.mvp_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
   }
}