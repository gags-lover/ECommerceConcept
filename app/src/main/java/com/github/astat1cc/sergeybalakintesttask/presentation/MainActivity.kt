package com.github.astat1cc.sergeybalakintesttask.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.astat1cc.sergeybalakintesttask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}